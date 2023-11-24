<template>
  <tbody>
    <tr class="text-center my-hover">
      <td>
        <a :href="product.link" target="_blank">
          <img :src="product.image" alt="Product Image" />
        </a>
      </td>
      <td class="all-links align-middle">
        <a :href="product.link" target="_blank">
          <div v-html="product.title" class="strong"></div>
        </a>
      </td>
      <td class="align-middle">{{ product.lprice }}원</td>
    </tr>
  </tbody>
</template>

<script setup>
import { useShoppingStore } from "@/stores/shopping";
const store = useShoppingStore();

defineProps(["product"]);
</script>

<style scoped>
img {
  height: 180px; 
  width: 180px;
  object-fit: contain;
}
tr.my-hover:hover td {
	background-color: #9db2bf16;
}
.all-links > a {
	color: black;
	text-decoration: none;
}
.all-links > a:hover {
	text-decoration: underline;
}
.all-links > span:nth-child(1) {
	font-weight: 400;
}
tbody > tr:last-child {
  border-bottom: 2px solid #9DB2BF;
}
</style>
