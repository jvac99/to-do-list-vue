<template>
  <div class="tasks-container">
    <h4>
      {{ this.title }}
    </h4>
    <Task
      v-for="(task, index) in tasks"
      v-bind:key="index"
      v-bind:task="task"
      @edit-task-click="editTaskClick"
      @delete-task-click="deleteTaskClick"
    />
  </div>
</template>

<script lang="ts">
import Task from "./Task.vue";
import { TaskType } from "./TaskType";

export default {
  name: "Tasks",
  components: {
    Task,
  },
  props: {
    tasks: Array<TaskType>,
    title: String,
  },
  emits: ["editTaskClick", "deleteTaskClick"],
  methods: {
    editTaskClick(value: TaskType): void {
      this.$emit("editTaskClick", value);
    },
    deleteTaskClick(value: String): void {
      this.$emit("deleteTaskClick", value);
    },
  },
};
</script>

<style scoped lang="css">
.tasks-container {
  /* max-width: 500px; */
  margin: 10px 4px;
  /* overflow: auto; */
  min-height: 400px;
  min-width: 280px;
  border: 2px solid #7fff00;
  padding: 10px 30px;
  border-radius: 10px;
}

.tasks-container h4 {
  color: #eee;
  padding: 10px;
}
</style>
