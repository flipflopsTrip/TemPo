<template>
	<div class="flex-container">
		<!-- 네비게이션 -->
		<div class="item navigation d-flex flex-column justify-content-center">
			<nav>
				<RouterLink :to="{ name : 'MyPageMain' }">내 정보 관리</RouterLink>
				<a href="#">운동일지</a>
				<RouterLink :to="{ name : 'wishList' }">좋아요 영상 목록</RouterLink>
				<RouterLink :to="{ name : 'MyPageBoard' }">내가 쓴 글</RouterLink>
				<div>
				<RouterLink :to="{ name : 'MyPageReview' }">내가 쓴 댓글</RouterLink></div>
			</nav>
		</div>

		<div class="item main-content">
			<!-- <MyPageMain/> -->
			<RouterView/>
    </div>

	</div>
</template>

<script setup>
import MyPageMain from '@/components/mypage/MyPageMain.vue';
import wishList from '@/components/wish/wishList.vue';
import { useRoute, useRouter } from "vue-router";
const route = useRoute();
</script>

<style scoped>
.flex-container {
  display: flex;
}
.flex-container .item:nth-child(1) {
  flex-grow: 1;
  padding: 25px 20px;
}
.flex-container .item:nth-child(2) {
  flex-grow: 1;
  padding: 25px 15px;
	margin-right: 7%;
  @media (min-width: 768px) {
    margin-right: 5%;
  }
  @media (min-width: 1200px) {
    margin-right: 20%;
  }
}
.navigation {
  background-color: #ffffff;
	flex-basis: 30%;
	max-width: 250px;
	min-width: 155px;
	height: 350px;
	border: 1px solid #9DB2BF;
	border-radius: 8px;
	font-weight: 600;
	margin: 100px 3% 70px 17%;
	box-shadow: rgba(50, 50, 93, 0.25) 0px 2px 5px -1px, rgba(0, 0, 0, 0.3) 0px 1px 3px -1px;
}
@media screen and (max-width: 1024px) {
  .navigation {
    margin-left: 3%;
  }
}
.main-content {
  flex-basis: 70%;
	margin-top: 60px;
}
.navigation a {
	display: block;
	padding: 10px 15px;
	margin: 5px 0px;
  text-decoration: none;
  color: #526D82;
  transition: background-color 0.3s;
	border-radius: 6px;
	font-weight: 500;
}
.navigation a:hover {
	font-weight: 600;
	color: #27374D;
}
.navigation .router-link-exact-active {
	/* background: linear-gradient(to top, #FFD717 8%, transparent 8%); */
	background-color: #ffdc30dc;
	color: #27374D;
	font-weight: 600;
}
nav > div > .router-link-active {
	background-color: #ffdc30dc;
}

</style>