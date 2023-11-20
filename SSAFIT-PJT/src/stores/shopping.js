//import.meta.env.VITE_SHOPPING_CLIENT_ID
//import.meta.env.VITE_SHOPPING_CLIENT_SECRET

import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

export const useShoppingStore = defineStore("shopping", () => {
  const products = ref([]);
  const selectedProduct = ref(null);

  const shoppingSearch = function (keyword) {
    const URL = "/api/v1/search/shop.json"; //+encodeURI(keyword.query)
    const CLIENT_ID = "1Y7M3eCv5_VTxgNp1Ejq";
    const CLIENT_SECRET = "4Jnzvqh3fX";
    axios
      .get(URL, {
        params: {
          query: keyword,
          display: 10,
          start: 1,
          sort: "sim",
        },
        headers: {
          "X-Naver-Client-Id": CLIENT_ID,
          "X-Naver-Client-Secret": CLIENT_SECRET,
        },
      })
      .then((response) => {
        console.log(response.data.items + "잘 넘겼다");
        products.value = response.data.items;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const clickProduct = function (product) {
    selectedProduct.value = product;
  };
  return { products, selectedProduct, shoppingSearch, clickProduct };
});
//CORS 해결
//https://msyu1207.tistory.com/entry/React%EB%A1%9C-%EC%98%81%ED%99%94-%EC%A0%95%EB%B3%B4%EB%A5%BC-%EA%B2%80%EC%83%89%ED%95%B4%EB%B3%B4%EC%9E%90-%EB%91%90%EB%B2%88%EC%A7%B8-%EB%84%A4%EC%9D%B4%EB%B2%84-API-%EC%82%AC%EC%9A%A9-CORS-%EC%84%A4%EC%A0%95-%ED%95%98%EA%B8%B0
