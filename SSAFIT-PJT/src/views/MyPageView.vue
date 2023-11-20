<template>
	<div class="flex-container">
		<!-- 네비게이션 -->
		<div class="item navigation d-flex flex-column justify-content-center">
			<nav>
				<a href="#">나의 정보</a>
				<a href="#">운동일지</a>
				<a href="#">좋아요 영상 목록</a>
				<a href="#">내가 쓴 글</a>
				<a href="#">내가 쓴 댓글</a>
			</nav>
		</div>

		<div class="item main-content">
      <div>MyPageView.vue 확인</div>
      <RouterView />
    </div>

	</div>
</template>

<script setup>

</script>

<style scoped>
.flex-container {
  display: flex;
}
.flex-container .item:nth-child(1) {
  flex-grow: 1;
  padding: 25px 15px;
}
.flex-container .item:nth-child(2) {
  flex-grow: 1;
  padding: 25px 15px;
	margin-right: 5%;
  @media (min-width: 768px) {
    margin-right: 5%;
  }
  @media (min-width: 1200px) {
    margin-right: 18%;
  }
}
.navigation {
  background-color: #ffffff;
	flex-basis: 30%;
	max-width: 250px;
	height: 350px;
	border: 1px solid #9DB2BF;
	border-radius: 8px;
	font-weight: 600;
	margin: 100px 3% 70px 12%;
	box-shadow: rgba(50, 50, 93, 0.25) 0px 2px 5px -1px, rgba(0, 0, 0, 0.3) 0px 1px 3px -1px;
}
.main-content {
  flex-basis: 70%;
}
.navigation a {
	display: block;
  padding: 15px;
  text-decoration: none;
  color: #526D82;
  transition: background-color 0.3s;
}
.navigation a:hover {
	color: #27374D;
	background-color: #ebebeb;
}

</style>