import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios';
import router from '@/router'

const REST_SSAFIT_API = `http://localhost:8080/api-user`;

export const useUserStore = defineStore('user', () => {
  //회원 등록하기
  const registUser = function(user) {
    console.log(user)
    axios.post(`${REST_SSAFIT_API}/user`, user)
    .then((res)=>{
      userList.value = ''; //전체 유저 데이터를 계속 갖고 있기 힘드니까
      router.push({name: 'home'})
    })
    .catch((err)=>{
      console.log(err);
    })
  };

  //회원 목록 전체
  const userList = ref([]);
  const getUserList = function() {
    axios.get(`${REST_SSAFIT_API}/user`)
    .then((res)=>{
      userList.value = Array.isArray(res.data) ? res.data : [];
    })
    .catch((err)=>{
      console.log(err)
    })
  };
  
  //로그인
  const loginUserId = ref('');
  const login = function(loginUser) {
    axios.post(`${REST_SSAFIT_API}/login`, loginUser)
    .then((res)=>{
      if (res.data !== '')  {
        loginUserId.value = res.data;
        localStorage.setItem("loginUserId", JSON.stringify(loginUserId.value));
        alert('로그인 성공');
        router.push({name: 'home'});
      }
      else {
        alert('로그인 실패')
      }
    })
    .catch((err)=>{
      console.log(err)
    })
  };
  
  //로그아웃
  const logout = function() {
    axios.get(`${REST_SSAFIT_API}/logout`)
    .then((res)=>{
      localStorage.removeItem("loginUserId");
      loginUserId.value = '';
    })
    .catch((err)=>{
      console.log(err)
    })
  }


  return { registUser, userList, getUserList, loginUserId, login, logout, }
})
