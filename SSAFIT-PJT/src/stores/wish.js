import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

export const useWishStore = defineStore("wish", () => {
  const REST_WISH_API = "http://localhost:8080/api-wish/wish";

  //@GetMapping("/wish") : 찜 목록 조회 : userId 필요
  //마이페이지 찜한 영상 목록에서 사용
  const wishList = ref([]);
  const getWishList = (userId) => {
    axios
      .get(`${REST_WISH_API}`, { params: { userId } })
      .then((response) => {
        wishList.value = response.data;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  //@GetMapping("/wish/{id}") : 찜 했는지 확인 : videoId, userId 필요
  //isWish(@PathVariable int id, String userId)
  const isWish = ref(false); //처음 상태 확인
  const checkWish = function (videoId, userId) {
    axios
      .get(`${REST_WISH_API}/${videoId}`, { params: { userId: userId } })
      .then((response) => {
        if (response.data == 1) isWish.value = true;
        else isWish.value = false;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  //@PostMapping("/wish/{id}") : 찜하기 또는 취소
  //userId를 URL 쿼리 파라미터로 전송해야 함...
  const setWish = function (videoId, userId) {
    axios
      .post(`${REST_WISH_API}/${videoId}?userId=${userId}`)
      .then((response) => {
        isWish.value = response.data;
        // isWish.value = !isWish.value; //값 반전
      })
      .catch((err) => {
        console.error(err);
      });
  };

  return {
    wishList,
    getWishList,
    isWish,
    checkWish,
    setWish,
  };
});
