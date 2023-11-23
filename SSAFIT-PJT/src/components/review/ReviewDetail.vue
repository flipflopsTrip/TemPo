<!--게시글 상세로 넘어가면 수정, 삭제, 목록 버튼-->
<template>
  <div class="container my-con my-board">
    <div class="card my-card">
      <div class="card-header">
        <div class="sub-header d-flex justify-content-end">
          <span>{{ storeR.review.userId }}</span>
          <span>({{ storeR.review.regDate }})</span>
          <span><i class="bi bi-eye-fill"></i> {{ storeR.review.viewCnt }}</span>
        </div>
      </div>
      <div class="card-body my-card-body">
        <div class="card-title">
          {{ storeR.review.title }}
        </div>
        <div class="card-text">
          {{ storeR.review.content }}
        </div>
        <div
          v-if="storeU.loginUserId === storeR.review.userId"
          style="display: flex; justify-content: right"
        >
          <button
            class="my-btn my-btn-modi"
            @click="updateReview">
            수정 <i class="bi bi-pencil-fill"></i>
          </button>
          <button class="my-btn my-btn-del" 
            @click="deleteReview">
            삭제 <i class="bi bi-trash3-fill"></i>
          </button>
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

<style scoped>
.my-con {
  margin-top: 50px;
	margin-bottom: 100px;
}
.my-board {
  width: 40%;
}
.card-title {
  font-size: 1.4rem;
  font-weight: 500;
}
.card-text {
  font-size: 1.1rem;
}
.sub-header > span {
  margin: 0px 4px;
}
.my-btn {
  color: #4b565c;
	border: 1px solid #9DB2BF;
	border-radius: 6px;
	padding: 6px 8px;
	margin-right: 10px;
}
.my-btn:hover {
	color: black;
	background-color: #9db2bf3d;
}
.my-card {
  margin-bottom: 40px;
}
</style>
