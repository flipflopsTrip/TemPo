<template>
	<div class="container">
		<div class="title">내가 쓴 글</div>
		<div v-if="myBoardList.length == 0">아직 작성한 게시글이 없습니다.</div>
		<table v-else class="table">
      <thead class="my-thead">
        <tr class="text-center">
          <th>번호</th>
          <th>분류</th>
          <th>제목</th>
          <th>조회수</th>
          <th>등록 날짜</th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="(board, index) in myBoardList" :key="index"
          class="text-center my-hover"
        >
          <td>{{index + 1 }}</td>
          <td>{{ board.category }}</td>
          <td class="community-link">
						<RouterLink
              :to="{
                name: 'communityDetail',
                params: { id: board.communityId },
              }"
            >{{ board.title }}</RouterLink>
          </td>
          <td>{{ board.viewCnt }}</td>
          <td>{{ board.regDate }}</td>
        </tr>
      </tbody>
    </table>
	</div>
</template>

<script setup>
import {ref, computed, watch, onMounted } from 'vue';
import { useUserStore } from '@/stores/user';
import axios from "axios";

const store = useUserStore();

onMounted(() => {
	getMyBoard(store.loginUserId);
});

const myBoardList = ref([]);

const REST_MYPAGE_API = "http://localhost:8080/api-mypage";
const getMyBoard = function(userId) {
	axios.post(`${REST_MYPAGE_API}/myBoard`, userId)
	.then((res)=>{
		myBoardList.value = res.data;
	})
	.catch((err)=>{console.log(err)})
};

</script>

<style scoped>
.container * {
	letter-spacing: -0.4px;
}
.title {
	display: inline-block;
	font-size: 1.6rem;
	font-weight: 500;
  margin-bottom: 20px;
	background: linear-gradient(to top, #ffdc30df 15%, transparent 15%);
}
tr.my-hover:hover td {
	background-color: #9db2bf28;
}
.community-link > a {
	color: black;
	text-decoration: none;
}
.community-link > a:hover {
	text-decoration: underline;
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