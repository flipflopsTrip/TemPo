<template>
  <!--마이페이지에서 내가 찜한 영상 목록-->
  <div class="container">
    <div class="title">찜한 영상 목록</div>
    <table class="table">
      <thead>
        <tr class="text-center">
          <th>번호</th>
          <th>제목</th>
          <th>운동 부위</th>
          <th>찜한 날짜</th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="(wishVideo, index) in storeW.wishList"
          :key="wishVideo.wishId"
          class="text-center my-hover"
        >
          <td>{{index + 1 }}</td>
          <td>
            <RouterLink
              :to="{
                name: 'videoDetail',
                params: { videoId: wishVideo.videoId },
              }"
              style="color: black; text-decoration: none"
            >
              {{ wishVideo.title }}</RouterLink
            >
          </td>
          <td>{{ wishVideo.fitpart }}</td>
          <!--부위를 가져와-->
          <td>{{ wishVideo.regDate }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref, onMounted, defineProps } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useWishStore } from "@/stores/wish";
import { useUserStore } from "@/stores/user";
import { useVideoStore } from "@/stores/video";

import axios from "axios";
const router = useRouter();
const route = useRoute();
// const store = useVideoStore();
const storeW = useWishStore();
const storeU = useUserStore();

onMounted(() => {
  // await store.getVideoList(); //전ㅊ
  storeW.getWishList(storeU.loginUserId); //먼저
  console.log(storeW.wishList);
  // if (storeW.wishList.value && storeW.wishList.value.length === 0) {
  //   console.log("찜 목록이 비어 있음");
  // } else {
  //   console.log("찜 목록:", storeW.wishList.value);
  // }
});
</script>

<style scoped>
.container * {
	letter-spacing: -0.4px;
}
.title {
	display: inline-block;
	font-size: 1.6rem;
	font-weight: 500;
  margin-bottom: 20px;
	background: linear-gradient(to top, #ffdc30df 15%, transparent 15%);
}
tr.my-hover:hover td {
	background-color: rgba(192, 214, 232, 0.086);
}
</style>
