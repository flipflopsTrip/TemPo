<template>
  <div>
    <li>
      <!-- <img :src="product.rss.channel.item.image" /> -->
      <br />
      <h4>{{ product.rss.channel.title }}</h4>
    </li>
  </div>
</template>

<script setup>
import { useShoppingStore } from "@/stores/shopping";
const store = useShoppingStore();

defineProps(["product"]);
</script>

<style scoped></style>
