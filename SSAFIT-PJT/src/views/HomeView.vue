<template>
  <div class="con">
    <!-- youtube api 용량 이슈로 주석 -->
    <!-- <VideoList /> -->
    <div class="con-child fade-in">
      <img src="@/assets/mainImg.jpg" alt="메인이미지">
    </div>
    <div class="con-child con-child-content fade-in-delay">
      <div class="discribe">
        <div>한줄설명</div>
        <div>:ssafit은 어쩌구저쩌구 길게 설명</div>
        <button class="my-btn">운동하러 가기</button>
      </div>
    </div>

  </div>
</template>

<script setup>
import VideoList from "@/components/video/VideoList.vue";
import VideoView from "./VideoView.vue";
</script>

<style scoped>
  .con {
    display: flex;
  }
  .con .con-child {
    flex: 1;
  }
  img {
    width: 55vw;
    height: 92vh;
    object-fit: cover;
    opacity: 0.9;
  }
  .con-child-content {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: flex-start;
  }
  .discribe {
    padding-left: 40px;
  }
  .my-btn {
    border: 0px;
    border-radius: 4px;
    background-color: #FFD717;
    color: #27374D;
    padding: 5px 10px;
    transition: background-color 0.3s, color 0.3s, transform 0.3s;
  }
  .my-btn:hover {
    transition: background-color 0.3s, color 0.3s;
    transform: scale(1.1);
    animation: pulse 1.2s infinite;
  }
  .fade-in {
    opacity: 0;
    animation: fadeIn 2s ease-in-out forwards;
  }
  .fade-in-delay {
    opacity: 0;
    animation: fadeIn 2s ease-in-out forwards;
    animation-delay: 1.5s;
  }
  @keyframes fadeIn {
    from {
      opacity: 0;
    }
    to {
      opacity: 1;
    }
  }
  @keyframes pulse {
    0% {
      transform: scale(1);
    }
    50% {
      transform: scale(1.06);
    }
    100% {
      transform: scale(1);
    }
  }
</style>
