<template>
  <header>
    <nav class="header-nav">
      <div>
        <RouterLink to="/" class="logo"
          ><img src="@/assets/logo.png" alt="logo" class="logo"
        /></RouterLink>
        <RouterLink to="/video">운동영상</RouterLink>
      </div>
      <div>
        <RouterLink to="/community">Community</RouterLink>
      </div>
      <div>
        <RouterLink to="/shopping">Shopping</RouterLink>
      </div>
      <div>
        <a href="#" v-if="store.loginUserId" @click="logout">로그아웃</a>
        <RouterLink :to="{ name: 'UserLogin' }" v-if="!store.loginUserId"
          >로그인</RouterLink
        >
        <RouterLink :to="{ name: 'UserRegist' }" v-if="!store.loginUserId"
          >회원가입</RouterLink
        >
      </div>
    </nav>
  </header>
</template>

<script setup>
import { ref, computed, watch, onMounted } from "vue";
import { useUserStore } from "@/stores/user";

const store = useUserStore();

onMounted(() => {
  const savedUser = localStorage.getItem("loginUserId");
  if (savedUser) {
    store.loginUserId = JSON.parse(savedUser);
  }
  console.log("현재 로그인 유저의 id : " + store.loginUserId);
});

const logout = function () {
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
