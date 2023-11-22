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
      <wish :videoId="videoIdd" />
    </div>
    <div>
      <!--난이도 투표-->
      <!-- <levelVote :videoId="store.clickedVideo.videoId" /> -->
    </div>

    <div>
      <h3>리뷰 목록</h3>
      <hr />
      <div style="display: flex; justify-content: space-between">
        <button type="button" class="btn btn-secondary" @click="goBack">
          목록
        </button>
        <button
          type="button"
          class="btn btn-primary"
          style="text-decoration-color: white"
        >
          <RouterLink
            :to="{ name: 'ReviewCreate' }"
            style="color: white; text-decoration: none"
            >리뷰 작성</RouterLink
          >
        </button>
      </div>
      <table class="table table-hover">
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
import wish from "@/components/wish/wish.vue";
import levelVote from "@/components/levelVote/levelVote.vue";

const store = useVideoStore();
const storeR = useReviewStore();
const router = useRouter();
const route = useRoute();

const videoURL = computed(()=>{
	const videoId = store.clickedVideo.url;
	return `https://www.youtube.com/embed/${videoId}`;
});

const goBack = () => {
  router.push("/video");
};

//아직 clickVideo를 처리하지 못한 상태일 수 있기 때문에 처리 후 videoId 받아 사용할 수 있게 if문으로 수정
const videoIdd = route.params.videoId;
onMounted(() => {
  if (videoIdd) {
    // store.getVideo(videoIdd);
    // storeR.getReviewList(videoIdd);
  }
  storeR.getReviewList(store.clickedVideo.videoId);
})

</script>

<style scoped>
a {
  text-decoration: none;
}
</style>
