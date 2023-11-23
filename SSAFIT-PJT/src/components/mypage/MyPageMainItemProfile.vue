<template>
	<div class="item profile">
		<div class="title">기본 정보 <i class="bi bi-person-lines-fill"></i></div>
		<div class="profile-detail d-flex d-flex flex-column justify-content-center align-items-center">
			<div class="profile-detail-item">
				<img src="@/assets/profile.png" alt="프로필이미지">
			</div>
			<div class="profile-detail-item"><span>닉네임(아이디): </span>{{ store.sessionUser.nickname }}({{ store.sessionUser.id }})</div>
			<div class="profile-detail-item"><span>이메일: </span>{{ store.sessionUser.email }}</div>
		</div>
		
		<div class="title title-2">비밀번호 <i class="bi bi-key-fill"></i></div>
		<div class="con-pw d-flex flex-row-reverse">
			<button class="btn btn-primary btn-pw" data-bs-toggle="modal" data-bs-target="#changePwModal">비밀번호 변경</button>
		</div>

		<!-- 모달 -->
		<div class="modal fade" id="changePwModal" tabindex="-1" 		aria-labelledby="changePwModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="changePwModalLabel">비밀번호 변경</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						
						<label for="password" class="form-label">변경할 비밀번호</label>
						<div class="">
							<input class="form-control" type="password" id="password" placeholder="비밀번호를 입력하세요" required
							v-model="password"
							:class="{'is-valid' : isValidPw, 'is-invalid' : !isValidPw}">
							<div v-if="isValidPw" class="form-text pw-text">사용할 수 있는 비밀번호입니다</div>
							<div v-else="!isValidPw" class="form-text pw-text">영문자, 숫자 및 특수문자(@&!%*#?&) 조합의 6~20자리를 사용하세요</div>
							
							<label for="password" class="form-label form-label-2">비밀번호 확인</label>
							<input class="form-control" type="password" id="passwordCheck" placeholder="비밀번호 재확인" required
							v-model="passwordCheck"
							@keyup.enter="changePw"
							:class="{'is-valid' : isSamePw, 'is-invalid' : !isSamePw}">
							<div v-if="isSamePw" class="form-text">비밀번호가 일치합니다.</div>
							<div v-else="!isSamePw" class="form-text">비밀번호가 일치하지 않습니다</div>
						</div>

					</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
						<button class="btn btn-primary" @click="changePw"
					:disabled="changeFlag" data-bs-dismiss="modal">저장</button>
					</div>
				</div>
			</div>
		</div>

	</div>
</template>

<script setup>
import {ref, computed, watch, onMounted } from 'vue';
import { useUserStore } from '@/stores/user';
import axios from 'axios';
import 'bootstrap/js/dist/modal';

const store = useUserStore();
const REST_SSAFIT_API = `http://localhost:8080/api-user`;

onMounted(() => {
	store.getUser(store.loginUserId); //store.sessionUser
});

const password = ref('');
const passwordCheck = ref('');
const isValidPw = ref(false);
const isSamePw = ref(false);

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
		id: store.loginUserId,
		password: password.value,
  };
	axios.post(`${REST_SSAFIT_API}/changePw`, user)
	.then((res)=>{
		console.log(res.data)
		if (res.data == 'success') {
			alert('비밀번호 변경이 완료되었습니다.')
		} else {
			alert('비밀번호 변경에 실패했습니다.')
		}
	})
	password.value = '';
  passwordCheck.value = '';
};

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
	margin: 20px 25px;
	padding: 8px 14px;
}
.modal-body {
	padding: 25px 25px;
	/* 12:30 코드 및 ppt 제출. 발표 2시 시작 발표 시간: 10분. 이 안에 발표, 시연, qna 모두 해결. 5시까지 발표 완료 후 리더 계정에서 평가 진행. 발표는 앞에서. 시연은 webex로 하든지. */
}
.form-label {
	font-weight: 500;
}
.form-label-2 {
	margin-top: 20px;
}
</style>