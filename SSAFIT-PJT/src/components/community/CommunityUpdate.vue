<template>
  <div>
    <h4>게시글 수정</h4>
    <fieldset>
      <legend>등록</legend>
      <label for="category">구분</label>
      <select name="category" id="category" v-model="store.community.category">
        <option v-for="c in categories" :key="c.no" :value="c.category">
          {{ c.category }}
        </option>
      </select>
      <div>
        <label for="title">제목 : </label>
        <input type="text" id="title" v-model="store.community.title" />
      </div>
      <div>
        <label for="content">내용 : </label>
        <textarea
          id="content"
          cols="30"
          rows="10"
          v-model="store.community.content"
        ></textarea>
      </div>
      <div>
        <button type="button" class="btn btn-primary" @click="updateCommunity">
          수정
        </button>
        <button type="button" class="btn btn-danger" @click="goBack">
          취소
        </button>
      </div>
    </fieldset>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useCommunityStore } from "@/stores/community";
import { useUserStore } from "@/stores/user";
import { useRoute, useRouter } from "vue-router";
const store = useCommunityStore();
const storeU = useUserStore();
const route = useRoute();
const router = useRouter();
const categories = ref([
  {
    no: 1,
    category: "잡담",
  },
  {
    no: 2,
    category: "Q&A",
  },
  {
    no: 3,
    category: "정보",
  },
  {
    no: 4,
    category: "홍보",
  },
]);

onMounted(() => {
  const communityId = route.params.communityId;
  if (communityId) {
    store.getCommunity(communityId);
  }
});

const updateCommunity = function () {
  store.community.userId = storeU.loginUserId;
  store.updateCommunity();
};

const goBack = () => {
  router.back();
};
</script>

<style scoped></style>
