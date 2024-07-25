<template>
  <nav>
    <router-link to="/">Home</router-link>
    <!-- <router-link to="/about">About</router-link> -->
    <router-link to="/tecktalk">Teck Talk</router-link>
  </nav>
  <router-view />
</template>

<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
} */

nav {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

nav a {
  padding: 30px;
  font-weight: bold;
  color: #ffffff;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
