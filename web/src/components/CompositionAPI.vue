<template>
  <div class="container">
    <p>{{ fullName }}</p>
    <p>{{ count }}</p>
    <button type="button" @click="sum">Sum</button>
  </div>
</template>

<script lang="ts">
import { computed, reactive, ref, watch } from "vue";

export default {
  name: "compositionAPI",
  components: {},
  props: {
    tasks: { type: Array<string>, required: false, default: () => [] },
    title: { type: String, required: false, default: "composition" },
  },
  setup(props) {
    console.log(JSON.stringify(props));
    console.log("title: ", props.title);
    const user = reactive({ firstName: "João", lastName: "Correia" });
    let count = ref(0);
    watch(count, (newValue, oldValue) =>
      console.log(oldValue, " -> ", newValue)
    );

    const sum = () => {
      count.value += 1;
    };

    const fullName = computed<string>(() => {
      return `${user.firstName} ${user.lastName}`;
    });

    return { user, count, sum, fullName };
  },
};
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
