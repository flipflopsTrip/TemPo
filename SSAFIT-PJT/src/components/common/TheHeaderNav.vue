<template>
  <header>
    <nav class="header-nav">
      <div>
        <RouterLink to="/" class="logo"><img src="@/assets/logo.png" alt="logo" class="logo"></RouterLink>
        <RouterLink to="/video">운동영상</RouterLink>
      </div>
      <div>
        <a href="#" v-if="store.loginUserId" @click="logout">로그아웃</a>
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
const router = useRouter;

// onMounted(() => {
  //   store.getId();
// });
store.getId();

// router.beforeEach((to, from, next) => {
//   if (to.matched.some(record => record.meta.requiresAuth)) {
//     // This route requires authentication
//     if (!store.loginUserId) {
//       // Redirect to login page if not authenticated
//       next({
//         name: 'UserLogin',
//         query: { redirect: to.fullPath },
//       });
//     } else {
//       // Continue to the route
//       next();
//     }
//   } else {
//     // Continue to the route
//     next();
//   }
// });


  
const logout = function() {
  store.logout();
  store.loginUserId = null;
};

</script>

<style scoped>
header {
  height: 70px;
  background-color: #53e3a6;
  line-height: 70px;
  padding: 0px 30px;
}

header a {
  margin: 10px;
  text-decoration: none;
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
