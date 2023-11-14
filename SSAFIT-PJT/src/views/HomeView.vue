<template>
  <div>
    <!-- <VideoView/> -->
    <VideoList />
    <VideoTempView/>
  </div>
</template>

<script setup>
import VideoList from "@/components/video/VideoList.vue";
import VideoTempView from "./VideoTempView.vue";
import VideoView from "./VideoView.vue";
</script>

<style scoped></style>
