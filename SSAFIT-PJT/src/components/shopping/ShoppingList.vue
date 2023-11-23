<template>
  <div class="container my-con">
    <table class="table">
      <thead class="my-thead">
        <tr class="text-center">
          <th>이미지</th>
          <th>상품명</th>
          <th>가격</th>
        </tr>
      </thead>
      <ShoppingListItem
      v-for="product in store.products"
      :key="product.productId"
      :product="product"
      />
    </table>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useShoppingStore } from "@/stores/shopping";
import ShoppingListItem from "@/components/shopping/ShoppingListItem.vue";
const store = useShoppingStore();
// // const list = store.shoppingSearch("운동복");
// // console.log(store.products);
// onMounted(() => {
//   store.shoppingSearch("운동복");
//   console.log(store.products + "+======");
// });
</script>

<style scoped>
.my-con {
	margin-bottom: 100px;
}
table > thead > tr > th:nth-child(1) {
	width: 10%;
}
table > thead > tr > th:nth-child(3) {
	width: 20%;
}
table > thead > tr > th:nth-child(4) {
	width: 16%;
}
.my-thead {
  border-bottom: 1px solid #ccc;
	border-top: 2px solid #9DB2BF;
	padding: 2px 10px;
}
thead th {
  background-color: #e5ecf2;
}
</style>
