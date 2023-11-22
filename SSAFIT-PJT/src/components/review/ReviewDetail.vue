<!--게시글 상세로 넘어가면 수정, 삭제, 목록 버튼-->
<template>
  <div>
    <div
      class="card"
      style="width: 70%; display: block; justify-content: center"
    >
      <div class="card-header" style="text-align: left">
        <div>{{ storeR.review.userId }}</div>
      </div>
      <div class="card-body">
        <div
          class="container"
          style="display: flex; justify-content: space-between"
        >
          <h3 class="card-title">{{ storeR.review.title }}</h3>
          <div class="container" style="display: block; text-align: right">
            <div>{{ storeR.review.regDate }}</div>
            <div>{{ storeR.review.viewCnt }}</div>
            <div>{{ storeR.review.content }}</div>
          </div>
        </div>
        <div style="display: flex; justify-content: space-between">
          <button type="button" class="btn btn-secondary" @click="goBack">
            뒤로가기
          </button>
          <div v-if="storeU.loginUserId === storeR.review.userId">
            <button type="button" class="btn btn-primary" @click="updateReview">
              수정</button
            >&nbsp&nbsp&nbsp&nbsp
            <button type="button" class="btn btn-danger" @click="deleteReview">
              삭제
            </button>
          </div>
        </div>
      </div>
    </div>
    <div>
      <commentCreate :reviewId="reviewId" /><!--댓글 작성-->
      <commentList
        :reviewId="reviewId"
        @update-comment-list="updateCommentList"
      /><!--댓글 목록-->
    </div>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { onMounted, ref } from "vue";
import axios from "axios";
import { useReviewStore } from "@/stores/review";
import { useCommentStore } from "@/stores/comment";
import { useUserStore } from "@/stores/user";
import commentCreate from "../comment/commentCreate.vue";
import commentList from "../comment/commentList.vue";

const storeR = useReviewStore();
const storeC = useCommentStore();
const storeU = useUserStore();
const route = useRoute();
const router = useRouter();
const reviewId = route.params.reviewId;

const goBack = () => {
  router.go(-1);
};

onMounted(() => {
  storeR.getReview(reviewId);
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

const updateCommentList = () => {
  storeC.getCommentList(reviewId);
};
</script>

<style scoped></style>
