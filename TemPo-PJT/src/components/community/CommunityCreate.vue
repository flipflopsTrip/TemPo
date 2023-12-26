<template>
  <div class="container my-con my-board">
    <div class="card mt-4">
      <div class="card-header title">게시글 작성</div>
      <div class="card-body">
        <div class="mb-3">
          <label for="category" class="form-label">구분</label>
          <select class="form-select" name="category" id="category" v-model="category">
            <option v-for="c in categories" :key="c.no" :value="c.ca">{{ c.ca }}</option>
          </select>
        </div>
        <div class="mb-3">
          <label for="title" class="form-label">제목</label>
          <input type="text" class="form-control" id="title" v-model="title" />
        </div>
        <div class="mb-3">
          <label for="content" class="form-label">내용</label>
          <textarea class="form-control" id="content" cols="30" rows="5" v-model="content"></textarea>
        </div>
        <div class="mb-3 d-flex justify-content-end">
          <button class="my-btn me-2" @click="createCommunity">작성 <i class="bi bi-pencil-fill"></i></button>
          <button class="my-btn" @click="goBack">취소 <i class="bi bi-arrow-90deg-left"></i></button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useCommunityStore } from "@/stores/community";
import { useRoute, useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";
const store = useCommunityStore();
const storeU = useUserStore(); //로그인한 유저의 아이디를 가져오기 위해서 추가
const router = useRouter();
// const community = ref({
//   category: "",
//   title: "",
//   userId: storeU.loginUserId, //추가
//   content: "",
// });

const category = ref('잡담');
const title = ref('');
const content = ref('');

const categories = ref([
  {
    no: 1,
    ca: "잡담",
  },
  {
    no: 2,
    ca: "Q&A",
  },
  {
    no: 3,
    ca: "정보",
  },
  {
    no: 4,
    ca: "홍보",
  },
]);

const createCommunity = function () {
  // store.createCommunity(community.value);
  const community = ref({
    category : category.value,
    title : title.value,
    userId : storeU.loginUserId,
    content : content.value,
  })
  store.createCommunity(community);
};
const goBack = () => {
  router.back();
};
</script>

<style scoped>
.my-con {
	margin-bottom: 100px;
}
.my-board {
  width: 40%;
}
.title {
  font-size: 1.8rem;
  font-weight: 500;
  padding: 15px 0px;
  margin: 5px 20px;
  background-color: white;
}
.my-btn {
  color: #4b565c;
	border: 1px solid #9DB2BF;
	border-radius: 6px;
	padding: 6px 8px;
	margin-right: 10px;
}
.my-btn:hover {
	color: black;
	background-color: #9db2bf3d;
}
</style>
