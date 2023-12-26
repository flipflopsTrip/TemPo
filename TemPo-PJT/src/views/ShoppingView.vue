<template>
  <div class="container px-5 mb-5">
    <div class="title-con">
      <div class="title">Shopping <i class="bi bi-cart4"></i></div>

      <ShoppingSearch />

      <ShoppingList />
    </div>
  </div>
</template>

<script setup>
import ShoppingSearch from "@/components/shopping/ShoppingSearch.vue";
import ShoppingList from "@/components/shopping/ShoppingList.vue";
</script>

<style scoped>
.title-con .title {
	display: inline-block;
	font-size: 1.8rem;
	font-weight: 500;
	margin: 30px 0px 40px;
	/* background: linear-gradient(to top, #ffdc30df 15%, transparent 15%); */
}
.title-con {
  padding: 0px 120px;
}
</style>

