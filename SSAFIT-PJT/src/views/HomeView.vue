<template>
  <div>
    <!-- <VideoView/> -->
    <VideoList />
    <!-- youtube api 용량 이슈로 주석 -->
    <!-- <VideoTempView/> -->
  </div>
</template>

<script setup>
import VideoList from "@/components/video/VideoList.vue";
import VideoTempView from "./VideoTempView.vue";
import VideoView from "./VideoView.vue";
</script>

<style scoped></style>
