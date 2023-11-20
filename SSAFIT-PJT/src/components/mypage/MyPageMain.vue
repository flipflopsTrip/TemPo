<template>
	<div class="container">
		<div>나의 정보</div>
		<div class="item profile">
			<div class="title">기본 정보</div>
			<div class="profile-detail d-flex d-flex flex-column justify-content-center align-items-center">
				<div>아이디: {{ store.sessionUser.id }}</div>
				<div>이메일: {{ store.sessionUser.email }}</div>
				<div>이름: {{ store.sessionUser.name }}</div>
				<button>비밀번호 변경하기</button>
			</div>
		</div>

		<div class="item">
			<div class="title">몸무게 그래프</div>
			<div>
				<div>몸무게 정보를 입력해주세요</div>
			</div>
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
.container > .item {
	margin: 20px auto 100px;
}
.profile-detail {
	border: 1px solid black;
}
</style>