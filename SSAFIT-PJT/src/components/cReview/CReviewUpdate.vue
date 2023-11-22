<template>
  <div>
    <div v-if="storeCR.isEditing">
      <fieldset>
        <legend>댓글 수정</legend>
        <div>
          <label for="content">내용 : </label>
          <textarea
            id="content"
            cols="30"
            rows="10"
            v-model="editableCReview.content"
          ></textarea>
        </div>
        <div>
          <button @click="updateCReview">수정</button>
          <button @click="goBack">취소</button>
        </div>
      </fieldset>
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
}); ///////////////////

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

<style scoped></style>
