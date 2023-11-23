
import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";

import VideoView from "@/views/VideoView.vue";
import VideoList from "@/components/video/VideoList.vue";
import VideoDetail from "@/components/video/VideoDetail.vue";
import VideoLevelList from "@/components/video/VideoLevelList.vue";

import ReviewView from "@/views/ReviewView.vue";
import ReviewList from "@/components/review/ReviewList.vue";
import ReviewCreate from "@/components/review/ReviewCreate.vue";
import ReviewDetail from "@/components/review/ReviewDetail.vue";
import ReviewUpdate from "@/components/review/ReviewUpdate.vue";

import UserRegist from "@/components/user/UserRegist.vue";
import UserLogin from "@/components/user/UserLogin.vue";
import UserFindId from "@/components/user/UserFindId.vue";
import UserFindPassword from "@/components/user/UserFindPassword.vue";

import ShoppingView from "@/views/ShoppingView.vue";

import CommunityView from "@/views/CommunityView.vue";
import CommunityList from "@/components/community/CommunityList.vue";
import CommunityCreate from "@/components/community/CommunityCreate.vue";
import CommunityDetail from "@/components/community/CommunityDetail.vue";
import CommunityUpdate from "@/components/community/CommunityUpdate.vue";

import wishList from "@/components/wish/wishList.vue";

import MyPageView from "@/views/MyPageView.vue";
import MyPageMain from "@/components/mypage/MyPageMain.vue";
import MyPageBoard from "@/components/mypage/MyPageBoard.vue";
import MyPageReview from "@/components/mypage/MyPageReview.vue";

import MyPageReviewItemReview from "@/components/mypage/MyPageReviewItemReview.vue";
import MyPageReviewItemComment from "@/components/mypage/MyPageReviewItemComment.vue";
import MyPageReviewItemCReview from "@/components/mypage/MyPageReviewItemCReview.vue";

import KcalCalculator from "@/components/kcalCalculator/KcalCalculator.vue";


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    //home
    {
      path: "/",
      name: "home",
      component: HomeView,
    },

    //level
    {
      path: "/videoLevel",
      name: "VideoLevelList",
      component: VideoLevelList,
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
    {
      path: "/findId",
      name: "UserFindId",
      component: UserFindId,
    },
    {
      path: "/findPw",
      name: "UserFindPassword",
      component: UserFindPassword,
    },

    //shopping
    {
      path: "/shopping",
      // name: "Shopping",
      component: ShoppingView,
    },

    //community
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

    //mypage
    {
      path: "/mypage",
      name: "MyPage",
      component: MyPageView,
      children: [
        {
          path: "",
          name: "MyPageMain",
          component: MyPageMain,
        },
        {
          path: "wishList",
          name: "wishList",
          component: wishList,
        },
        {
          path: "myBoard",
          name: "MyPageBoard",
          component: MyPageBoard,
        },
        {
          path: "myReview",
          name: "MyPageReview",
          component: MyPageReview,
          children: [
            {
              path: "myVideoReview",
              name: "MyPageReviewItemReview",
              component: MyPageReviewItemReview,
            },
            {
              path: "myVideoComment",
              name: "MyPageReviewItemComment",
              component: MyPageReviewItemComment,
            },
            {
              path: "myCommunityReview",
              name: "MyPageReviewItemCReview",
              component: MyPageReviewItemCReview,
            },
          ],
        },
      ],
    },

    //kcal Calculator
    {
      path: "/kcalCalculator",
      name: "KcalCalculator",
      component: KcalCalculator,
    },

  ], //close
}); //close

export default router;
