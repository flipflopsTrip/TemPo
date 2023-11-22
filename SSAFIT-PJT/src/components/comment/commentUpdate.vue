<template>
  <div>
    <div v-if="storeC.isEditing">
      <fieldset>
        <legend>댓글 수정</legend>
        <div>
          <label for="content">내용 : </label>
          <textarea
            id="content"
            cols="50"
            rows="20"
            v-model="editableComment.content"
          ></textarea>
        </div>
        <div>
          <button @click="updateComment">수정</button>
          <button type="button" class="secondary" @click="goBack">취소</button>
        </div>
      </fieldset>
    </div>
  </div>
</template>

<script setup>
import { ref, watch, defineProps } from "vue";
import { useCommentStore } from "@/stores/comment";
import { useRouter } from "vue-router";

const props = defineProps({
  comment: {
    type: Object,
    required: true,
  },
}); //////////////

const storeC = useCommentStore();
const router = useRouter();
const editableComment = ref({ ...props.comment });

const updateComment = async () => {
  storeC.updateComment(editableComment.value);
  storeC.isEditing = false;
};
const goBack = () => {
  storeC.isEditing = false;
};
watch(
  () => props.comment,
  (newVal) => {
    editableComment.value = { ...newVal };
  }
);
</script>

<style scoped></style>
