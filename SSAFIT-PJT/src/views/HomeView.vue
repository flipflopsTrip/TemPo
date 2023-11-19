<template>
  <div>
    <!-- <VideoView/> -->
    <!-- youtube api 용량 이슈로 주석 -->
    <VideoList />
  </div>
</template>

<script setup>
import VideoList from "@/components/video/VideoList.vue";
import VideoView from "./VideoView.vue";
</script>

<style scoped></style>
