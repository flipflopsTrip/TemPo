<template>
  <div>
    <h3>카테고리 및 상세 검색</h3>
    <div>
      <fieldset style="background-color: bisque">
        <legend>제품 카테고리</legend>
        <div
          v-for="c in ctgy"
          :key="c.id"
          style="display: flex; justify-content: center"
        >
          <input
            type="checkbox"
            id="ctgy"
            name="ctgy"
            @click="plusKeyword(c.product)"
          />
          <label for="c.id">{{ c.product }}</label>
        </div>
      </fieldset>
      <input type="text" v-model="keywordTyping" @keyup.enter="search" />
      <br />
      <br />
      <button @click="search">검색</button
      ><!--체크박스 해도 검색 버튼 눌러야함-->
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useShoppingStore } from "@/stores/shopping";
const store = useShoppingStore();

const keywordTyping = ref("");
const keyword = ref([]);

const ctgy = [
  {
    id: 1,
    product: "운동복",
  },
  {
    id: 2,
    product: "운동화",
  },
  {
    id: 3,
    product: "운동기구",
  },
  {
    id: 4,
    product: "닭가슴살",
  },
  {
    id: 5,
    product: "단백질쉐이크",
  },
];

const plusKeyword = function (key) {
  keyword.value.push(key);
};

const search = function () {
  let finalKeyword = "";
  //(1) 체크박스에 아무것도 없고, 키워드에 아무것도 입력하지 않았다면 반환 결과 없음
  //(2) 체크박스만 했다면, 그 키워드가 keyword에 합쳐진다
  if (keyword != "" && keywordTyping === "") {
    for (i in keyword) {
      finalKeyword += i + " ";
    }
  }
  //(3) 검색만 한다면, 그 키워드가 keyword에 합쳐진다
  if (keyword == [] && keywordTyping != "") {
    finalKeyword = keywordTyping;
  }
  //(4) 체크박스와 검색 모두 했다면, 체크박스 된 키워드와 검색된 키워드를 합쳐서 검색
  if (keyword != "" && keywordTyping != "") {
    // finalKeyword = keyword.value.join(" ");
    for (const i of keyword.value) {
      finalKeyword += i + " ";
    }
    finalKeyword += keywordTyping;
  }
  console.log(finalKeyword);
  return store.shoppingSearch(finalKeyword);
};
</script>

<style scoped></style>
