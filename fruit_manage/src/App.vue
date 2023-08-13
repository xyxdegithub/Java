<template>
  <div id="app">

    <el-row>
      <el-col :span="24"><div class="grid-content bg-color" style="font-size: larger;font-weight: bolder;color: red">xyx水果店管理系统</div></el-col>
    </el-row>

    <div id="nav" >
      <router-link to="/add"><el-button type="primary" >添加数据</el-button></router-link> &nbsp
      <router-link to="/table2"> <el-button type="success" >数据管理</el-button></router-link> &nbsp
      <router-link to="/pie"><el-button type="info" >饼图</el-button></router-link> &nbsp
      <router-link to="/bar"><el-button type="warning" >柱状图</el-button></router-link>
    </div>

    <div style="border:0px solid red;width: 910px;height: 600px; margin:0 auto;">
      <router-view/>
    </div>
  </div>
</template>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 3px;
}

#nav {
  padding: 30px;
  margin: 0 auto;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.bg-color {
  background: #87ceeb;
}

</style>


<script setup>
</script>