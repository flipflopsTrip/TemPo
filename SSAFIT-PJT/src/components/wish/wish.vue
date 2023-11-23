<template>
  <div>
    <button @click="settWish" class="my-btn" :class="{ active: isWishh }">
      <span :class="{ animated: isWishh }">
        <i :class="isWishh ? 'bi bi-balloon-heart-fill active2' : 'bi bi-balloon-heart'"></i>
      </span>
    </button>
  </div>
</template>

<script setup>
//토글을 사용하여 storeW의 checkWish의 결과에 따라 버튼 활성화 상태를 결정하고,
//클릭 시 storeW의 setWish를 실행하고 버튼 활성화 상태를 변경하고 싶음.
import { ref, defineProps, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";
import { useWishStore } from "@/stores/wish";
import axios from "axios";

const storeU = useUserStore();
const storeW = useWishStore();
const route = useRoute();
const router = useRouter();
const props = defineProps({
  videoId: {
    type: Number,
    // required: true,
  },
});

const isWishh = ref(false);

onMounted(() => {
  //지금 로그인한 유저의 이 영상에 대한 찜 여부 불러오기
  storeW.checkWish(props.videoId, storeU.loginUserId);
  // isWishh.value = storeW.isWish.value;
});

const settWish = async function () {
  try {
    await axios.post(
      `http://localhost:8080/api-wish/wish/${props.videoId}?userId=${storeU.loginUserId}`
    );
    await storeW.checkWish(props.videoId, storeU.loginUserId);
    // isWishh.value = storeW.isWish.value; // storeW.isWish 값을 isWish에 업데이트
  } catch (err) {
    console.log("찜 상태 변경 오류", err);
  }
  isWishh.value = !isWishh.value;
};
// const settWish = async function () {
//   await storeW.setWish(props.videoId, storeU.loginUserId); //보낸다
//   isWishh.value = storeW.isWish;
//   console.log(
//     "버튼 클릭으로 settWish함수 실행: storeW.isWish=" + storeW.isWish
//   );
//   // storeW.checkWish(props.videoId, storeU.loginUserId);
// };
</script>

<style scoped>

.my-btn {
  color: #fff;
  border: none;
  width: 50px;
  height: 35px;
  border-radius: 12px;
  border: 2px solid #4b565c;
  background-color: white;
  display: flex;
  justify-content: center;
  align-items: center;
}
.my-btn:hover {
  background-color: #f5f5f5;
}
.my-btn i {
  font-size: 1.3rem;
  color: #4b565c;
}
.active {
  border: 2px solid #ff7777;
}
.active2 {
  color: #ff7777 !important;
}
.animated {
  animation: heartBeat 0.8s cubic-bezier(0.68, -0.55, 0.27, 1.55);
}
@keyframes heartBeat {
  0% {
    transform: scale(1);
  }
  50% {
    transform: scale(1.2);
  }
  100% {
    transform: scale(1);
  }
}
</style>
