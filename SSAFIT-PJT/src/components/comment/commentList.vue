<template>
  <div>
    <h3>댓글 목록</h3>
    <hr />
    <div
      class="input-group input-group-sm"
      role="group"
      style="text-align: left"
    >
      <table class="table table-hover">
        <tr>
          <th>번호</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>내용</th>
        </tr>
        <tr v-for="(comment, index) in storeC.commentList" :key="comment.commentId">
          <td>{{ index + 1 }}</td>
          <td>{{ comment.userId }}</td>
          <td>{{ comment.regDate }}</td>
          <td>{{ comment.content }}</td>
          <!--댓글 수정 버튼을 누르면 -->
          <td>
            <button @click="showUpdateForm(comment)">수정</button>
            <comment-update
              v-if="editableCommentId === comment.commentId"
              :comment="comment"
            />&nbsp
            <button @click="showDeleteAlert(comment)">삭제</button>
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script setup>
import { useCommentStore } from "@/stores/comment";
import { ref, onMounted, defineProps } from "vue";
import commentUpdate from "@/components/comment/commentUpdate.vue";
import axios from "axios";

const storeC = useCommentStore();

const props = defineProps(["reviewId"]);
const reviewId = Number(props.reviewId);

onMounted(() => {
  storeC.getCommentList();
});
const updateCommentList = async () => {
  await storeC.getCommentList(reviewId);
};

onMounted(updateCommentList);

const editableCommentId = ref(null);

const showUpdateForm = (comment) => {
  editableCommentId.value = comment.commentId;
  storeC.isEditing = true;
};

const showDeleteAlert = async (comment) => {
  let answer = confirm("댓글을 삭제할까요?");
  if (answer) {
    try {
      await axios.delete(
        `http://localhost:8080/api-comment/comment/${comment.commentId}`
      );
      await storeC.getCommentList(reviewId);
    } catch (error) {
      console.log(error);
    }
  }
};
</script>
<style scoped></style>
