<template>
	<div>
		<header>
      <h2>My Fitness Videos임시</h2>
    </header>

		<div class="btn-container">
			<button @click="loadVideos('운동 영상')" class="btn btn-primary">전체</button>
			<button @click="loadVideos('상체 운동')" class="btn btn-primary">상체</button>
		</div>

    <div class="video-container">
      <div v-for="video in store.videos" :key="video.id.videoId" class="video-item">
          <img :src="video.snippet.thumbnails.medium.url" :alt="video.snippet.title" class="video-thumbnail"/>
          <div class="video-info">
            <div class="video-title">{{ truncateTitle(video.snippet.title) }}</div>
            <div class="video-details">
              <div>{{ video.snippet.channelTitle }}</div>
              <div>{{ new Date(video.snippet.publishedAt).toLocaleDateString() }}</div>
            </div>
          </div>
        </div>
    </div>
	</div>
</template>

<script setup>
import {ref, onMounted} from 'vue'
import { useYoutubeStore } from '@/stores/youtube';

const store = useYoutubeStore();

const loadVideos = function(keyword) {
  store.youtubeSearch(keyword)
}

onMounted(() => {
	store.youtubeSearch('운동 영상')
  store.videos;
	console.log(store.videos)
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
	header {
		background-color: #fff;
		padding: 15px;
		text-align: center;
	}
	.btn-container {
		display: flex;
		justify-content: center;
	}
	.btn-container > button {
		margin: 0px 10px;
	}
	
	.video-container {
		display: grid;
		grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
		gap: 20px;
		margin: 20px auto;
		padding: 0 120px;
	}

	.video-item {
		background-color: #fff;
		border: 1px solid #ddd;
		border-radius: 12px;
		overflow: hidden;
		box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
		cursor: pointer;
	}

	.video-thumbnail {
		width: 100%;
		height: auto;
	}
	.video-info {
		padding: 15px;
	}
	.video-title {
		font-size: 1.06rem;
		font-weight: 700;
		margin-bottom: 5px;
	}
	.video-details {
		color: #555;
	}
</style>