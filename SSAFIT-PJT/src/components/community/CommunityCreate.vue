<template>
  <div>
    <h4>게시글 작성</h4>
    <fieldset>
      <legend>등록</legend>
      <label for="category">구분</label>
      <select name="category" id="category" v-model="category">
        <option v-for="c in categories" :key="c.no" :value="c.ca">
          {{ c.ca }}
        </option>
      </select>
      <div>
        <label for="title">제목 : </label>
        <input type="text" id="title" v-model="title" />
      </div>
      <div>
        <label for="content">내용 : </label>
        <textarea
          id="content"
          cols="30"
          rows="10"
          v-model="content"
        ></textarea>
      </div>
      <div>
        <button type="button" class="btn btn-primary" @click="createCommunity">
          등록</button
        >&nbsp&nbsp&nbsp&nbsp
        <button @click="goBack">취소</button>
      </div>
    </fieldset>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useCommunityStore } from "@/stores/community";
import { useRoute, useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";
const store = useCommunityStore();
const storeU = useUserStore(); //로그인한 유저의 아이디를 가져오기 위해서 추가
const router = useRouter();
// const community = ref({
//   category: "",
//   title: "",
//   userId: storeU.loginUserId, //추가
//   content: "",
// });

const category = ref('잡담');
const title = ref('');
const content = ref('');

const categories = ref([
  {
    no: 1,
    ca: "잡담",
  },
  {
    no: 2,
    ca: "Q&A",
  },
  {
    no: 3,
    ca: "정보",
  },
  {
    no: 4,
    ca: "홍보",
  },
]);

const createCommunity = function () {
  // store.createCommunity(community.value);
  const community = ref({
    category : category.value,
    title : title.value,
    userId : storeU.loginUserId,
    content : content.value,
  })
  store.createCommunity(community);
};
const goBack = () => {
  router.back();
};
</script>

<style scoped></style>
