<template>
	<div>
		<hr>
		<h4>api 연습</h4>
		<VideoTempList/>
	</div>
</template>

<script setup>
import {ref, onMounted} from 'vue'
import { useYoutubeStore } from '@/stores/youtube';
import VideoTempList from '@/components/youtubeTemp/VideoTempList.vue';

// const store = useYoutubeStore();

// const loadVideos = (keyword) => {
//   store.youtubeSearch(keyword)
// }

// onMounted(() => {
// 	store.youtubeSearch('운동 영상')
//   store.videos;
// })

</script>

<style scoped>
	.video-api * {
		font-size: 1rem;
		font-weight: 400;
	}
</style>