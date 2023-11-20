import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

export const useReviewStore = defineStore("review", () => {
  const REST_REVIEW_API = "http://localhost:8080/api-review/review"; //?

  //list
  const reviewList = ref([]);
  const getReviewList = function (videoId) {
    axios
      .get(`${REST_REVIEW_API}?videoId=${videoId}`)
      .then((response) => {
        reviewList.value = response.data;
      })
      .catch((err) => {console.log(err)});
  };

  //detail
  const review = ref({});
  const getReview = function (reviewId) {
    axios
      .get(`${REST_REVIEW_API}/${reviewId}`)
      .then((response) => {
        review.value = response.data;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  //create
  const createReview = function (review, videoId) {
    axios
      .post(`${REST_REVIEW_API}/${videoId}`, review)
      .then((response) => {
        router.push(`${response.data.reviewId}`);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  //update
  const updateReview = function () {
    axios
      .put(`${REST_REVIEW_API}`, review.value)
      .then((response) => {
        router.push(`${response.data.reviewId}`);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return {
    reviewList,
    getReviewList,
    review,
    getReview, //리뷰 상세
    createReview,
    updateReview,
  };
});