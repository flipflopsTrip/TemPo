<template>
  <div>
    <div v-if="storeC.isEditing">
      <div>
        <textarea
          id="content"
          cols="30"
          rows="5"
          v-model="editableComment.content"
          class="form-control my-area"
        ></textarea>
        <button @click="updateComment" class="my-btn">수정</button>
        <button @click="goBack" class="my-btn">닫기</button>
      </div>
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
