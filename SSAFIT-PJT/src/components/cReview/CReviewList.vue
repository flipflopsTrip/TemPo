<template>
  <div class="my-sub-con">
    <div class="sub-title">댓글 목록</div>
    <div
      class="input-group input-group-sm"
      role="group"
      style="text-align: left"
    >
      <table class="table">
        <thead>
          <tr class="text-center">
            <th>번호</th>
            <th>작성자</th>
            <th>내용</th>
            <th>작성일</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(cReview, index) in storeCR.cReviewList" :key="cReview.cReviewId" class="text-center">
            <td>{{ index + 1 }}</td>
            <td>{{ cReview.userId }}</td>
            <td>{{ cReview.content }}</td>
            <td>{{ cReview.regDate }}</td>
            <td>
              <div v-if="storeU.loginUserId === cReview.userId">
                <button @click="showUpdateForm(cReview)" class="my-btn">&nbsp;<i class="bi bi-pencil-fill"></i>&nbsp;</button>
                <button @click="showDeleteAlert(cReview)" class="my-btn">&nbsp;<i class="bi bi-trash3-fill"></i>&nbsp;</button>
                <cReview-update
                  v-if="editableCReviewId === cReview.cReviewId"
                  :cReview="cReview"
                />
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { useCReviewStore } from "@/stores/cReview";
import { useUserStore } from "@/stores/user";
import { ref, onMounted, defineProps } from "vue";
import CReviewUpdate from "@/components/cReview/CReviewUpdate.vue";
import axios from "axios";

const storeCR = useCReviewStore();
const storeU = useUserStore();

const props = defineProps({
  communityId: {
    type: Number,
    required: true,
  },
});

onMounted(() => {
  storeCR.getCReviewList();
});
const updateCReviewList = async () => {
  await storeCR.getCReviewList(props.communityId);
};

onMounted(updateCReviewList);

const editableCReviewId = ref(null);

const showUpdateForm = (cReview) => {
  editableCReviewId.value = cReview.cReviewId;
  storeCR.isEditing = true;
};

const showDeleteAlert = async (cReview) => {
  let answer = confirm("댓글을 삭제할까요?");
  if (answer) {
    try {
      await axios.delete(
        `http://localhost:8080/api-cReview/cReview/${cReview.cReviewId}`
      );
      await storeCR.getCReviewList(props.communityId);
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
}
.my-btn:hover {
	color: black;
	background-color: #9db2bf3d;
}
table > thead > tr > th:nth-child(1) {
  width: 10%;
}
table > thead > tr > th:nth-child(2) {
  width: 10%;
}
table > thead > tr > th:nth-child(4) {
  width: 16%;
}
table > thead > tr > th:nth-child(5) {
  width: 20%;
}
.my-sub-con {
  margin: 20px 0px 200px;
}
</style>
