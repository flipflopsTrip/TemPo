<template>
	<div class="container px-5 mb-5">
		<div class="title-con">
			<div class="title">칼로리 계산기 <i class="bi bi-calculator"></i></div>
		</div>

		<!-- 음식 검색 -->
		<div class="d-flex align-items-center search-con">
			<div class="input-group">
				<span>음식찾기</span>
				<input type="text" class="form-control custom-input" placeholder="음식 이름을 검색하세요" v-model="foodName" @keyup.enter="searchFood">
				<div class="input-group-append">
					<button class="btn btn-secondary" @click="searchFood">
						<i class="bi bi-search"></i>
					</button>
				</div>
			</div>
			<div class="search-con-item">*제공: 식품의약품안전처</div>
		</div>
		
		<!-- 결과창 + 계산기 -->
		<div class="item-con d-flex">
			<div class="item-con-result">
				<div class="totalcnt">총 <span>{{ totalCnt }}</span>건</div>

				<div v-for="(food, index) in foodList" 
					:key="index" 
					class="result-con d-flex align-items-center justify-content-between">
					<div class="result-con-item">
						<div class="result-data">{{ food.DESC_KOR }} (1회 제공량,{{ food.SERVING_WT }}g)</div>
						<div class="result-data">
							<div>칼로리 : {{ food.NUTR_CONT1}}kcal</div><span>|</span>
							<div>탄수화물 : {{ food.NUTR_CONT2 }}g</div><span>|</span>
							<div>단백질 : {{ food.NUTR_CONT3 }}g</div><span>|</span>
							<div>지방 : {{ food.NUTR_CONT4 }}g</div>
						</div>
						<div class="result-data">
							<div>나트륨 : {{ food.CONT6 == null ? '0mg' : food.CONT6 + 'mg'}}</div><span>|</span>
							<div>콜레스테롤 : {{ food.CONT7 == null ? '0mg' : food.CONT7 + 'mg'}}</div>
						</div>
					</div>
					<div class="result-con-item">
						<button class="result-add-btn" @click="addFood(food)"><i class="bi bi-plus-lg"></i></button>
					</div>
				</div>
				<div v-if="foodList.length == 0" class="result-con result-con-none">검색 결과가 없습니다. 음식을 검색해보세요.</div>

			</div>
			<div class="item-con-cal">
				<div class="calculator-con">
					<div class="cal-sum text-center"><span>{{ sumKcal }} Kcal</span></div>
					<div class="cal-food d-flex align-items-center justify-content-evenly text-center my-3"
					v-for="(food, index) in sumFoodList" :key="index">
						<div><button @click="removeFood(index)"><i class="bi bi-x-lg"></i></button></div>
						<div>{{ food.DESC_KOR }}</div>
						<div>{{ food.NUTR_CONT1 }} Kcal</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import axios from "axios";

const API_URL = `http://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1`;

const foodName = ref('');
const foodList = ref([]);
const totalCnt = ref(0);

const searchFood = function() {
	axios.get(API_URL, {
		params: {
			ServiceKey: import.meta.env.VITE_KCAL_API_KEY,
			desc_kor: foodName.value, //식품 이름
			// pageNo: 5, //페이지 번호
			// numOfRows: 5, //한 페이지 결과 수
			type: "json",
		},
	})
	.then((res)=>{
		// console.log(res.data)
		foodList.value = res.data.body.items;
		totalCnt.value = res.data.body.totalCount;
	})
	.catch((err)=>{console.log(err)})
};

const sumKcal = ref(0);
const sumFoodList = ref([]);

const addFood = function(food) {
	sumKcal.value += parseFloat(food.NUTR_CONT1); //칼로리 더하기
	sumKcal.value = parseFloat(sumKcal.value.toFixed(2));
	sumFoodList.value = [...sumFoodList.value, food]; //배열에 food 객체 추가
};

const removeFood = function(index) {
	const removedFood = sumFoodList.value[index];

  sumKcal.value -= parseFloat(removedFood.NUTR_CONT1);
  sumKcal.value = parseFloat(sumKcal.value.toFixed(2));

	sumFoodList.value = sumFoodList.value.filter((_, i) => i !== index);
}

</script>

<style scoped>
.title-con .title {
	display: inline-block;
	font-size: 1.8rem;
	font-weight: 500;
	margin: 30px 0px 40px;
	/* background: linear-gradient(to top, #ffdc30df 15%, transparent 15%); */
}
.search-con {
	padding: 15px 30px;
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
.item-con-result {
	flex-basis: 65%;
	min-height: 200px;
}
.item-con-cal {
	flex-basis: 35%;
	padding-left: 50px;
}
.totalcnt {
	border-bottom: 1px solid #ccc;
	border-top: 2px solid #9DB2BF;
	background-color: #e5ecf2;
	padding: 2px 10px;
}
.totalcnt > span {
	font-size: 1.1rem;
	font-weight: 500;
}
.result-con {
	border-bottom: 1px solid #9DB2BF;
}
.result-con-none {
	background-color: white;
}
.result-data > div {
	display: inline-block;
	font-size: 0.95rem;
}
.result-data > span {
	margin: 0px 10px;
	color: #ccc;
}
.result-data:nth-child(1) {
	font-size: 1.1rem;
	font-weight: 500;
	margin-bottom: 8px;
}
.result-data:nth-child(2) {
	margin-bottom: 2px;
}
.result-data:nth-child(2) > div:nth-child(1) {
	font-weight: 500;
}
.result-con-item:nth-child(1) {
	padding: 20px 0px 20px 20px;
}
.result-con-item:nth-child(2) {
	padding: 10px 40px 10px 0px;
}
.result-add-btn {
	border: 1px solid #ccc;
	background-color: #ffdc30;
	border-radius: 4px;
}
.calculator-con {
	border: 1px solid #ddd;
	border-radius: 6px;
	min-height: 300px;
	padding: 10px 15px;
}
.calculator-con .cal-sum {
	font-size: 1.6rem;
	font-weight: 600;
	margin: 30px 0px 40px;
}
.calculator-con .cal-food button {
	border: 1px solid #ddd;
	background-color: #f0f0f0;
	border-radius: 4px;
	width: 22px;
	height: 22px;
}
.calculator-con .cal-food button > i{
	position: relative;
	right: 4px;
	bottom: 4px;
}
.cal-food > div:nth-child(1) {
	flex: 20;
}
.cal-food > div:nth-child(2) {
	flex: 40;
}
.cal-food > div:nth-child(3) {
	flex: 40;
}
.calculator-con .cal-sum > span {
	background: linear-gradient(to top, #ffdc30df 15%, transparent 15%);
}
</style>