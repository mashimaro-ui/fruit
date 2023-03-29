<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/bar">Bar</router-link>|
      <router-link to="/pie">Pie</router-link>|
      <router-link to="/map">Map</router-link>|
      <router-link to="/table">Table</router-link>
    </div>
    <div style="border:0px solid red; width: 800px; height: 600px; margin-left: 400px;">
      <router-view/>
    </div>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
