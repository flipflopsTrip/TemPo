import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "axios";

const REST_COMMUNITY_API = `http://localhost:8080/api-community/community`;

export const useCommunityStore = defineStore("community", () => {
  const communityList = ref([]);
  const getCommunityList = function () {
    axios.get(REST_COMMUNITY_API).then((response) => {
      communityList.value = response.data;
    });
  };

  //글 한개
  const community = ref({});
  const getCommunity = function (communityId) {
    axios
      .get(`${REST_COMMUNITY_API}/${communityId}`)
      .then((response) => {
        console.log("community " + community);
        community.value = response.data;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  //등록
  const createCommunity = function (community) {
    axios({
      url: REST_COMMUNITY_API,
      method: "POST",
      data: community.value,
    })
      .then(() => {
        console.log("등록");
        router.push({
          name: "communityList",
        });
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const updateCommunity = function () {
    axios
      .put(REST_COMMUNITY_API, community.value)
      .then((response) => {
        router.push({
          name: "communityDetail",
          params: { id: response.data },
        });
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const searchCommunityList = function (searchCondition) {
    axios
      .get(REST_COMMUNITY_API, {
        params: searchCondition,
      })
      .then((res) => {
        communityList.value = res.data;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return {
    communityList,
    getCommunityList,
    community,
    getCommunity,
    createCommunity,
    updateCommunity,
    searchCommunityList,
  };
});
