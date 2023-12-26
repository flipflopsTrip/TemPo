<template>
	<div class="container">
		<!-- index.js 추가 -->
		<div class="regist-title">아이디 찾기</div>
		<div class="input-con row mb-4">
			<label for="name" class="col-sm-2 col-form-label">이름</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="name" placeholder="이름을 입력하세요" required autocomplete="off"
					v-model="name"/>
				</div>
		</div>
		<div class="input-con row mb-4">
			<label for="email" class="col-sm-2 col-form-label">이메일</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="email" placeholder="이메일을 입력하세요" required autocomplete="off"
					@keyup.enter="findId"
					v-model="email"/>
				</div>
		</div>
		<div class="d-grid">
				<button class="btn btn-primary" @click="findId">
					찾기
				</button>
		</div>
		<div class="result-id" v-show="id.length != 0">
			<span>찾은 아이디: {{ id }}</span>
		</div>
	</div>
</template>

<script setup>
import {ref, computed, watch, onMounted } from 'vue';
import { useUserStore } from '@/stores/user';

import axios from "axios";
const REST_SSAFIT_API = `http://localhost:8080/api-user`;
const store = useUserStore();

const name = ref('');
const email = ref(null);
const id = ref('');

//아이디 찾기
const findId = function() {
	const user = {
		name: name.value,
		email: email.value,
  };
	axios.post(`${REST_SSAFIT_API}/find/id`, user)
	.then((res)=>{
		if (res.data.length != 0) id.value = maskId(res.data);
		else {
			alert('유저 정보가 없습니다.');
		}
	})
	name.value = '';
  email.value = '';
};

// 아이디 마스킹 함수
const maskId = function (id) {
  // 아이디의 처음 두 글자는 그대로 두고 나머지는 '*'로 채우기
  const maskedPart = id.slice(2).replace(/./g, '*');
  return id.slice(0, 2) + maskedPart;
};
</script>

<style scoped>
	.container {
		margin: 0 auto;
		width: 45%;
		min-width: 500px;
		max-width: 33%;
		letter-spacing: -0.3px;
		margin: 30px auto;
		border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
		padding: 15px 40px 30px;
		border: 1px solid rgb(226, 226, 226);
	}
	.regist-title {
		font-size: 2rem;
		margin: 10px 0px 30px;
		border-width: 0px 0px 1px 0px;
		border-color: black;
		border-style: solid;
	}
	.d-grid {
		margin: 40px 0px 40px;
	}
	.result-id > span {
		font-size: 1.5rem;
		background: linear-gradient(to top, gold 20%, transparent 20%)
	}
</style>