<template>
  <h1>Options API</h1>
  <h5>{{ fullName }}</h5>
</template>

<script lang="ts">
export default {
  name: "OptionsAPIView",
  data() {
    return {
      user: {
        firstName: "João",
        lastName: "Correia",
        age: 24,
        log: true,
      },
    };
  },
  computed: {
    fullName() {
      return `${this.user.firstName} ${this.user.lastName}`;
    },
  },
  methods: {},
  mounted() {
    console.log("Mounted");
  },
};
</script>
