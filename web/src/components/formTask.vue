<template>
  <form class="add-task-container" @submit="addTaskClick">
    <input type="text" v-model="taskData.title" placeholder="Title" required />
    <textarea
      v-model="taskData.description"
      placeholder="Description"
      required
    />
    <select v-model="taskData.priority" required>
      <option disabled>Select the priority level</option>
      <option value="LOW">LOW</option>
      <option value="MEDIUM">MEDIUM</option>
      <option value="HIGH">HIGH</option>
    </select>
    <select v-model="taskData.status" required v-if="taskData.id">
      <option disabled>Select the state</option>
      <option value="BACKLOG">BACKLOG</option>
      <option value="DO">DO</option>
      <option value="DOING">DOING</option>
      <option value="DONE">DONE</option>
    </select>
    <button type="submit">{{ taskData.id ? "Edit" : "Save" }}</button>
  </form>
</template>

<script lang="ts">
export default {
  name: "FormTask",
  props: {
    taskData: Object,
  },
  emits: ["addTaskClick"],
  methods: {
    addTaskClick(e): void {
      e.preventDefault();

      console.log(this.taskData);
      if (this.taskData.title != "" || this.taskData.description != "") {
        const data = { ...this.taskData };

        this.$emit("addTaskClick", data);

        this.taskData.title = "";
        this.taskData.description = "";
        this.taskData.status = "BACKLOG";
        this.taskData.priority = "LOW";
        this.taskData.id = null;
      }
    },
  },
};
</script>

<style scoped lang="css">
.add-task-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: stretch;
  width: 50%;
  margin: 10px 0;
  row-gap: 10px;
  height: 100%;
}

.add-task-container textarea {
  resize: none;
}

.add-task-container textarea::placeholder,
.add-task-container input::placeholder,
.add-task-container textarea::placeholder {
  color: #eee;
}

.add-task-container input,
.add-task-container textarea,
.add-task-container select,
.add-task-container button {
  /* padding: 5px; */
  border: 0 none;
  background-color: #444;
  color: #eee;
  /* flex: 2; */
  /* height: 40px; */
  padding: 0 5px;
  border: none;
  border-radius: 5px;
}

.add-task-container button {
  border: 0 none;
  background-color: #444;
  color: #eee;
  border: none;
  border-radius: 5px;
}

.add-task-container input:focus,
.add-task-container textarea:focus,
.add-task-container select:focus,
.add-task-container button:focus {
  box-shadow: 0 0 0 0;
  border: 0 none;
  outline: 0;
}

/* .add-task-button-container {
  display: flex;
  justify-content: center;
  flex: 1;
} */

/* .add-task-button-container button {
  width: 100%;
} */
</style>
