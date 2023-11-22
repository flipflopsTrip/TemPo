<template>
  <div class="search">
    <div>
      <label>검색 기준 :</label>
      <select v-model="searchInfo.key">
        <option value="none">없음</option>
        <option value="userId">작성자</option>
        <option value="title">제목</option>
        <option value="content">내용</option>
      </select>
    </div>
    &nbsp&nbsp&nbsp&nbsp
    <div>
      <label>검색 내용 :</label>
      <input
        type="text"
        v-model="searchInfo.word"
        placeholder="검색어를 입력하세요"
      />
    </div>
    &nbsp&nbsp&nbsp&nbsp
    <div>
      <label>정렬 기준 :</label>
      <select v-model="searchInfo.orderBy">
        <option value="none">없음</option>
        <option value="userId">글쓰니</option>
        <option value="title">제목</option>
        <option value="viewCnt">조회수</option>
      </select>
    </div>
    &nbsp&nbsp&nbsp&nbsp
    <div>
      <label>정렬 방향 :</label>
      <select v-model="searchInfo.orderByDir">
        <option value="asc">오름차순</option>
        <option value="desc">내림차순</option>
      </select>
    </div>
    <div>
      <button
        type="button"
        class="btn btn-secondary"
        @click="searchCommunityList"
      >
        검색
      </button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useCommunityStore } from "@/stores/community";

const storeC = useCommunityStore();
const searchInfo = ref({
  key: "none",
  word: "",
  orderBy: "none",
  orderByDir: "asc",
});
const searchCommunityList = function () {
  storeC.searchCommunityList(searchInfo.value);
};
</script>

<style scoped>
.search {
  display: flex;
}
</style>
