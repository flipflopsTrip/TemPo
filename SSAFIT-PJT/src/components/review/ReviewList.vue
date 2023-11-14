<template>
  <div>
    <h3>리뷰 목록</h3>
    <hr />
    <table>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
      <tr v-for="review in store.reviewList" :key="review.reviewId">
        <td>{{ review.reviewId }}</td>
        <td>
          <RouterLink :to="`/review/${review.reviewId}`">{{
            review.title
          }}</RouterLink>
        </td>
        <td>{{ review.userId }}</td>
        <td>{{ review.regDate }}</td>
        <td>{{ review.viewCnt }}</td>
      </tr>
    </table>
  </div>
</template>

<script setup>
import { useReviewStore } from "../../stores/review";
import { onMounted } from "vue";
const store = useReviewStore();
onMounted(() => {
  store.getReviewList();
});
</script>
<!--store.vide-->
<style scoped></style>
