<template>
  <div>
    <div
      class="card"
      style="width: 70%; display: block; justify-content: center"
    >
      <div class="card-header" style="text-align: left">
        <div>[ {{ storeC.community.category }} ]</div>
      </div>
      <div class="card-body">
        <div
          class="container"
          style="display: flex; justify-content: space-between"
        >
          <h3 class="card-title">{{ storeC.community.title }}</h3>
          <div class="container" style="display: block; text-align: right">
            <div>{{ storeC.community.userId }}</div>
            <br />
            <div>{{ storeC.community.regDate }}</div>
          </div>
        </div>
        <hr />
        <div class="card-text">{{ storeC.community.content }}</div>
        <div>{{ storeC.community.viewCnt }}</div>

        <div
          v-if="storeU.loginUserId === storeC.community.userId"
          style="display: flex; justify-content: right"
        >
          <button
            type="button"
            class="btn btn-primary"
            @click="updateCommunity"
          >
            수정</button
          >&nbsp&nbsp&nbsp&nbsp
          <button type="button" class="btn btn-danger" @click="deleteCommunity">
            삭제
          </button>
        </div>
      </div>
    </div>
    <hr />
    <div>
      <CReviewCreate :communityId="communityId" />
      <hr />
      <CReviewList
        :communityId="communityId"
        @update-cReview-list="updateCReviewList"
      />
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
</style>
