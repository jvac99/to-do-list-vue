<template>
  <div>
    <header v-if="$slots.header">
      <slot name="header"></slot>
    </header>
    <main>
      <slot></slot>
    </main>
    <footer v-if="$slots.footer">
      <slot name="footer" :test="test"> </slot>
    </footer>
  </div>
</template>

<script lang="ts">
export default {
  name: "slots",
  data() {
    return {
      test: "Test",
    };
  },
};
</script>
