<!--게시글 상세로 넘어가면 수정, 삭제, 목록 버튼-->
<template>
  <div>
    <h4>리뷰 상세</h4>
    <hr />
    <div>{{ store.review.title }}</div>
    <div>{{ store.review.userId }}</div>
    <div>{{ store.review.regDate }}</div>
    <div>{{ store.review.viewCnt }}</div>
    <div>{{ store.review.content }}</div>
    <button @click="updateReview">수정</button>
    <button @click="deleteReview">삭제</button>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { onMounted } from "vue";
import axios from "axios";
import { useReviewStore } from "@/stores/review";

const store = useReviewStore();
const route = useRoute();
const router = useRouter();
onMounted(() => {
  store.getReview(route.params.reviewId);
});
//update
const updateReview = function () {
  router.push({ name: "ReviewUpdate" });
};

//delete
const deleteReview = function () {
  axios
    .delete(`http://localhost:8080/api-review/review/${route.params.reviewId}`)
    .then(() => {
      router.push({
        name: "videoDetail",
        params: { videoId: store.review.videoId },
      });
    })
    .catch((err) => {
      console.log(err);
    });
};
</script>

<style scoped></style>
