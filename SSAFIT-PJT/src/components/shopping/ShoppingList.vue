<template>
  <div class="container my-con">
    <h3>ShoppingList</h3>
    <ShoppingListItem
      v-for="product in store.products"
      :key="product.productId"
      :product="product"
    />
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
</style>
