<template>
  <div>
    <h4>리뷰 수정</h4>
    <fieldset>
      <legend>등록</legend>
      <div>
        <label for="title">제목 : </label>
        <input type="text" id="title" v-model="store.review.title" />
      </div>
      <div>
        <label for="content">내용 : </label>
        <textarea
          id="content"
          cols="30"
          rows="10"
          v-model="store.review.content"
        ></textarea>
      </div>
      <div>
        <button type="button" class="btn btn-primary" @click="updateReview">
          수정
        </button>
        <button type="button" class="btn btn-secondary" @click="goBack">
          취소
        </button>
      </div>
    </fieldset>
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

<style scoped></style>
