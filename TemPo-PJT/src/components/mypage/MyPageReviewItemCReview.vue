<template>
	<div class="myReview-con">
		<div class="sub-title">자유게시판 댓글 <i class="bi bi-chat-text"></i></div>
		<div v-if="storeCR.myCommunityReviewList.length == 0">아직 작성한 댓글이 없습니다.</div>
		<table v-else class="table">
			<thead class="my-thead">
				<tr class="text-center">
					<th>번호</th>
					<th>내용</th>
					<th>등록 날짜</th>
				</tr>
			</thead>
			<tbody>
				<tr
					v-for="(community, index) in storeCR.myCommunityReviewList" :key="index"
					class="text-center my-hover"
				>
					<td>{{index + 1 }}</td>
					<td class="all-links">
						<RouterLink
						:to="{
							name: 'communityDetail',
							params: { id: community.communityId },
						}"
					>{{ community.content }}</RouterLink>
					</td>
					<td>{{ community.regDate }}</td>
				</tr>
			</tbody>
		</table>
	</div>
</template>

<script setup>
import {ref, computed, watch, onMounted } from 'vue';
import { useUserStore } from '@/stores/user';
import { useCReviewStore } from '@/stores/cReview';

const store = useUserStore();
const storeCR = useCReviewStore();

onMounted(() => {
	storeCR.getMyCommunityReview(store.loginUserId);
});
</script>

<style scoped>
.sub-title {
	font-size: 1.2rem;
	font-weight: 400;
	margin-bottom: 4px;
}
.myReview-con {
	margin-bottom: 10px;
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
	width: 15%;
}
table > thead > tr > .view-cnt {
	width: 15%;
}
table > thead > tr > th:last-child {
	width: 20%;
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