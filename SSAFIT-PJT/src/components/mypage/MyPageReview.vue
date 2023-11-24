<template>
	<div class="container">
		<div class="title">내가 쓴 댓글</div>

		<div class="review-link-nav">
			<RouterLink :to="{ name : 'MyPageReviewItemReview' }">영상 리뷰</RouterLink>
			<RouterLink :to="{ name : 'MyPageReviewItemComment' }">리뷰 코멘트</RouterLink>
			<RouterLink :to="{ name : 'MyPageReviewItemCReview' }">자유게시판 댓글</RouterLink>
		</div>

		<RouterView />

	</div>
</template>

<script setup>
import {ref, computed, watch, onMounted } from 'vue';
import { useUserStore } from '@/stores/user';
import { useReviewStore } from '@/stores/review';
import { useCommentStore } from '@/stores/comment';
import { useCReviewStore } from '@/stores/cReview';

const store = useUserStore();
const storeR = useReviewStore();
const storeC = useCommentStore();
const storeCR = useCReviewStore();

onMounted(() => {
	storeR.getMyReview(store.loginUserId);
	storeC.getMyComment(store.loginUserId);
	storeCR.getMyCommunityReview(store.loginUserId);
});

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
.review-link-nav {
	margin: 5px 0px 30px;
}
.review-link-nav > a {
	color: #4b565c;
	text-decoration: none;
	border: 1px solid #9DB2BF;
	border-radius: 6px;
	padding: 6px 8px;
	margin-right: 10px;
}
.review-link-nav > a:hover {
	color: black;
	background-color: #9db2bf3d;
}
.review-link-nav > .router-link-exact-active {
	color: black;
	background-color: #9db2bf3d;
}
</style>