<template>
  <div>
    <div>
      <!-- <div class="btn" :class="{ act: isWish }"> -->
      <!--찜하기 버튼 class="btn"-->
      <button type="button" @click="settWish" :class="{ active: isWishh }">
        <!-- <i v-if="isWishh" class="bi bi-heart-fill"></i> -->
        <i class="bi bi-heart"></i>
      </button>
    </div>
    <div>
      <!--찜한 사람-->
    </div>
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
  // console.log("찜 상태" + isWishh.value);
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
</script>

<style scoped>
button {
  width: 70px;
  height: 40px;
  border: none;
  background-color: rgb(250, 209, 209);
  color: aliceblue;
  border-radius: 20%;
}

.active {
  background-color: rgb(230, 73, 73);
  color: aliceblue;
}
</style>
