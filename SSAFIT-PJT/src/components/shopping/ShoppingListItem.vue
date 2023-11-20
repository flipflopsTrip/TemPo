<template>
  <div>
    <li>
      <img :src="product.image" style="height: 300px; width: 200px" />
      <br />
      <h4>{{ product.title }}</h4>
      <h5>{{ product.link }}</h5>
    </li>
  </div>
</template>

<script setup>
import { useShoppingStore } from "@/stores/shopping";
const store = useShoppingStore();

defineProps(["product"]);
</script>

<style scoped>
li {
  display: inline-block;
  padding: 20px;
  margin: 20px;
  border: 1px solid rgb(212, 206, 206);
}
</style>
