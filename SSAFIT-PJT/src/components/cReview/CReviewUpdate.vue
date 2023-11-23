<template>
  <div>
    <div v-if="storeCR.isEditing">
      <div>
        <textarea
          id="content"
          cols="30"
          rows="5"
          v-model="editableCReview.content"
          class="form-control my-area"
        ></textarea>
        <button @click="updateCReview" class="my-btn">수정</button>
        <button @click="goBack" class="my-btn">닫기</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, watch } from "vue";
import { useCReviewStore } from "@/stores/cReview";
import { defineProps } from "vue";
import axios from "axios";

const props = defineProps({
  cReview: {
    type: Object,
    required: true,
  },
});

const storeCR = useCReviewStore();
const editableCReview = ref({ ...props.cReview });

const updateCReview = function () {
  storeCR.updateCReview(editableCReview.value).then((res) => {
    console.log("수정 완료");
    storeCR.isEditing = false; //수정 상태 종료
  });
};
const goBack = () => {
  storeCR.isEditing = false;
};
watch(
  () => props.cReview,
  (newVal) => {
    editableCReview.value = { ...newVal };
  }
);
</script>

<style scoped>
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
.my-area {
  border: 1px solid #d2d2d2;
  width: 200px;
  margin: 10px 0px 5px;
}
</style>
