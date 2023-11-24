<template>
	<div class="container" v-show="!isUser">
		<!-- index.js 추가 -->
		<div class="regist-title">비밀번호 찾기</div>
		<div class="input-con row mb-4">
			<label for="id" class="col-sm-2 col-form-label">아이디</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="id" placeholder="아이디를 입력하세요" required autocomplete="off"
					v-model="id"/>
				</div>
		</div>
		<div class="input-con row mb-4">
			<label for="email" class="col-sm-2 col-form-label">이메일</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="email" placeholder="이메일을 입력하세요" required autocomplete="off"
					@keyup.enter="findPw"
					v-model="email"/>
				</div>
		</div>
		<div class="d-grid">
				<button class="btn btn-primary" @click="findPw">
					찾기
				</button>
		</div>
	</div>
	
	<div class="container" v-show="isUser">
		<!-- index.js 추가 -->
		<div class="regist-title">비밀번호 변경하기</div>
		<div class="input-con row mb-4">
			<label for="password" class="col-sm-3 form-label">변경할 비밀번호</label>
			<div class="col-sm-9">
					<input class="form-control" type="password" id="password" placeholder="비밀번호를 입력하세요" required
					v-model="password"
					:class="{'is-valid' : isValidPw, 'is-invalid' : !isValidPw}">
					<div v-if="isValidPw" class="form-text pw-text">사용할 수 있는 비밀번호입니다</div>
					<div v-else="!isValidPw" class="form-text pw-text">영문자, 숫자 및 특수문자(@&!%*#?&) 조합의 6~20자리를 사용하세요</div>
			</div>
			<label for="password" class="col-sm-3 form-label">비밀번호 확인</label>
			<div class="col-sm-9">
				<input class="form-control" type="password" id="passwordCheck" placeholder="비밀번호 재확인" required
				v-model="passwordCheck"
				@keyup.enter="changePw"
				:class="{'is-valid' : isSamePw, 'is-invalid' : !isSamePw}">
				<div v-if="isSamePw" class="form-text">비밀번호가 일치합니다.</div>
				<div v-else="!isSamePw" class="form-text">비밀번호가 일치하지 않습니다</div>
			</div>
		</div>
		<div class="d-grid">
				<button class="btn btn-primary"
					@click="changePw"
					:disabled="changeFlag">변경하기</button>
		</div>
	</div>

</template>

<script setup>
import {ref, computed, watch, onMounted } from 'vue';
import { useUserStore } from '@/stores/user';
import router from '@/router'

import axios from "axios";
const REST_SSAFIT_API = `http://localhost:8080/api-user`;
const store = useUserStore();

const id = ref('');
const email = ref(null);
const isUser = ref(false);

const password = ref('');
const passwordCheck = ref('');
const isValidPw = ref(false);
const isSamePw = ref(false);

//비밀번호 찾기
const findPw = function() {
	const user = {
		id: id.value,
		email: email.value,
  };
	axios.post(`${REST_SSAFIT_API}/find/pw`, user)
	.then((res)=>{
		if (res.data != null) {
			isUser.value = true;
			alert('비밀번호를 변경합니다.')
		} else {
			alert('유저 정보가 없습니다.')
		}
	})
};

//비밀번호 유효성 && 일치 검사
watch(password, (newPw) => {
	isSamePw.value = false;
	checkPw(newPw);
	samePw();
});
const checkPw = function(pw) {
	const validatePw = /^(?=.*\d)(?=.*[@&!%*#?&])[A-Za-z\d@&!%*#?&]{6,16}$/;
	isValidPw.value = validatePw.test(pw);
};

watch(passwordCheck, (checkPw)=>{
	isSamePw.value = false;
	samePw();
});
const samePw = function() {
	if (passwordCheck.value === password.value)
		isSamePw.value = true;
}

//변경 버튼 flag
const changeFlag = computed(() => {
	return password.value === '' ||
					passwordCheck.value === '' ||
					isValidPw.value === false ||
					isSamePw.value === false
});

//비밀번호 변경
const changePw = function() {
	const user = {
		id: id.value,
		password: password.value,
  };
	axios.post(`${REST_SSAFIT_API}/changePw`, user)
	.then((res)=>{
		if (res.data == 'success') {
			console.log(res.data)
			alert('비밀번호 변경이 완료되었습니다.')
			router.push({name: 'UserLogin'})
		} else {
			alert('비밀번호 변경에 실패했습니다.')
		}
	})
	password.value = '';
  passwordCheck.value = '';
};

</script>

<style scoped>
	.container {
		margin: 0 auto;
		width: 45%;
		min-width: 500px;
		max-width: 35%;
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
		margin: 20px 0px 40px;
	}
	.pw-text {
		margin-bottom: 25px;
	}
</style>