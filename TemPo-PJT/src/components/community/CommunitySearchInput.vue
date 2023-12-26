<template>
  <div class="container mt-3">
    <div class="row">
      <div class="col-md-2">
        <label for="searchCriteria">검색 기준</label>
        <select class="form-select" v-model="searchInfo.key" id="searchCriteria">
          <option value="none">없음</option>
          <option value="userId">작성자</option>
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>
      </div>
      <div class="col-md-4">
        <label for="searchContent">검색 내용</label>
        <input
          type="text"
          class="form-control"
          v-model="searchInfo.word"
          id="searchContent"
          placeholder="검색어를 입력하세요"
        />
      </div>
      <div class="col-md-2">
        <label for="orderBy">정렬 기준</label>
        <select class="form-select" v-model="searchInfo.orderBy" id="orderBy">
          <option value="none">없음</option>
          <option value="userId">글쓴이</option>
          <option value="title">제목</option>
          <option value="viewCnt">조회수</option>
        </select>
      </div>
      <div class="col-md-2">
        <label for="orderByDirection">정렬 방향</label>
        <select class="form-select" v-model="searchInfo.orderByDir" id="orderByDirection">
          <option value="asc">오름차순</option>
          <option value="desc">내림차순</option>
        </select>
      </div>
      <div class="col-md-2">
        <label></label>
        <button
          type="button"
          class="my-btn d-block w-100"
          @click="searchCommunityList">
          <i class="bi bi-search"></i> 검색
        </button>
      </div>
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
select:active select:focus {
  border: none;
  box-shadow: none;
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
