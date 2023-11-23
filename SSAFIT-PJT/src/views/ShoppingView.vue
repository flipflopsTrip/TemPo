<template>
  <div class="container my-con">
    <h2>ShoppingView</h2>
    <ShoppingSearch />
    <ShoppingList />
  </div>
</template>

<script setup>
import ShoppingSearch from "@/components/shopping/ShoppingSearch.vue";
import ShoppingList from "@/components/shopping/ShoppingList.vue";
</script>

<style scoped>
.my-con {
	margin-bottom: 100px;
}
</style>

