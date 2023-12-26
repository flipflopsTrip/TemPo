<template>
  <div class="container my-con my-board">
    <div class="title">커뮤니티 게시판</div>

    <table class="table mb-3">
      <thead class="my-thead">
        <tr class="text-center">
          <th>글 번호</th>
          <th>구분</th>
          <th>제목</th>
          <th>작성자</th>
          <th>조회수</th>
          <th>등록일</th>
        </tr>
      </thead>
      <tbody v-if="store.communityList.length > 0">
        <tr v-for="community in store.communityList" :key="community.communityId" class="my-hover text-center">
          <td>{{ community.communityId }}</td>
          <td>{{ community.category }}</td>
          <td class="all-links">
            <RouterLink
              :to="`/community/${community.communityId}`"
              >{{ community.title }}</RouterLink>
          </td>
          <td>{{ community.userId }}</td>
          <td>{{ community.viewCnt }}</td>
          <td>{{ community.regDate }}</td>
        </tr>
      </tbody>
      <tbody v-else>
        <tr class="text-center">
          <td colspan="5">등록된 게시글이 없습니다</td>
        </tr>
      </tbody>
    </table>
    
    <div class="d-flex justify-content-end">
      <RouterLink
        :to="{ name: 'communityCreate' }"
        class="my-btn"
        >글쓰기 <i class="bi bi-pencil-square"></i>
      </RouterLink>
    </div>

    <CommunitySearchInput />
  </div>
</template>

<script setup>
import { useCommunityStore } from "@/stores/community";
import { useRoute, useRouter } from "vue-router";
import { onMounted } from "vue";
import CommunitySearchInput from "@/components/community/CommunitySearchInput.vue";
const store = useCommunityStore();
const router = useRouter();
const route = useRoute();

onMounted(() => {
  store.getCommunityList();
});
</script>

<style scoped>
.my-con {
	margin-bottom: 100px;
}
.my-board {
  width: 50%;
}
.title {
  font-size: 1.8rem;
  font-weight: 500;
  padding: 15px 0px;
  margin: 10px 0px;
}
tr.my-hover:hover td {
	background-color: #9db2bf28;
}
.all-links > a {
	color: black;
	text-decoration: none;
}
.all-links > a:hover {
	text-decoration: underline;
}
table > thead > tr > th:nth-child(1) {
	width: 10%;
}
table > thead > tr > th:nth-child(2) {
	width: 10%;
}
table > thead > tr > th:nth-child(4) {
	width: 10%;
}
table > thead > tr > th:nth-child(5) {
	width: 10%;
}
table > thead > tr > th:nth-child(6) {
	width: 15%;
}
.my-btn {
  color: #4b565c;
	border: 1px solid #9DB2BF;
	border-radius: 6px;
	padding: 6px 8px;
	margin-right: 10px;
  text-decoration: none;
  background-color: #f0f0f0;
}
.my-btn:hover {
	color: black;
	background-color: #9db2bf3d;
}
.my-thead {
  border-bottom: 1px solid #ccc;
	border-top: 2px solid #9DB2BF;
	padding: 2px 10px;
}
thead th {
  background-color: #e5ecf2;
}
tbody > tr:last-child {
  border-bottom: 2px solid #9DB2BF;
}
</style>
