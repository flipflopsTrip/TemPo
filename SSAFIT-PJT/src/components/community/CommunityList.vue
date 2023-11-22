<template>
  <div>
    <h4>게시글 목록</h4>
    <hr />

    <button type="button" class="btn btn-primary">
      <RouterLink
        :to="{ name: 'communityCreate' }"
        style="color: white; text-decoration: none"
        >게시글 작성</RouterLink
      >
    </button>
    <table class="table table-hover">
      <tr>
        <th class="text-center">글 번호</th>
        <th class="text-center">구분</th>
        <th>제목</th>
        <th class="text-center">작성자</th>
        <th class="text-center">조회수</th>
        <th class="text-center">등록일</th>
      </tr>
      <tr v-for="community in store.communityList" :key="community.communityId">
        <td class="text-center">{{ community.communityId }}</td>
        <td class="text-center">{{ community.category }}</td>
        <td>
          <RouterLink
            :to="`/community/${community.communityId}`"
            style="color: red"
            >{{ community.title }}</RouterLink
          ><!--@GetMapping("/community/{communityId}")-->
        </td>
        <td class="text-center">{{ community.userId }}</td>
        <td class="text-center">{{ community.viewCnt }}</td>
        <td class="text-center">{{ community.regDate }}</td>
      </tr>
    </table>
    <br />
    <br />
    <CommunitySearchInput />
  </div>
</template>

<script setup>
import { useCommunityStore } from "@/stores/community";
import { useRoute, useRouter } from "vue-router";
import { onMounted } from "vue";
import CommunitySearchInput from "@/components/community/CommunitySearchInput.vue";
const store = useCommunityStore();
const router = useRouter();
const route = useRoute();

onMounted(() => {
  store.getCommunityList();
});
</script>

<style scoped></style>
