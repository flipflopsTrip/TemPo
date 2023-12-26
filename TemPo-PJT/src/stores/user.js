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
      console.log(res)
      if (res.data != '')  {
        sessionStorage.setItem('access-token', res.data["access-token"]);
        loginUserId.value = loginUser.id;
        alert('로그인 성공');
        // router.go(-1); //뒤로가기(보고있던 페이지로 이동)
        router.push({name: 'home'})
      }
      else {
        alert('로그인 실패')
      }
    })
    .catch((err)=>{
      alert('로그인 실패')
      console.log(err)
    })
  };

  //sessionStorage에서 id 가져오기
  //store.loginUserId
  const getId = function() {
    //id 추출
    if (sessionStorage.getItem(['access-token']) != null){
      const token = sessionStorage.getItem(['access-token']).split('.');
      let id = token[1]
      id = atob(id) //base64 복호화
      id = JSON.parse(id)
      //id 저장
      loginUserId.value = id['id']
      console.log("3. id: "+loginUserId.value)
    } else {
      console.log("로그인 안함")
    }
  }

  /*
   로그인한 유저의 정보! 가져오는 법
   0. store.getId(); 를 한다. (store.loginUserId에 id가 저장됨)
   1. store.getUser(store.loginUserId); 를 한다. (store.sessionUser 안에 유저정보가 객체 형식으로 저장됨)
   2. store.sessionUser 을 사용.
  */
  const sessionUser = ref('');
  const getUser = function(sessionId) {
    axios.post(`${REST_SSAFIT_API}/user/${sessionId}`)
    .then((res)=>{
      sessionUser.value = res.data;
    })
    .catch((err)=>{
      console.log(err);
    })
  }
  
  //로그아웃
  const logout = function() {
    axios.get(`${REST_SSAFIT_API}/logout`)
    .then(()=>{
      sessionStorage.removeItem("access-token");
      loginUserId.value = '';
    })
    .catch((err)=>{
      console.log(err)
    })
  }



  return { registUser, userList, getUserList, loginUserId, login, getUser, sessionUser, logout, getId, }
})
