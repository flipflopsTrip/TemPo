<template>
  <div>
    <h2>Video&View</h2>
    <div>
      <div>
        <iframe 
          width="560" height="315" 
          :src="videoURL" 
          title="YouTube video player" 
          frameborder="0" 
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen>
        </iframe>
      </div>
      <div>{{ store.clickedVideo.title }}</div>
      <div>{{ store.clickedVideo.youtuber }}</div>
    </div>

    <div>
      <h3>리뷰 목록</h3>
      <hr />
      <div>
        <RouterLink :to="{ name: 'ReviewCreate' }">리뷰 작성</RouterLink>
      </div>
      <table>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>조회수</th>
        </tr>
        <tr v-for="review in storeR.reviewList" :key="review.reviewId">
          <td>{{ review.reviewId }}</td>
          <td>
            <RouterLink :to="`/review/${review.reviewId}`">{{
              review.title
            }}</RouterLink>
          </td>
          <td>{{ review.userId }}</td>
          <td>{{ review.regDate }}</td>
          <td>{{ review.viewCnt }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script setup>
import { onMounted, computed } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useVideoStore } from "@/stores/video";
import { useReviewStore } from "@/stores/review";

const store = useVideoStore();
const storeR = useReviewStore();
const router = useRouter();
const route = useRoute();

const videoURL = computed(()=>{
	const videoId = store.clickedVideo.url;
	return `https://www.youtube.com/embed/${videoId}`;
});

onMounted(() => {
	storeR.getReviewList(store.clickedVideo.videoId);
})

</script>

<style scoped></style>
