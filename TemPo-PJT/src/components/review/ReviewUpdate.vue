<template>
  <div class="container my-con my-board">
    <div class="card mt-4">
      <div class="card-header title">게시글 수정</div>
        <div class="card-body">
          <div class="mb-3">
              <label for="title" class="form-label">제목</label>
              <input type="text" class="form-control" id="title" v-model="store.review.title" />
          </div>
          <div class="mb-3">
              <label for="content" class="form-label">내용</label>
              <textarea class="form-control" id="content" cols="30" rows="5" v-model="store.review.content"></textarea>
          </div>
          <div class="mb-3 d-flex justify-content-end">
              <button class="my-btn my-btn-modi" @click="updateReview">수정 <i class="bi bi-pencil-fill"></i></button>
              <button class="my-btn" @click="goBack">취소 <i class="bi bi-arrow-90deg-left"></i></button>
          </div>
        </div>
    </div>
  </div>
</template>

<script setup>
import { useReviewStore } from "@/stores/review";
import { useRouter } from "vue-router";
const store = useReviewStore();
const router = useRouter();
const updateReview = function () {
  store.updateReview();
};
const goBack = () => {
  router.back();
};
</script>

<style scoped>
.my-con {
	margin-bottom: 100px;
}
.my-board {
  width: 40%;
}
.title {
  font-size: 1.8rem;
  font-weight: 500;
  padding: 15px 0px;
  margin: 5px 20px;
  background-color: white;
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
</style>
