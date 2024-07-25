<!-- src/components/Modal.vue -->
<template>
  <button @click="show = true">Show common modal</button>
  <div v-if="show" class="modal">
    <div class="modal-content">
      <span class="close" @click="show = false">&times;</span>
      <p>This is a common modal!</p>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
const show = ref(false);
</script>

<style>
.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(89, 92, 91, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
}

.modal-content {
  background-color: white;
  padding: 20px;
  border-radius: 5px;
}

.close {
  position: absolute;
  top: 10px;
  right: 10px;
  cursor: pointer;
  font-size: 20px;
}
</style>
