<template>
<div class="container">

  <div class="card">
    <div class="card-header">
      <img src="@/assets/logo.png" alt="logo" class="logo">
    </div>
    <div class="card-body">
      <div class="mb-3">
          <div class="input-group">
            <span class="input-group-text"><i class="bi bi-person"></i></span>
            <input type="text" class="form-control no-outline" id="id" placeholder="아이디" required v-model="id" @keyup.enter="login">
          </div>
        </div>
        <div class="mb-3">
          <div class="input-group">
            <span class="input-group-text"><i class="bi bi-lock"></i></span>
            <input type="password" class="form-control no-outline" id="password" placeholder="비밀번호" required v-model="password" @keyup.enter="login">
          </div>
        </div>
      <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input no-outline" id="rememberId" v-model="rememberId">
        <label class="form-check-label" for="rememberId">아이디 저장</label>
      </div>
      <button @click="login" class="btn btn-primary">로그인</button>
      <div class="or-seperator"><i>또는</i></div>
      <div class="text-center social-btn">
        <a href="#" class="btn btn-danger"><i class="bi bi-google"></i>&nbsp; Google</a>
        <a href="#" class="btn btn-primary">&nbsp; Kakao</a>
      </div>
    </div>
  </div>

  <div class="sub-card">
    <a>아이디 찾기</a><span>&nbsp;|&nbsp;</span> 
    <a>비밀번호 찾기</a><span>&nbsp;|&nbsp;</span>
    <RouterLink :to="{ name: 'UserRegist' }">회원가입</RouterLink>
  </div>
</div>
</template>

<script setup>
import {ref, computed, watch, onMounted } from 'vue';
import { useUserStore } from '@/stores/user';

const store = useUserStore();
const id = ref('');
const password = ref('');
const rememberId = ref(false);

const login = function() {
  store.login({
    id: id.value,
    password: password.value,
  });
  id.value = '';
  password.value = '';
};


</script>

<style scoped>
	* {
		font-weight: 400;
	}
  body {
    background-color: #f5f5f5;
  }
  .container {
    max-width: 450px;
    margin: 80px auto;
    letter-spacing: -0.4px;
  }
  .card {
    border: 1px solid rgb(226, 226, 226);
    border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    padding: 0px 10px 10px;
  }
  .card-header {
    background-color: white;
    color: rgb(44, 44, 44);
    text-align: center;
    border-bottom: none;
    padding: 30px 15px 10px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
  }
  img {
    width: 120px;
  }
  .form-control {
    border-radius: 5px;
  }
  .btn-primary {
    /* background-color: #8194b1bc; 로그인 버튼색 */
    border: none;
    width: 100%;
  }
  /* .btn-primary:hover {
    background-color: #8194b1e9;
  } */
  .float-end {
    color: black;
    text-decoration: none;
    font-size: 14px;
  }  
  .social-btn {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  .social-btn .btn {
    border: none;
    margin: 10px 3px 0;
    opacity: 1;
    width: 100%;
    height: 35px;
  }
  .social-btn .btn:hover {
    opacity: 0.9;
  }
  .social-btn .btn-primary {
    background: #FEE500;
  }
  .social-btn .btn-danger {
    background: #df4930;
  } 
  .or-seperator {
    margin-top: 40px;
    text-align: center;
    border-top: 1px solid #ccc;
  }
  .or-seperator i {
    padding: 0 10px;
    background: #ffffff;
    position: relative;
    top: -11px;
    z-index: 1;
  }  
  .input-group {
    border: 1px solid #ced4da; 
    border-radius: 5px; 
    margin-bottom: 15px; 
  }
  /* .input-group:focus { 클릭시테두리 색
    border: 1px solid rgb(8, 8, 8);
  } */
  .input-group-text {
    background-color: white;
    border: none;
    color: rgb(44, 44, 44);
    height: 100%;
  }
  .input-group-text i {
    font-size: 1.2rem;
    line-height: inherit;
  }
  .no-outline {
    outline: none !important;
    box-shadow: none !important;
    border: 0px;
  }
  .sub-card {
    display: flex;
    justify-content: center;
    align-items: center;
    letter-spacing: -0.4px;
  }
  .sub-card > a {
    padding: 10px;
    color: rgb(44, 44, 44);
    font-size: 0.92rem;
    text-decoration: none;
  }
  .form-check-input {
    border: 1px solid rgb(113, 113, 113);
  }
</style>