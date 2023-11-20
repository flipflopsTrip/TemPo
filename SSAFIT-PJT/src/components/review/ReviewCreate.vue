<template>
  <div>
    <h4>리뷰 작성</h4>
    <fieldset method="POST">
      <legend>등록</legend>
      <div>
        <label for="title">제목 : </label>
        <input type="text" id="title" v-model="review.title" />
      </div>
      <div>
        <label for="userId">작성자 : </label>
        <!-- 확인용으로 disabled 걸어놨음. 나중에 작성자 input 지우면 됨 -->
        <input type="text" id="userId" v-model="review.userId" disabled/>
      </div>
      <div>
        <label for="content">내용 : </label>
        <textarea
          id="content"
          cols="30"
          rows="10"
          v-model="review.content"
        ></textarea>
      </div>
      <div>
        <button @click="createReview">등록</button>
      </div>
    </fieldset>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRoute } from "vue-router";
import { useReviewStore } from "@/stores/review";
import {useUserStore} from "@/stores/user"

const storeR = useReviewStore();
const storeU = useUserStore(); //로그인한 유저의 아이디를 가져오기 위해서 추가

const review = ref({
  videoId: "",
  title: "",
  userId: storeU.loginUserId, //추가
  content: "",
});
const videoId = useRoute().params.videoId;
const createReview = function () {
  //stores의 review.js에서 createReview는 인자로 review와 videoId를 가짐
  review.value.videoId = videoId;
  storeR.createReview(review.value, videoId);
};
</script>

<style scoped></style>
