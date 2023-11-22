<template>
  <div class="con">
    <!-- youtube api 용량 이슈로 주석 -->
    <!-- <VideoList /> -->
    <div class="con-child fade-in">
      <img src="@/assets/mainImg.jpg" alt="메인이미지">
    </div>
    <div class="con-child con-child-content fade-in-delay">
      <div class="discribe">
        <div>Tempo는 건강한 라이프스타일을 위한 핵심 정보를 제공합니다. "운동의 템포"에 딱 맞는 정보로 여러분의 건강한 삶을 돕고자 합니다. 템포와 함께, 더 건강하고 활기찬 삶의 시작을 만나보세요!</div>
        <button class="my-btn">운동하러 가기 <i class="bi bi-fire"></i></button>
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
    width: 59%;
    text-align: justify;
  }
  .discribe > div {
    margin-bottom: 10px;
  }
  .my-btn {
    border: 0px;
    border-radius: 4px;
    background-color: #FFD717;
    color: #27374D;
    padding: 5px 10px;
    height: 40px;
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
    animation: fadeIn 1.0s ease-in-out forwards;
    animation-delay: 1.2s;
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
