<template>
  <div>
    <TheHeaderNav/>
    <RouterView/>
  </div>
</template>

<script setup>
import TheHeaderNav from '@/components/common/TheHeaderNav.vue';
import {RouterView} from 'vue-router'
</script>

<style scoped>
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
</style>