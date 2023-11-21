<template>
	<div class="item profile">
		<div class="title">몸무게 그래프</div>
		<div>
			<div>몸무게 정보를 입력해주세요</div>
		</div>
	</div>
</template>

<script setup>
import {ref, computed, watch, onMounted } from 'vue';
import { useUserStore } from '@/stores/user';

const store = useUserStore();

onMounted(() => {
	store.getUser(store.loginUserId); //store.sessionUser
});
</script>

<style scoped>
.profile-detail {
	border: 1px solid #9DB2BF;
	border-radius: 8px;
	padding: 20px 0px 55px;
}
.container > .item > .title {
	font-size: 1.3rem;
	margin-bottom: 7px;
}
img {
	margin-bottom: 10px;
	width: 80px;
}
.profile-detail-item {
	font-size: 1.3rem;
	margin: 4px 0px;
}
.profile-detail-item > span{
	display: inline-block;
	font-size: 1rem;
	color: rgb(71, 71, 71);
	margin: 0px 8px;
}
.profile-detail-item:nth-child(1) {
	margin-top: 30px;
}
.title-2 {
	margin-top: 50px;
}
.con-pw {
	border: 1px solid #9DB2BF;
	border-radius: 8px;
}
.btn-pw {
	margin: 20px 20px;
}
</style>