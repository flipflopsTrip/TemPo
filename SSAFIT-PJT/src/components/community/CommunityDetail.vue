<template>
  <div class="container my-con my-board">
    <button class="">목록</button>
    <div class="card my-card">
      <div class="card-header d-flex justify-content-between">
        <div>[ {{ storeC.community.category }} ]</div>
        <div class="sub-header">
          <span>{{ storeC.community.userId }}</span>
          <span>({{ storeC.community.regDate }})</span>
          <span><i class="bi bi-eye-fill"></i> {{ storeC.community.viewCnt }}</span>
        </div>
      </div>
      <div class="card-body my-card-body">
        <div class="card-title">
          {{ storeC.community.title }}
        </div>
        <div class="card-text">
          {{ storeC.community.content }}
        </div>
        <div
          v-if="storeU.loginUserId === storeC.community.userId"
          style="display: flex; justify-content: right"
        >
          <button
            class="my-btn my-btn-modi"
            @click="updateCommunity">
            수정 <i class="bi bi-pencil-fill"></i>
          </button>
          <button class="my-btn my-btn-del" 
            @click="deleteCommunity">
            삭제 <i class="bi bi-trash3-fill"></i>
          </button>
        </div>
      </div>
    </div>

    <div>
      <CReviewCreate :communityId="communityId" />
      <CReviewList
        :communityId="communityId"
        @update-cReview-list="updateCReviewList" />
    </div>

  </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { useCommunityStore } from "@/stores/community";
import { useUserStore } from "@/stores/user";
import { useCReviewStore } from "@/stores/cReview";
import { onMounted } from "vue";
import axios from "axios";
import CReviewCreate from "@/components/cReview/CReviewCreate.vue";
import CReviewList from "@/components/cReview/CReviewList.vue";

const storeC = useCommunityStore();
const storeCR = useCReviewStore();
const storeU = useUserStore();
const route = useRoute();
const router = useRouter();
const communityId = route.params.id;

onMounted(() => {
  storeC.getCommunity(communityId);
});

//update
const updateCommunity = function () {
  router.push({ name: "communityUpdate" });
};

//delete
const deleteCommunity = function () {
  axios
    .delete(`http://localhost:8080/api-community/community/${route.params.id}`)
    .then(() => {
      router.push({
        name: "communityList",
      });
    })
    .catch((err) => {
      console.log(err);
    });
};

const updateCReviewList = () => {
  storeCR.getCReviewList(communityId);
};
</script>

<style scoped>
#container {
  display: flex;
  justify-content: space-around;
}
.my-con {
  margin-top: 50px;
	margin-bottom: 100px;
}
.my-board {
  width: 40%;
}
.card-title {
  font-size: 1.4rem;
  font-weight: 500;
}
.card-text {
  font-size: 1.1rem;
}
.sub-header > span {
  margin: 0px 4px;
}
.my-btn {
  color: #4b565c;
	border: 1px solid #9DB2BF;
	border-radius: 6px;
	padding: 6px 8px;
	margin-right: 10px;
}
.my-btn:hover {
	color: black;
	background-color: #9db2bf3d;
}
</style>
