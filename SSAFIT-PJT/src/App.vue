<template>
  <div id="app">
    <TheHeaderNav/>
    <RouterView/>
    <TheFooter/>
  </div>
</template>

<script setup>
import TheHeaderNav from '@/components/common/TheHeaderNav.vue';
import {RouterView} from 'vue-router'
import TheFooter from '@/components/common/TheFooter.vue';
</script>

<style scoped>
  html, body {
      margin: 0;
      padding: 0;
      height: 100%;
  }
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    list-style: none;
    font-family: Arial, Helvetica, sans-serif;
  }
  .text-center {
    text-align: center;
  }
  #app {
    min-height: 100%;
    position: relative;
  }
  
</style>