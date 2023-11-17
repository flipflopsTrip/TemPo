<template>
  <div>
    <div>운동 영상1</div>
    <template v-for="video in store.videoList">
      <div>
        <RouterLink :to="`/video/${video.videoId}`">{{
          video.title
        }}</RouterLink>
        <div>{{ video.fitpart }}</div>
        <div>조회수 {{ video.viewCnt }}</div>
      </div>
    </template>
  </div>
</template>

<script setup>
import { onMounted, computed } from "vue";
import { useVideoStore } from "@/stores/video";

import { useUserStore } from '@/stores/user';
const store = useVideoStore();

const uStore = useUserStore();

onMounted(() => {
  store.getVideoList();
});


</script>

<style scoped></style>
