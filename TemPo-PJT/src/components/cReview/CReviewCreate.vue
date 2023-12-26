<template>
  <div class="my-sub-con">
    <div class="my-flex d-flex align-items-center">
      <textarea
        id="content"
        v-model="cReview.content"
        class="form-control my-area"></textarea>
    <button type="button" class="my-btn" @click="createCReview">
      등록 <i class="bi bi-pencil-square"></i>
    </button>
    </div>
  </div>
</template>

<script setup>
import { ref, defineProps } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useCReviewStore } from "@/stores/cReview";
import { useUserStore } from "@/stores/user";

const storeCR = useCReviewStore();
const storeU = useUserStore();
const router = useRouter();
const goBack = () => {
  cReview.value.content = ""; // 내용 초기화
};
const props = defineProps({
  communityId: {
    type: Number,
    required: true,
  },
});
const cReview = ref({
  communityId: props.communityId,
  userId: storeU.loginUserId,
  content: "",
});
// const communityId = useRoute().params.communityId;

const emit = defineEmits(["update-cReview-list"]);

const createCReview = async () => {
  cReview.value.communityId = props.communityId;
  await storeCR.createCReview(cReview.value);
  cReview.value.content = ""; // 내용 초기화
  emit("update-cReview-list"); // 댓글 목록 갱신 이벤트 방출
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
}
.my-btn:hover {
	color: black;
	background-color: #9db2bf3d;
}
.my-flex > textarea {
  margin-right: 10px;
  border: 1px solid #d2d2d2;
}
.my-flex > button {
  height: 40px;
  flex-basis: 15%;
}
.my-sub-con {
  margin: 20px 0px 30px;
}
.my-area {
  height: 80px;
}
</style>
