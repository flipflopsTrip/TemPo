import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

export const useCommentStore = defineStore("comment", () => {
  const REST_COMMENT_API = "http://localhost:8080/api-comment/comment";

  //list
  const commentList = ref([]);
  const getCommentList = async (reviewId) => {
    try {
      const response = await axios.get(`${REST_COMMENT_API}`, {
        params: { id: reviewId },
      });
      commentList.value = response.data;
    } catch (error) {
      console.log(error);
    }
  };

  //detail
  const comment = ref({});
  const getComment = function (commentId) {
    axios
      .get(`${REST_COMMENT_API}/${commentId}`)
      .then((response) => {
        comment.value = response.data;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  //create
  const createComment = async (comment) => {
    try {
      await axios.post(REST_COMMENT_API, comment);
      getCommentList(comment.reviewId);
    } catch (err) {
      console.log(err);
    }
  };

  const isEditing = ref(false); //수정폼 숨김 관리

  //update
  const updateComment = (comment) => {
    axios.put(`${REST_COMMENT_API}`, comment).then(() => {
      getCommentList(comment.reviewId);
      isEditing.value = false;
    });
  };

  const showEditForm = () => {
    isEditing.value = true;
  };
  const hideEditForm = () => {
    isEditing.value = false;
  };

  //특정 회원의 댓글 목록
  const myCommentList = ref([]);
  const getMyComment = function(userId) {
    axios
      .get(`http://localhost:8080/api-comment/myComment/${userId}`)
      .then((res)=>{
        myCommentList.value = res.data;
      })
      .catch((err)=>{console.log(err)})
  };

  return {
    commentList,
    getCommentList,
    comment,
    getComment,
    createComment,
    updateComment,
    isEditing,
    showEditForm,
    hideEditForm,
    myCommentList,
    getMyComment,
  };
});
