<template>
  <header>
    <nav class="header-nav">
      <div>
        <RouterLink to="/" class="logo"><img src="@/assets/logo.png" alt="logo" class="logo"></RouterLink>
        <RouterLink to="/video">운동영상</RouterLink>
      </div>
      <div>
        <span v-if="store.loginUserId">{{ store.sessionUser.nickname }}님 반갑습니다</span>
        <RouterLink :to="{ name : 'MyPage' }" v-if="store.loginUserId">마이페이지</RouterLink>
        <a href="#" v-if="store.loginUserId" @click="logout" class="logout">로그아웃</a>
        <RouterLink :to="{ name : 'UserLogin' }" v-if="!store.loginUserId">로그인</RouterLink>
        <RouterLink :to="{ name: 'UserRegist' }" v-if="!store.loginUserId">회원가입</RouterLink>
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
  background-color: #27374D;
  line-height: 70px;
  padding: 0px 30px;
}

header a {
  margin: 10px;
  text-decoration: none;
  color: white;
}
.logout {
  font-size: 0.9rem;
}
header span {
  margin: 10px;
  color: white;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}
.logo {
  width: 110px;
  color: white;
}
</style>
