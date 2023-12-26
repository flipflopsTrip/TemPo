<template>
  <div class="container my-con my-board">
    <div class="detail-con">
      <div class="ifame-area">
        <iframe 
          width="560" height="315" 
          :src="videoURL" 
          title="YouTube video player" 
          frameborder="0" 
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen>
        </iframe>
      </div>
      <div class="detail-title">{{ truncateTitle(store.clickedVideo.title) }}</div>
      <div class="detail-content d-flex align-items-center">
        <div><i class="bi bi-person-circle"></i></div>
        <div class="detail-sub">
          <div>{{ store.clickedVideo.youtuber }}</div>
          <div>{{ store.clickedVideo.regDate }}</div>
        </div>
        <wish :videoId="videoIdd" />
      </div>
    </div>

    <div class="d-flex justify-content-center vote-con">
      <levelVote :videoId="videoIdd" />
    </div>

    <div>
      <table class="table mb-3">
        <thead class="my-thead">
          <tr class="text-center">
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody v-if="storeR.reviewList.length > 0">
          <tr v-for="review in storeR.reviewList" :key="review.reviewId" class="text-center my-hover">
            <td>{{ review.reviewId }}</td>
            <td class="all-links">
              <RouterLink :to="`/review/${review.reviewId}`">{{
                review.title
              }}</RouterLink>
            </td>
            <td>{{ review.userId }}</td>
            <td>{{ review.viewCnt }}</td>
            <td>{{ review.regDate }}</td>
          </tr>
        </tbody>
        <tbody v-else>
          <tr class="text-center">
            <td colspan="5">등록된 리뷰가 없습니다</td>
          </tr>
        </tbody>
      </table>
      <div class="d-flex justify-content-end">
        <RouterLink
          :to="{ name: 'ReviewCreate' }"
          class="my-btn"
          >리뷰 작성 <i class="bi bi-pencil-square"></i></RouterLink
        >
      </div>
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
  // if (videoIdd) {
    // store.getVideo(videoIdd);
    // storeR.getReviewList(videoIdd);
  // }
  store.getVideo(videoIdd);
  storeR.getReviewList(videoIdd);
})

const truncateTitle = (title) => {
  const maxLength = 44;
  const decodedTitle = document.createElement('textarea');
  decodedTitle.innerHTML = title;
  const truncatedTitle = decodedTitle.value.length > maxLength
    ? `${decodedTitle.value.slice(0, maxLength)}...`
    : decodedTitle.value;
  return truncatedTitle;
};

</script>

<style scoped>
a {
  text-decoration: none;
}
.my-con {
	margin-bottom: 100px;
}
.my-board {
  margin-top: 20px;
  width: 50%;
}
.ifame-area {
  position: relative; 
  width: 100%;
  padding-bottom: 56.25%; 
}
.ifame-area > iframe {
  position: absolute;
  width: 100%; 
  height: 100%;
  border-radius: 8px;
}
.detail-con {
  margin-bottom: 60px;
}
.detail-title {
  font-size: 1.3rem;
  font-weight: 600;
  letter-spacing: -0.5px;
  padding: 10px 0px;
}
.detail-content > div:nth-child(1) {
  margin-right: 10px;
}
.detail-content > div:nth-child(2) {
  margin-right: 10px;
}
.detail-content > div > i {
  font-size: 2rem;
  color: #4b4b4b;
}
.detail-sub {
  line-height: 20px;
}
.detail-sub > div:first-child {
  font-size: 1.1rem;
  letter-spacing: -0.5px;
  font-weight: 500;
}
.detail-sub > div:last-child {
  color: #373737;
  letter-spacing: -0.5px;
}
.vote-con {
  border: 1px solid #ddd;
  border-radius: 6px;
  padding: 20px;
  margin-bottom: 50px;
}
tr.my-hover:hover td {
	background-color: #9db2bf28;
}
.all-links > a {
	color: black;
	text-decoration: none;
}
.all-links > a:hover {
	text-decoration: underline;
}
table > thead > tr > th:nth-child(1) {
	width: 10%;
}
table > thead > tr > th:nth-child(3) {
	width: 15%;
}
table > thead > tr > th:nth-child(4) {
	width: 10%;
}
table > thead > tr > th:nth-child(5) {
	width: 15%;
}
.my-btn {
  color: #4b565c;
	border: 1px solid #9DB2BF;
	border-radius: 6px;
	padding: 6px 8px;
	margin-right: 10px;
  text-decoration: none;
  background-color: #f0f0f0;
}
.my-btn:hover {
	color: black;
	background-color: #9db2bf3d;
}
.my-thead {
  border-bottom: 1px solid #ccc;
	border-top: 2px solid #9DB2BF;
	padding: 2px 10px;
}
thead th {
  background-color: #e5ecf2;
}
tbody > tr:last-child {
  border-bottom: 2px solid #9DB2BF;
}

</style>
