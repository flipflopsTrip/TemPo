<template>
  <div class="row search-con mx-1">
    <div class="col-12">
      <div v-for="item in categories" :key="item.id" class="form-check form-check-inline">
        <input
          class="form-check-input"  
          type="checkbox"
          :id="item.id"
          name="category"
          :value="item.name"
          v-model="selectedCategories"
          @click="check"
        />
        <label :for="item.id" class="form-check-label">{{ item.name }}</label>
      </div>

      <div class="input-group mt-3">
        <span>상세 검색</span>
        <input
          type="text"
          v-model="keywordTyping"
          @keyup.enter="search"
          placeholder="검색어를 입력하세요"
          class="form-control custom-input"
        />
        <div class="input-group-append">
            <button class="btn btn-secondary" @click="search">
              <i class="bi bi-search"></i>
            </button>
          </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useShoppingStore } from "@/stores/shopping";
const store = useShoppingStore();

const keywordTyping = ref(""); //검색 카테고리

const selectedCategories = ref([]); // 선택된 카테고리

const categories = [
  {
    id: 1,
    name: "운동복",
  },
  {
    id: 2,
    name: "운동화",
  },
  {
    id: 3,
    name: "운동기구",
  },
  {
    id: 4,
    name: "닭가슴살",
  },
  {
    id: 5,
    name: "단백질쉐이크",
  },
];

const check = function () {
  console.log(selectedCategories.value);
};

// const search = function () {
//   let finalKeyword = "";
//   //(1) 체크박스에 아무것도 없고, 키워드에 아무것도 입력하지 않았다면 반환 결과 없음
//   //(2) 체크박스만 했다면, 그 키워드가 keyword에 합쳐진다
//   if (selectedCategories != [] && keywordTyping === "") {
//     for (const i in selectedCategories.value) {
//       finalKeyword += i.name + " ";
//     }
//   }
//   //(3) 검색만 한다면, 그 키워드가 keyword에 합쳐진다
//   if (selectedCategories == [] && keywordTyping != "") {
//     finalKeyword = keywordTyping;
//   }
//   //(4) 체크박스와 검색 모두 했다면, 체크박스 된 키워드와 검색된 키워드를 합쳐서 검색
//   if (selectedCategories != [] && keywordTyping != "") {
//     // finalKeyword = keyword.value.join(" ");
//     for (const i of selectedCategories.value) {
//       finalKeyword += i.name + " ";
//     }
//     finalKeyword += keywordTyping;
//   }
//   console.log(finalKeyword);
//   return store.shoppingSearch(finalKeyword);
// };
const search = function () {
  //체크박스에서 선택된 키워드들을 띄어쓰기 두고 합쳐서 저장
  let finalKeyword = selectedCategories.value.join(" ");
  // //만약 검색도 했다면 뒤에 ㄸ
  // if (finalKeyword && keywordTyping.value) {
  //   finalKeyword += " ";
  // }
  finalKeyword += " " + keywordTyping.value; //체크박스 된 키워드와 검색된 키워드를 합쳐서 검색

  console.log(finalKeyword);
  return store.shoppingSearch(finalKeyword);
};
</script>

<style scoped>
.search-con {
	padding: 30px 30px;
	margin-bottom: 50px;
	border: 1px solid #ddd;
	border-radius: 6px;
}
.input-group {
	align-items: center;
}
.input-group > span {
	margin-right: 20px;
}
.custom-input {
	max-width: 300px;
}
.form-control:focus {
  border-color: #ccc;
  box-shadow: none;
}
.search-con-item {
	width: 200px;
}
.input-group-append .btn {
	border-radius: 0px 6px 6px 0px;
}
</style>
