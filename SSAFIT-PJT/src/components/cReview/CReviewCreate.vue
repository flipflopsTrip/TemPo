<template>
  <div>
    <h5>댓글 작성</h5>
    <fieldset>
      <div>
        <textarea
          id="content"
          style="width: 80%; height: 100px"
          v-model="cReview.content"
        ></textarea>
      </div>
      <div>
        <button type="button" class="btn btn-primary" @click="createCReview">
          등록
        </button>
        <button type="button" class="btn btn-danger" @click="goBack">
          취소
        </button>
      </div>
    </fieldset>
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

<style scoped></style>
