<template>
	<div class="container">
		<div class="regist-title">회원가입</div>
		<div class="form-con">
			
			<div class="input-con row mb-4">
				<label for="id" class="col-sm-2 col-form-label">아이디</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="id" placeholder="아이디를 입력하세요" required autocomplete="off"
					v-model="id"	
					:class="{ 'is-valid': idFlag, 'is-invalid': !idFlag }"/>
					<div v-if="!isValidId" class="form-text">영문자와 숫자 조합의 4~12자리를 사용하세요</div>
					<div class="btn-dup">
						<button @click="duplicateIdCheck(id)" class="btn btn-sm btn-primary">중복 확인</button>
						<span v-if="dupIdClicked && isDuplicateId" class="form-text">사용할 수 있는 아이디입니다</span>
						<span v-if="dupIdClicked && !isDuplicateId" class="form-text">중복된 아이디입니다</span>
					</div>
				</div>
			</div>
			
			<div class="input-con row mb-4">
				<label for="password" class="col-sm-2 form-label">비밀번호</label>
				<div class="col-sm-10">
					<input class="form-control" type="password" id="password" placeholder="비밀번호를 입력하세요" required
					v-model="password"
					:class="{'is-valid' : isValidPw, 'is-invalid' : !isValidPw}">
					<div v-if="isValidPw" class="form-text pw-text">사용할 수 있는 비밀번호입니다</div>
					<div v-else="!isValidPw" class="form-text pw-text">영문자, 숫자 및 특수문자(@&!%*#?&) 조합의 6~20자리를 사용하세요</div>
					
					<input class="form-control" type="password" id="passwordCheck" placeholder="비밀번호 재확인" required
					v-model="passwordCheck" 
					:class="{'is-valid' : isSamePw, 'is-invalid' : !isSamePw}">
					<div v-if="isSamePw" class="form-text">비밀번호가 일치합니다.</div>
					<div v-else="!isSamePw" class="form-text">비밀번호가 일치하지 않습니다</div>
				</div>
			</div>

			<div class="input-con row mb-4">
				<label for="name" class="col-sm-2 form-label">이름</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="name" placeholder="이름을 입력하세요" required autocomplete="off"
					v-model="name">
					</div>
				</div>

			<div class="input-con row mb-4">
				<label for="nickname" class="col-sm-2 form-label">닉네임</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="nickname" placeholder="사용하실 닉네임을 입력하세요" required autocomplete="off"
					v-model="nickname">
					</div>
				</div>

			<div class="input-con row mb-4">
				<label for="email" class="col-sm-2 form-label">이메일</label>
				<div class="col-sm-10">
				<input class="form-control" type="email" id="email" placeholder="you@example.com" autocomplete="off"
				v-model="email">
				</div>
			</div>

			<div class="input-con row mb-4">
				<label for="birth" class="col-sm-2 form-label">생년월일</label>
				<div class="col-sm-10">
					<div>
						<Datepicker 
							v-model="date" 
							locale="ko"
							weekStart="0"
							auto-apply
							placeholder="YYYY-MM-DD (선택)"
							year-first
							:format="format"
						/>
					</div>
				</div>
			</div>

			<div class="d-grid" @click="shake">
				<button class="btn btn-primary" 
					@click="registUser" 
					:disabled="submitFlag"
					:class="{ 'shake': isSubClicked && submitFlag }">
					가입
				</button>
				<div v-if="submitFlag" class="form-text sub-text">입력 조건을 만족해주세요</div>
			</div>
		</div>
	</div>
</template>

<script setup>

import {ref, computed, watch, onMounted } from 'vue';
import { useUserStore } from '@/stores/user';
import Datepicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css';

const store = useUserStore();

onMounted(() => {
  store.getUserList();
});

const id = ref('');
const password = ref('');
const passwordCheck = ref('');
const name = ref('');
const nickname = ref('');
const email = ref(null);

const date = ref();
const birth = ref(null);
const format = (date) => {
  const day = date.getDate().toString().padStart(2, '0');
  const month =(date.getMonth() + 1).toString().padStart(2, '0');
  const year = date.getFullYear();
	birth.value  = `${year}-${month}-${day}`;
  return birth.value;
}

//아이디 확인
const isValidId = ref(false);
const isDuplicateId = ref(false);
const dupIdClicked = ref(false);
const idFlag = computed(()=> isValidId.value && isDuplicateId.value)

watch(id, (newId) => {
	dupIdClicked.value = false;
	isDuplicateId.value = false;
	checkId(newId)
});
const checkId = function(id) {
	const validateId = /^[A-Za-z0-9]{4,12}$/;
	isValidId.value = validateId.test(id);
};

const duplicateIdCheck = function(checkId) {
	dupIdClicked.value = true;
	const flag1 = ref(false);
  for (const u of store.userList) {
    if (u.id === checkId)
			flag1.value = true; //중복값이 있음
	}
	
	if (flag1.value) { //중복값 있음
		isDuplicateId.value = false;
		alert("이미 존재하는 아이디입니다.");
		id.value = ''; //아이디 텍스트 초기화
	} else {
		isDuplicateId.value = true;
	}
}

//비밀번호 확인
const isValidPw = ref(false);
watch(password, (newPw) => {
	isSamePw.value = false;
	checkPw(newPw);
	samePw();
});
const checkPw = function(pw) {
	const validatePw = /^(?=.*\d)(?=.*[@&!%*#?&])[A-Za-z\d@&!%*#?&]{6,16}$/;
	isValidPw.value = validatePw.test(pw);
};

const isSamePw = ref(false);
watch(passwordCheck, (checkPw)=>{
	isSamePw.value = false;
	samePw();
});
const samePw = function() {
	if (passwordCheck.value === password.value)
		isSamePw.value = true;
}

//이름 확인
const isValidName = ref(false);
watch(name, (newName)=>{
	checkName(newName);
})
const checkName = function(name){
	const validateName = /^[a-zA-Z가-힣]*$/;
	isValidName.value = validateName.test(name);
}

//이메일 확인
const isValidEmail = ref(false);
watch(email, (newEmail)=>{
	checkEmail(newEmail);
})
const checkEmail = function(email){
	const checkEmail = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-za-z0-9\-]+/;
	isValidEmail.value = checkEmail.test(email);
}

//유저 등록
const registUser = function() {
	if (isValidId.value && isDuplicateId.value) {
    store.registUser({
      id: id.value,
      password: password.value,
      passwordCheck: passwordCheck.value,
      name: name.value,
			nickname: nickname.value,
      birth: birth.value,
      email: email.value,
    });
  }
};

const isSubClicked = ref(false);
const shake = function() {
  if (submitFlag) {
    isSubClicked.value = true;

    setTimeout(() => {
      isSubClicked.value = false;
    }, 500);
  }
};

//회원가입 버튼 flag
const submitFlag = computed(() => {
	return id.value === '' ||
					name.value === '' ||
					password.value === '' ||
					passwordCheck.value === '' ||
					idFlag.value === false ||
					isValidPw.value === false ||
					isSamePw.value === false ||
					isValidName.value === false ||
					isValidEmail.value === false
});



</script>

<style scoped>
	* {
		font-weight: 600;
	}
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
		margin: 10px 0px 20px;
		border-width: 0px 0px 1px 0px;
		border-color: black;
		border-style: solid;
	}
	.form-con .input-con {
		margin-bottom: 20px;
	}
	.sub-text {
		text-align: center;
	}
	.pw-text {
		margin-bottom: 10px;
	}
	.btn-dup {
		margin-top: 4px;
	}
	.btn-dup button {
		margin-right: 5px;
	}
	.shake {
  	animation: shake 0.45s;
	}

	@keyframes shake {
		0% { transform: translateX(0); }
		25% { transform: translateX(-5px); }
		50% { transform: translateX(5px); }
		75% { transform: translateX(-5px); }
		100% { transform: translateX(0); }
	}
</style>