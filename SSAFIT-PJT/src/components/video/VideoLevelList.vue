<template>
	<div class="container my-con">
		<header>
      <div>Fitness Videos by Level</div>
    </header>

		<div class="btn-container">
			<button @click="loadLevelVideos(100)" class="btn btn-warning">전체</button>
			<button @click="loadLevelVideos(1)" class="btn btn-warning"><i class="bi bi-star-fill"></i>1</button>
			<button @click="loadLevelVideos(2)" class="btn btn-warning"><i class="bi bi-star-fill"></i>2</button>
			<button @click="loadLevelVideos(3)" class="btn btn-warning"><i class="bi bi-star-fill"></i>3</button>
			<button @click="loadLevelVideos(4)" class="btn btn-warning"><i class="bi bi-star-fill"></i>4</button>
			<button @click="loadLevelVideos(5)" class="btn btn-warning"><i class="bi bi-star-fill"></i>5</button>
		</div>

		<div class="video-container">
			<div v-if="store.levelVideos.length == 0">해당 난이도의 운동영상이 없습니다.</div>
			<table v-else class="table">
				<thead class="my-thead">
					<tr class="text-center">
						<th>번호</th>
						<th>난이도</th>
						<th>내용</th>
						<th>채널</th>
						<th>업로드 날짜</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="(video, index) in store.levelVideos" :key="video.videoId" class="text-center my-hover">
						<td>{{ index + 1 }}</td>
						<td>
							<span v-if="video.level != 0"><i class="bi bi-star-fill level-bi"></i>{{ video.level }}</span>
							<span v-else>미정</span>
						</td>
						<td class="all-links">
							<RouterLink
								:to="{
									name: 'videoDetail',
									params: { videoId: video.videoId },
								}"
							><span>{{ truncateTitle(video.title) }}</span> <span>({{ video.reviewCount }})</span></RouterLink>
						</td>
						<td>{{ video.youtuber }}</td>
						<td>{{ video.regDate }}</td>
					</tr>
				</tbody>
			</table>

		</div>

	</div>
</template>

<script setup>
import {ref, onMounted,computed} from 'vue'
import { useVideoStore } from '@/stores/video';

const store = useVideoStore();

const level = ref(100);

onMounted(() => {
	store.getLevelVideos(level.value);
});

const loadLevelVideos = function(lv) {
	level.value = lv;
	store.getLevelVideos(level.value);
}

const showDetail = function(video) {

}

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
header {
	background-color: #fff;
	padding: 15px;
	margin: 10px 0px;
	text-align: center;
}
header > div {
	font-size: 2rem;
	font-weight: 500;
}
.btn-container {
	display: flex;
	justify-content: center;
}
.btn-container > button {
	margin: 0px 10px;
}

.video-container {
	margin: 20px auto;
	padding: 0 120px;
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
.all-links > span:nth-child(1) {
	font-weight: 400;
}
table > thead > tr > th:nth-child(1) {
	width: 6%;
}
table > thead > tr > th:nth-child(2) {
	width: 8%;
}
table > thead > tr > th:nth-child(4) {
	width: 20%;
}
table > thead > tr > th:last-child {
	width: 12%;
}
.level-bi {
	color: #ffc107;
}
.my-con {
	margin-bottom: 100px;
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