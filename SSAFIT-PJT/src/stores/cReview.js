import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

export const useCReviewStore = defineStore("cReview", () => {
  const REST_CREVIEW_API = "http://localhost:8080/api-cReview/cReview";

  //list
  const cReviewList = ref([]);
  const getCReviewList = async (communityId) => {
    try {
      const response = await axios.get(`${REST_CREVIEW_API}`, {
        params: { id: communityId },
      });
      cReviewList.value = response.data;
    } catch (error) {
      console.log(error);
    }
  };

  //detail
  const cReview = ref({});
  const getCReview = function (cReviewId) {
    axios
      .get(`${REST_CREVIEW_API}/${cReviewId}`)
      .then((response) => {
        cReview.value = response.data;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  //create
  const createCReview = async (cReview) => {
    try {
      await axios.post(REST_CREVIEW_API, cReview).then((res) => {
        getCReviewList(cReview.communityId);
      });
    } catch (err) {
      console.log(err);
    }
  };

  const isEditing = ref(false); //수정폼 숨김 관리

  //update
  const updateCReview = (cReview) => {
    axios.put(`${REST_CREVIEW_API}`, cReview).then(() => {
      getCReviewList(cReview.communityId);
      isEditing.value = false;
    });
  };

  const showEditForm = () => {
    isEditing.value = true;
  };
  const hideEditForm = () => {
    isEditing.value = false;
  };

  const updateList = function () {
    axios.replace(`${REST_CREVIEW_API}`, {
      params: { id: communityId },
    });
    cReviewList.value = response.data;
  };

  //특정 회원의 자유게시판 댓글 목록
  const myCommunityReviewList = ref([]);
  const getMyCommunityReview = function(userId) {
    axios
      .get(`http://localhost:8080/api-cReview/myCReview/${userId}`)
      .then((res)=>{
        myCommunityReviewList.value = res.data;
      })
      .catch((err)=>{console.log(err)})
  }

  return {
    cReviewList,
    getCReviewList,
    cReview,
    getCReview,
    createCReview,
    isEditing,
    updateCReview,
    showEditForm,
    hideEditForm,
    updateList,
    myCommunityReviewList,
    getMyCommunityReview,
  };
});
