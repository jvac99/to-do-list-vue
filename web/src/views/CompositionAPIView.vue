<template>
  <div class="container">
    <p>Composition API, by {{ fullName }}</p>
    <form class="d-flex">
      <label>firstName:</label>
      <input type="text" v-model="user.firstName" />
      <label>lastName:</label>
      <input type="text" v-model="user.lastName" />
    </form>
    <p>{{ count }}</p>
    <button type="button" @click="sum">Sum</button>
    <CompositionAPI />
  </div>
</template>

<script lang="ts" setup>
import {
  computed,
  onBeforeMount,
  onBeforeUnmount,
  onMounted,
  onUnmounted,
  onUpdated,
  reactive,
  ref,
  watch,
  defineProps,
} from "vue";
import CompositionAPI from "../components/CompositionAPI.vue";

const props = defineProps({
  tasks: { type: Array<string>, required: false, default: () => [] },
  title: { type: String, required: false, default: "composition" },
});

console.log(JSON.stringify(props));
console.log("title: ", props.title);

const user = reactive({ firstName: "João", lastName: "Correia" });
let count = ref(0);
watch(user, () => console.log("Welcome"), { deep: true });
watch(
  () => user.firstName,
  () => console.log("oii")
);
const sum = () => {
  count.value += 1;
};

const fullName = computed(() => `${user.firstName} ${user.lastName}`);

// Lifecycle
onBeforeMount(() => console.log("onBeforeMount"));
onMounted(() => console.log("onMounted"));

onBeforeUnmount(() => console.log("onBeforeUnmount"));
onUnmounted(() => console.log("onUnmounted"));
onUpdated(() => console.log("onUpdated"));
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  gap: 10px;
  justify-content: space-between;
  align-items: center;
}

p {
  font-size: 18px;
  color: #666;
}

form {
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 10px;
  color: #666;
}
</style>
