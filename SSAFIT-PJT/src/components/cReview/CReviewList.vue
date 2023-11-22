<template>
  <div>
    <h3>댓글 목록</h3>
    <hr />
    <div
      class="input-group input-group-sm"
      role="group"
      style="text-align: left"
    >
      <table
        class="table table-striped table-bordered"
        border="1"
        width="800px"
        align="left"
      >
        <tr>
          <th class="text-center">번호</th>
          <th class="text-center">작성자</th>
          <th>내용</th>
          <th class="text-center">작성일</th>
        </tr>
        <tr v-for="(cReview, index) in storeCR.cReviewList" :key="cReview.cReviewId">
          <td class="text-center">{{ index + 1 }}</td>
          <td class="text-center">{{ cReview.userId }}</td>
          <td>{{ cReview.content }}</td>
          <td class="text-center">{{ cReview.regDate }}</td>

          <td>
            <div v-if="storeU.loginUserId === cReview.userId">
              <button @click="showUpdateForm(cReview)">수정</button>
              <button @click="showDeleteAlert(cReview)">삭제</button>
              <cReview-update
                v-if="editableCReviewId === cReview.cReviewId"
                :cReview="cReview"
              />&nbsp
            </div>
          </td>
        </tr>
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
<style scoped></style>
