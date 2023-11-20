import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_SSAFIT_API = `http://localhost:8080/api-video`;

export const useVideoStore = defineStore('video', () => {
  //유튜브 api 검색 후 가져오기
  const videos = ref([])
  const youtubeSearch = function(keyword){
    const URL = 'https://www.googleapis.com/youtube/v3/search';
    const API_KEY = import.meta.env.VITE_YOUTUBE_API_KEY;
    axios({
      url: URL,
      method: "GET",
      params: {
        key: API_KEY,
        part: "snippet",
        q: keyword,
        type: 'video',
        maxResults: 3
      }
    })
    .then((response)=>{
      videos.value = response.data.items
    })
    .catch((err)=>{console.log(err)})
  }

  //클릭한 영상 db 저장
  const clickedVideo = ref([]);
  const clickVideo = function(video){
    //video.url로 db에 있는 영상인지 아닌지 확인
    axios.post(`${REST_SSAFIT_API}/check`, video.url)
    .then((res)=>{
      if (res.data != '') { //db에 이미 들어있는 영상
        console.log("2. check: (t)"+res.data)
        console.log("비디오아이디(pk): "+res.data.videoId)
        clickedVideo.value = res.data;
        //detail로 router push
        router.push({name: 'videoDetail', params: { videoId: res.data.videoId}});
      } else { //새 영상
        console.log("2. check: (f)"+res.data)
        axios.post(`${REST_SSAFIT_API}/video`, video)
        .then((res2)=>{
          console.log("3. insert 완료"+res2)
          //detail로 router push
          router.push({name: 'videoDetail', params: { videoId: res2.data.videoId}});
        })
      }
    })
    .catch((err)=>{console.log(err)})
  }

  //영상 전체
  const videoList = ref([]);
  const getVideoList = function() {
    axios.get(REST_SSAFIT_API)
    .then((res)=>{
      videoList.value = res.data;
    })
    .catch((err)=>{
      console.log(err);
    })
  };

  //영상 1개
  const getVideo = function(id) {
    axios.get(`${REST_SSAFIT_API}/${id}`)
    .then((res)=>{
      video.value = res.data;
    })
    .catch((err)=>{
      console.log(err)
    })
  };

  return { videos, youtubeSearch, clickVideo, clickedVideo, videoList, getVideoList, getVideo, }
})
