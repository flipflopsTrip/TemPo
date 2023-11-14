import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios';

const REST_SSAFIT_API = `http://localhost:8080/api-video/video`;

export const useVideoStore = defineStore('video', () => {
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
  const video = ref([]);
  const getVideo = function(id) {
    axios.get(`${REST_SSAFIT_API}/${id}`)
    .then((res)=>{
      video.value = res.data;
    })
    .catch((err)=>{
      console.log(err)
    })
  };

  return { videoList, getVideoList, video, getVideo,  }
})
