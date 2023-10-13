<template>
  <div class="home">
    <MyTasks/>
  </div>
</template>

<script>

import MyTasks from './MyTasks.vue';

export default {
  name: 'HomeView',
  components: {
    MyTasks
  }
}
</script>
