<template>
  <div>
    <h3>리뷰 목록</h3>
    <hr />
    <table class="table table-hover">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
      <tr v-for="(review, index) in storeR.reviewList" :key="review.reviewId">
        <td>{{ index + 1 }}</td>
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
</template>

<script setup>
import { useReviewStore } from "@/stores/review";
import { useUserStore } from "@/stores/user";
import { useRoute, useRouter } from "vue-router";
import { onMounted } from "vue";
import axios from "axios";

const storeR = useReviewStore();
const storeU = useUserStore();
const route = useRoute();
const router = useRouter();
onMounted(() => {
  storeR.getReviewList();
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
        params: { videoId: storeR.review.videoId },
      });
    })
    .catch((err) => {
      console.log(err);
    });
};
</script>
<!--store.vide-->
<style scoped></style>
