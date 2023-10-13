<template>
  <div class="app-container">
    <Header />
    <formTask @add-task-click="addTaskClick" v-bind:taskData="taskData" />
    <div class="app-containers">
      <Tasks
        v-for="(value, key, index) in lists"
        v-bind:title="key"
        v-bind:tasks="value"
        @edit-task-click="editTaskClick"
        @delete-task-click="deleteTaskClick"
        v-bind:key="index"
      />
    </div>
  </div>
</template>

<script lang="ts">
import Header from "../components/Header.vue";
import { Priority, Status, TaskType } from "../components/TaskType";
import Tasks from "../components/Tasks.vue";
import formTask from "../components/formTask.vue";

export default {
  components: {
    formTask,
    Header,
    Tasks,
  },
  data() {
    return {
      tasks: [] as Array<TaskType>,
      lists: {
        BACKLOG: [] as Array<TaskType>,
        DO: [] as Array<TaskType>,
        DOING: [] as Array<TaskType>,
        DONE: [] as Array<TaskType>,
      } as Object,
      taskData: {
        title: "",
        description: "",
        status: "BACKLOG" as Status,
        priority: "LOW" as Priority,
      } as TaskType,
      oldTaskData: null,
    };
  },
  methods: {
    async getTasks(): Promise<void> {
      const req = await fetch("http://localhost:8080/task");

      this.tasks = await req.json();

      var listBacklog: Array<TaskType> = [];
      var listDo: Array<TaskType> = [];
      var listDoing: Array<TaskType> = [];
      var listDone: Array<TaskType> = [];

      this.tasks.forEach((task: TaskType) => {
        if (task.status === "BACKLOG") {
          listBacklog.push(task);
        } else if (task.status === "DO") {
          listDo.push(task);
        } else if (task.status === "DOING") {
          listDoing.push(task);
        } else {
          listDone.push(task);
        }
      });

      if (this.lists.BACKLOG !== listBacklog) this.lists.BACKLOG = listBacklog;

      if (this.lists.DO !== listDo) this.lists.DO = listDo;

      if (this.lists.DOING !== listDoing) this.lists.DOING = listDoing;

      if (this.lists.DONE !== listDone) this.lists.DONE = listDone;
    },

    async saveTask(dataJson: String): Promise<void> {
      const req = await fetch("http://localhost:8080/task", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: dataJson,
      });

      const res = await req.json();

      console.log(req);
      if (req.status == 201) {
        this.getTasks();
      }

      return;
    },

    async updateTask(dataJson: String): Promise<void> {
      const req = await fetch("http://localhost:8080/task", {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: dataJson,
      });

      const res = await req.json();

      console.log(req);
      if (req.status == 200) {
        this.getTasks();
      }

      return;
    },

    async deleteTask(id: String): Promise<void> {
      const req = await fetch(`http://localhost:8080/task/${id}`, {
        method: "DELETE",
        headers: { "Content-Type": "application/json" },
      });

      if (req.status === 200) {
        this.getTasks();
      }

      return;
    },

    addTaskClick(data: TaskType): void {
      const dataJson = JSON.stringify(data);
      const oldTaskDataJson = JSON.stringify(this.oldTaskData);

      if (dataJson !== oldTaskDataJson) {
        if (data.id) {
          this.updateTask(dataJson);
        } else {
          this.saveTask(dataJson);
        }
      }

      this.oldTaskData = null;
    },

    editTaskClick(value: TaskType): void {
      this.taskData = { ...value };
      this.oldTaskData = { ...value };
    },

    deleteTaskClick(value: String): void {
      this.deleteTask(value);
    },
  },
  mounted() {
    this.getTasks();
  },
};
</script>

<style scoped lang="css">
.app-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  padding: 20px;
  width: 100%;
  height: 100%;
}
.app-containers {
  display: flex;
  align-items: stretch;
  justify-content: center;
  /* gap: 5px; */
  width: 100%;
  flex-wrap: wrap;
}
</style>
