<template>
  <div class="task-container">
    <div class="task-title" @click="editTaskClick">
      <div
        v-bind:title="task.priority"
        v-bind:class="[
          'task-priority',
          'task-priority--' + task.priority.toLowerCase(),
        ]"
      />
      <p>
        {{ task.title }}
      </p>
    </div>
    <div class="buttons-container">
      <img
        src="../assets/icons8-trash-50.svg"
        class="delete-task-button"
        @click="deleteTaskClick"
      />
    </div>
  </div>
</template>

<script lang="ts">
export default {
  name: "Task",
  props: {
    task: Object,
  },
  emits: ["editTaskClick", "deleteTaskClick"],
  methods: {
    editTaskClick(e): void {
      e.preventDefault();
      this.$emit("editTaskClick", this.task);
    },
    deleteTaskClick(e): void {
      e.preventDefault();
      var response = confirm("Are you sure?");
      if (response === true) {
        this.$emit("deleteTaskClick", this.task.id);
      }
    },
  },
};
</script>

<style scoped lang="css">
.task-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  background-color: #444;
  margin: 8px 0;
  padding: 15px;
  border-radius: 5px;
  color: #eee;
  align-items: center;
  width: 100%;
}

.task-title {
  display: flex;
  align-items: center;
  column-gap: 5px;
  cursor: pointer;
  text-align: center;
}

.task-priority {
  height: 10px;
  width: 10px;
  shape-outside: circle();
  clip-path: circle();
}

.task-priority--low {
  background-color: green;
}

.task-priority--medium {
  background-color: yellow;
}

.task-priority--high {
  background-color: red;
}

.buttons-container {
  display: flex;
  justify-content: flex-end;
}

.delete-task-button {
  width: 15px;
}
</style>
