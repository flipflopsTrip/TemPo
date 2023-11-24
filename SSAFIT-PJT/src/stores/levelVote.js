import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

export const useLevelVoteStore = defineStore("levelVote", () => {
  const REST_LEVELVOTE_API = "http://localhost:8080/api-levelVote/levelVote";

  //@GetMapping("/levelVote") getLevel(@RequestParam int id)//비디오id = response에 레벨값만 들어있음
  const videoLevel = ref(0); //기본
  const getVideoLevel = (videoId) => {
    axios
      .get(`${REST_LEVELVOTE_API}`, { params: { id: videoId } })
      .then((response) => {
        videoLevel.value = response.data;
      })
      .catch((err) => console.log(err));
  };

  //@GetMapping("/levelVote/{id}")//비디오id
  //getMyVote(@PathVariable int id, @RequestParam String userId){//비디오id, 유저id
  const userVoteRes = ref(0); //기본
  const getUserVote = (videoId, userId) => {
    axios
      .get(`${REST_LEVELVOTE_API}/${videoId}/${userId}`)
      .then((response) => {
        if (response.data == 0) {
        } else {
          userVoteRes.value = response.data.level;
        }
      })
      .catch((err) => console.log(err));
  };

  //@PostMapping("/levelVote") createVote(@RequestBody LevelVote levelVote)
  const createVote = function (levelVote) {
    axios
      .post(`${REST_LEVELVOTE_API}`, levelVote)
      .then((response) => {
        userVoteRes.value = levelVote.level;
        getVideoLevel(levelVote.videoId);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  //해당 유저의 전체 투표한 목록 불러오기
  const voteList = ref([]);
  const getVoteList = (userId) => {
    axios
      .get(`${REST_LEVELVOTE_API}/list`, { params: { userId } })
      .then((response) => {
        voteList.value = response.data;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return {
    videoLevel,
    getVideoLevel,
    userVoteRes,
    getUserVote,
    createVote,
    voteList,
    getVoteList,
  };
});
