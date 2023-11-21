<template>
	<div class="container">
		<div class="title">내 정보 관리</div>
		<MyPageMainItemProfile/>
		<MyPageMainItemWeight/>
	</div>
</template>

<script setup>
import {ref, computed, watch, onMounted } from 'vue';
import { useUserStore } from '@/stores/user';
import MyPageMainItemProfile from './MyPageMainItemProfile.vue';
import MyPageMainItemWeight from './MyPageMainItemWeight.vue';

const store = useUserStore();

onMounted(() => {
	store.getUser(store.loginUserId); //store.sessionUser
});

</script>

<style scoped>
.container > .item {
	margin: 20px auto 100px;
}
.container * {
	letter-spacing: -0.4px;
}
.title {
	display: inline-block;
	font-size: 1.8rem;
	font-weight: 500;
	background: linear-gradient(to top, #ffdc30df 15%, transparent 15%);
}
</style>