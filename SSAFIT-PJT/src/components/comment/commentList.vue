<template>
  <div class="my-sub-con">
    <table class="table mb-3">
      <thead class="my-thead">
        <tr class="text-center">
          <th>번호</th>
          <th>내용</th>
          <th>작성자</th>
          <th>작성일</th>
          <th></th>
        </tr>
      </thead>
      <tbody v-if="storeC.commentList.length > 0">
          <tr v-for="(comment, index) in storeC.commentList" :key="comment.commentId" class="text-center">
            <td>{{ index + 1 }}</td>
            <td>{{ comment.content }}</td>
            <td>{{ comment.userId }}</td>
            <td>{{ comment.regDate }}</td>
            <td>
              <div v-if="storeU.loginUserId === comment.userId" class="d-flex">
                <button @click="showUpdateForm(comment)" class="my-btn">&nbsp;<i class="bi bi-pencil-fill"></i>&nbsp;</button>
                <button @click="showDeleteAlert(comment)" class="my-btn">&nbsp;<i class="bi bi-trash3-fill"></i>&nbsp;</button>
                <comment-update
                  v-if="editableCommentId === comment.commentId"
                  :comment="comment"
                />
              </div>
            </td>
          </tr>
        </tbody>
      <tbody v-else>
        <tr class="text-center">
            <td colspan="5">등록된 리뷰가 없습니다</td>
          </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { useCommentStore } from "@/stores/comment";
import { useUserStore } from "@/stores/user";
import { ref, onMounted, defineProps } from "vue";
import commentUpdate from "@/components/comment/commentUpdate.vue";
import axios from "axios";

const storeC = useCommentStore();
const storeU = useUserStore();

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

<style scoped>
.sub-title {
  font-size: 1.2rem;
  font-weight: 500;
}
.my-btn {
  color: #4b565c;
	border: 1px solid #9DB2BF;
	border-radius: 6px;
	padding: 6px 8px;
	margin-right: 10px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
.my-btn:hover {
	color: black;
	background-color: #9db2bf3d;
}
table > thead > tr > th:nth-child(1) {
  width: 10%;
}
table > thead > tr > th:nth-child(3) {
  width: 10%;
}
table > thead > tr > th:nth-child(4) {
  width: 20%;
}
table > thead > tr > th:nth-child(5) {
  width: 10%;
}
.my-sub-con {
  margin: 20px 0px 200px;
}
tr.my-hover:hover td {
	background-color: #9db2bf28;
}
.my-btn {
  color: #4b565c;
	border: 1px solid #9DB2BF;
	border-radius: 6px;
	padding: 6px 8px;
	margin-right: 10px;
  text-decoration: none;
  background-color: #f0f0f0;
}
.my-btn:hover {
	color: black;
	background-color: #9db2bf3d;
}
.my-thead {
  border-bottom: 1px solid #ccc;
	border-top: 2px solid #9DB2BF;
	padding: 2px 10px;
}
thead th {
  background-color: #e5ecf2;
}
tbody > tr:last-child {
  border-bottom: 2px solid #9DB2BF;
}
</style>
