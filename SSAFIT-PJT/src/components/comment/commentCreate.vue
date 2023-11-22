<template>
  <div>
    <h4>-----댓글 작성-------</h4>
    <fieldset>
      <legend>등록</legend>
      <div>
        <label for="userId">작성자 : </label>
        <input type="text" id="userId" v-model="comment.userId" disabled />
      </div>
      <div>
        <label for="content">내용 : </label>
        <textarea
          id="content"
          cols="30"
          rows="10"
          v-model="comment.content"
        ></textarea>
      </div>
      <div>
        <button @click="createComment">등록</button>
      </div>
    </fieldset>
  </div>
</template>

<script setup>
import { ref, defineProps } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";
import { useCommentStore } from "../../stores/comment";

// const storeR = useReviewStore();
const storeU = useUserStore();
const storeC = useCommentStore();
const props = defineProps({
  reviewId: {
    type: Number,
    required: true,
  },
});

const comment = ref({
  reviewId: props.reviewId,
  userId: storeU.loginUserId,
  content: "",
});
// const reviewId = useRoute().params.reviewId;

const emit = defineEmits(["update-comment-list"]);

const createComment = async () => {
  comment.value.reviewId = props.reviewId;
  await storeC.createComment(comment.value);
  comment.value.content = ""; // 내용 초기화
  emit("update-comment-list"); // 댓글 목록 갱신 이벤트 방출
};
</script>

<style scoped></style>
