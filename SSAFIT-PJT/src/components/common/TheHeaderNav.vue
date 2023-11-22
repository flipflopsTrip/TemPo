<template>
  <header>
    <nav class="header-nav">
      <div>
        <RouterLink to="/" class="logo"><img src="@/assets/logo.png" alt="logo" class="logo"></RouterLink>
      </div>
      <div class="content-link">
        <a class="dropdown dropdown-toggle dropdown-con" role="button" data-bs-toggle="dropdown" aria-expanded="false">운동영상</a>
        <ul class="dropdown-menu dropdown-menu-end">
          <li><RouterLink to="/video" class="dropdown-item"><span>부위별 운동영상</span></RouterLink></li>
          <li><RouterLink to="/video" class="dropdown-item"><span>난이도별 운동영상</span></RouterLink></li>
        </ul>
        
        <RouterLink to="/community">Community</RouterLink>
        <RouterLink to="/shopping">Shopping</RouterLink>
        <RouterLink to="/kcalCalculator">칼로리 계산기</RouterLink>
      </div>
      <div>
        <RouterLink :to="{ name : 'UserLogin' }" v-if="!store.loginUserId">로그인</RouterLink>
        <RouterLink :to="{ name: 'UserRegist' }" v-if="!store.loginUserId">회원가입</RouterLink>
        <div class="dropdown dropdown-toggle dropdown-con" data-bs-toggle="dropdown" aria-expanded="false" v-if="store.loginUserId">
          <span v-if="store.loginUserId" class="">{{ store.sessionUser.nickname }}님 반갑습니다</span>
        </div>
        <ul class="dropdown-menu dropdown-menu-end">
          <li><RouterLink :to="{ name : 'MyPageMain' }" v-if="store.loginUserId" class="dropdown-item"><span>마이페이지</span></RouterLink></li>
          <li><a href="#" v-if="store.loginUserId" @click="logout" class="logout dropdown-item"><span>로그아웃</span></a></li>
        </ul>
        
        
      </div> 
    </nav>
  </header>
</template>

<script setup>
import {ref, computed, watch, onMounted } from 'vue';
import { useUserStore } from '@/stores/user';
import { useRouter } from 'vue-router';

const store = useUserStore();
const router = useRouter();

// onMounted(() => {
  //   store.getId();
// });
store.getId();
router.beforeEach(async (to, from, next) => {
  if (store.loginUserId != null) {
    await store.getUser(store.loginUserId);
    next();
  }
});

 const logout = function() {
  store.logout();
  store.loginUserId = null;
  store.sessionUser = null;
};

</script>

<style scoped>
header {
  height: 70px;
  background-color: rgba(164, 191, 211, 0.29);
  line-height: 70px;
  padding: 0px 80px;
  border-bottom: 1px solid #d1d9e0;
}

header a {
  margin: 10px;
  text-decoration: none;
  color: #27374dea;
  font-size: 1.1rem;
  font-weight: 500;
}
/* .logout {
  font-size: 0.9rem;
} */
header span {
  margin: 10px;
  color: #27374dea;
  font-size: 1.1rem;
  font-weight: 500;
}

.header-nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.logo {
  width: 120px;
  color: white;
}
.router-link-active {
  /* background: linear-gradient(to top, #FFD717 8%, transparent 8%); */
  /* color: #ffdd30; */
  color: #27374D !important;
  font-weight: 700;
}
.dropdown-menu {
  width: 250;
  border: 1px solid #eee;
  border-radius: 8px;
  box-shadow: rgba(0, 0, 0, 0.14) 0px 3px 12px;
  padding: 10px 0px;
}
.dropdown-menu li{
  width: 250px;
}
.dropdown-menu .dropdown-item {
  margin: 0px;
  padding: 0px 10px;
  height: 50px;
}
.dropdown-menu .dropdown-item > span {
  position: relative;
    bottom: 10px;
}
.dropdown-menu .dropdown-item:active {
  background-color: white;
  color: #27374D;
}
.dropdown-menu .dropdown-item:hover {
  background-color: rgba(182, 206, 223, 0.095);
  color: #27374D
}
.dropdown-con {
  color: #27374dea;
  font-weight: 500;
  cursor: pointer;
}
.content-link > a{
  margin: 0px 20px;
}
</style>
