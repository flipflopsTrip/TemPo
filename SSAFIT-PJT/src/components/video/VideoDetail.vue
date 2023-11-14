<template>
  <div>
    <h2>Video&View</h2>
    <div>
      <div>{{ store.video.videoId }}</div>
      <div>{{ store.video.title }}</div>
      <div>{{ store.video.fitpart }}</div>
      <div>{{ store.video.youtuber }}</div>
      <div>{{ store.video.url }}</div>
      <div>{{ store.video.viewCnt }}</div>
    </div>
    <div>
      <h3>리뷰 목록</h3>
      <hr />
      <button>
        <RouterLink :to="{ name: 'ReviewCreate' }">ReviewCreate</RouterLink>
      </button>
      <table>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>조회수</th>
        </tr>
        <tr v-for="review in storeR.reviewList" :key="review.reviewId">
          <td>{{ review.reviewId }}</td>
          <td>
            <RouterLink :to="`/review/${review.reviewId}`">{{
              review.title
            }}</RouterLink>
          </td>
          <td>{{ review.userId }}</td>
          <td>{{ review.regDate }}</td>
          <td>{{ review.viewCnt }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script setup>
import { onMounted, computed } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useVideoStore } from "@/stores/video";
import { useReviewStore } from "../../stores/review";

const store = useVideoStore();
const storeR = useReviewStore();
const router = useRouter();
const route = useRoute();
onMounted(() => {
  storeR.getReviewList(route.params.videoId);
  store.getVideo(route.params.videoId);
});
</script>

<style scoped></style>
