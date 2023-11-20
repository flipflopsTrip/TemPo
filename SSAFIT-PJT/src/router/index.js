
import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";

import VideoView from "@/views/VideoView.vue";
import VideoList from "@/components/video/VideoList.vue";
import VideoDetail from "@/components/video/VideoDetail.vue";

import ReviewView from "@/views/ReviewView.vue";
import ReviewList from "@/components/review/ReviewList.vue";
import ReviewCreate from "@/components/review/ReviewCreate.vue";
import ReviewDetail from "@/components/review/ReviewDetail.vue";
import ReviewUpdate from "@/components/review/ReviewUpdate.vue";

import UserRegist from "@/components/user/UserRegist.vue";
import UserLogin from "@/components/user/UserLogin.vue";

import ShoppingView from "@/views/ShoppingView.vue";

import CommunityView from "@/views/CommunityView.vue";
import CommunityList from "@/components/community/CommunityList.vue";
import CommunityCreate from "@/components/community/CommunityCreate.vue";
import CommunityDetail from "@/components/community/CommunityDetail.vue";
import CommunityUpdate from "@/components/community/CommunityUpdate.vue";


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    //home
    {
      path: "/",
      name: "home",
      component: HomeView,
    },

    //video
    {
      path: "/video",
      name: "video",
      component: VideoView,
      children: [
        {
          path: ":videoId",
          name: "videoDetail",
          component: VideoDetail,
        },
        {
          path: "",
          name: "videoList",
          component: VideoList,
        },
      ],
    },

    //review
    {
      path: "/review",
      // name: "Review",
      component: ReviewView,
      children: [
        {
          path: ":reviewId",
          // name: "ReviewDetail",
          component: ReviewDetail,
        },
        {
          path: ":videoId",
          name: "ReviewCreate",
          component: ReviewCreate,
        },
        {
          path: "update",
          name: "ReviewUpdate",
          component: ReviewUpdate,
        },
      ],
    },

    //user
    {
      path: "/regist",
      name: "UserRegist",
      component: UserRegist,
    },
    {
      path: "/login",
      name: "UserLogin",
      component: UserLogin,
    },
        //shopping
    {
      path: "/shopping",
      // name: "Shopping",
      component: ShoppingView,
    },
    //board
    {
      path: "/community",
      name: "community",
      component: CommunityView,
      children: [
        {
          path: "",
          name: "communityList",
          component: CommunityList,
        },
        {
          path: "create",
          name: "communityCreate",
          component: CommunityCreate,
        },
        {
          path: ":id",
          name: "communityDetail",
          component: CommunityDetail,
        },
        {
          path: "update",
          name: "communityUpdate",
          component: CommunityUpdate,
        },
      ],
    },
  ],
});

export default router;
