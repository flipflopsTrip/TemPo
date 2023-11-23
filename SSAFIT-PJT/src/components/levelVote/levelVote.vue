<template>
  <div class="d-flex">

    <div class="vote-con">
      <fieldset>
        <div class="vote-title">운동 난이도는 어떠셨나요?</div>
        <div class="form-check vote-form" v-for="item in level" :key="item.id">
          <input
            class="form-check-input"
            type="radio"
            :id="item.id"
            name="level"
            :value="item.value"
            v-model="levelVote.level"
          />
          <label class="form-check-label" :for="item.id">{{ item.name }}</label>
        </div>
        <div class="d-flex justify-content-center">
          <button class="my-btn " @click="submit">제출 <i class="bi bi-clipboard-check"></i></button>
        </div>
      </fieldset>
    </div>

    <div class="d-flex flex-column">
      <div class="vote-result-item">
        <div>현재 운동 영상의 난이도는?</div>
        <div v-if="nowVideoLv != 0" class="alert alert-info">{{ nowVideoLv }} 점</div>
        <div v-else class="alert alert-warning">데이터 집계 중입니다</div>
      </div>
      <div class="vote-result-item" >
        <div>내가 생각하는 난이도</div>
        <div v-if="nowUserVote == 0" class="alert alert-warning">난이도를 아직 평가하지 않았습니다</div>
        <div v-else class="alert alert-info">
          이 영상에 대해 {{ nowUserVote }}점 평가를 주셨습니다
        </div>
      </div>
    </div>
    
  </div>
</template>

<script setup>
import { ref, defineProps, onMounted, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";
import { useLevelVoteStore } from "@/stores/levelVote";
import axios from "axios";

const storeU = useUserStore();
const storeLV = useLevelVoteStore();

const props = defineProps({
  videoId: {
    type: Number,
    // required: true,
  },
});

const levelVote = ref({
  userId: storeU.loginUserId,
  videoId: props.videoId,
  level: storeLV.userVoteRes,
});

// let nowVideoLv = ref(0);
let nowVideoLv = ref(storeLV.videoLevel);
let nowUserVote = ref(storeLV.userVoteRes);

onMounted(async () => {
  await storeLV.getUserVote(props.videoId, storeU.loginUserId);
  nowUserVote.value = storeLV.userVoteRes;
  storeLV.getVideoLevel(props.videoId);
});

const level = [
  { id: 1, value: 1, name: "매우 쉬움" },
  { id: 2, value: 2, name: "쉬움" },
  { id: 3, value: 3, name: "보통" },
  { id: 4, value: 4, name: "어려움" },
  { id: 5, value: 5, name: "매우 어려움" },
]; //난이도

const submit = async function () {
  await storeLV.createVote(levelVote.value);
  await storeLV.getUserVote(props.videoId, storeU.loginUserId);
  storeLV.getVideoLevel(props.videoId);
};

watch(
  () => storeLV.videoLevel,
  (newValue) => {
    nowVideoLv.value = newValue;
  },
  { immediate: true }
);
watch(
  () => storeLV.userVoteRes,
  (newValue) => {
    nowUserVote.value = newValue;
    levelVote.value.level = newValue;
  },
  { immediate: true }
);
</script>

<style scoped>
.vote-con {
  border: 1px solid #ccc;
  border-radius: 6px;
  margin-right: 20px;
}
.vote-title {
  padding: 3px 10px 10px;
  border-bottom: 1px solid #ccc;
  font-weight: 700;
}
.vote-form {
  margin-top: 10px;
}
/* .vote-result-item {
  border: 1px solid #ccc;
} */
fieldset {
  padding: 10px;
  border-radius: 5px;
}
.form-check {
  margin-bottom: 10px;
  margin-left: 12px;
}
.vote-result-item {
  margin-bottom: 20px;
}
.vote-result-item > div {
  font-weight: 600;
  margin-bottom: 5px;
}
.alert {
  padding: 10px;
  border-radius: 5px;
  margin-top: 10px;
}
.alert-info {
  background-color: #e5ecf2;
  border-color: #e5ecf2;
  color: #0c5460;
}
.alert-warning {
  background-color: #fff3cd;
  border-color: #ffeeba;
  color: #856404;
}
.my-btn {
  color: #4b565c;
	border: 1px solid #9DB2BF;
	border-radius: 6px;
	padding: 6px 8px;
  height: 32px;
  display: flex;
  align-items: center;
}
.my-btn:hover {
	color: black;
	background-color: #9db2bf3d;
}
.my-btn > i {
  margin-left: 2px;
}
</style>
