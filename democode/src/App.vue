<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-view/>
    <el-button>Default button</el-button>
    <el-button type="primary">Main button</el-button>
    <el-button type="text">Text button</el-button>
    <el-input-number v-model="num1" @change="handleChange" :min="1" :max="10"></el-input-number>
    <br/>
    <el-input placeholder="elinput">a</el-input>
    <input placeholder="input"/>
  </div>
</template>

<script>
export default {
  name: 'App',
  data () {
    return {
      num1: 1
    }
  },
  methods: {
    handleChange (value) {
      console.log(value)
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
