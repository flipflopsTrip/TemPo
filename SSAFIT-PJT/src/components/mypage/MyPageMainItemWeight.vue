<template>
	<div class="item profile">
		<div class="title">몸무게 그래프 <i class="bi bi-bar-chart-line-fill"></i></div>
		<div class="weight-con">
			<div class="d-flex d-flex flex-column justify-content-center align-items-stretch">
				<div v-if="xData == null">몸무게 정보를 입력해주세요</div>
				<Line :data="chartData" :options="chartOptions" />
				<div class="weight-detail d-flex justify-content-center mt-4">
					<button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#writeWeightModal">몸무게 등록</button>
				</div>
			</div>

			<!-- 등록 모달 -->
			<div class="modal fade" id="writeWeightModal" tabindex="-1" 		aria-labelledby="writeWeightLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="writeWeightLabel">몸무게 등록</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						
						<label for="weight" class="form-label">몸무게</label>
						<input class="form-control" type="number" required placeholder="몸무게를 입력하세요(kg)"
						min="0" max="200"
						id="weight"
						v-model="weight">
						<label for="birth" class="col-sm-2 form-label">날짜</label>
						<Datepicker 
							v-model="date" 
							locale="ko"
							weekStart="0"
							auto-apply
							placeholder="YYYY-MM-DD"
							year-first
							:format="format"
						/>

					</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
						<button class="btn btn-primary" @click="writeWeight"
					data-bs-dismiss="modal">등록</button>
					</div>
				</div>
			</div>
		</div>

		</div>
	</div>
</template>

<script setup>
import {ref, computed, watch, onMounted } from 'vue';
import { useUserStore } from '@/stores/user';
import axios from 'axios';
import Datepicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css';
import { Line, Bar } from 'vue-chartjs';
import { Chart as ChartJS, Title, Tooltip, Legend, ArcElement, LineElement, PointElement, CategoryScale, LinearScale } from 'chart.js';
ChartJS.register(Title, Tooltip, Legend, ArcElement, LineElement, PointElement, CategoryScale, LinearScale);


const store = useUserStore();
onMounted(() => {
	store.getUser(store.loginUserId); //store.sessionUser
	getWeight(store.loginUserId);
});

//유저의 몸무게 데이터 가져오기
const xData = ref([]);
const yData = ref([]);
const maxValue = ref(null);
const minValue = ref(null);

const getWeight = function(userId) {
	axios.get(`http://localhost:8080/api-mypage/weight/${userId}`)
	.then((res)=>{
		const xArr = res.data.map(item => item.regDate);
		const yArr = res.data.map(item => item.weight);

		xData.value = xArr;
		yData.value = yArr;

		maxValue.value = Math.round((Math.max(...yArr)+5)/10)*10;
		minValue.value = Math.round((Math.min(...yArr)-5)/10)*10; 
	})
	.catch((err)=>{console.log(err)})
};

const chartData = computed(function () { 
	return {
		labels: xData.value,
		datasets: [
			{
				label: '몸무게(kg)',
				borderWidth: 1,
				tension: 0.5,
				pointRadius: 5,
				borderColor: '#27374D',
				backgroundColor: '#FFD717',
				data: yData.value
			}
		]
	}
});

const chartOptions = computed(() => ({
  responsive: true,
  maintainAspectRatio: true,
  scales: {
    y: {
      min: minValue.value,
      max: maxValue.value,
      ticks: {
        stepSize: 5
      },
    }
  },
}));


//몸무게 입력
const weight = ref('');
const format = (date) => {
	const day = date.getDate().toString().padStart(2, '0');
  const month =(date.getMonth() + 1).toString().padStart(2, '0');
  const year = date.getFullYear();
	date.value  = `${year}-${month}-${day}`;
  return date.value;
}
const date = ref((new Date())); //기본값은 현재 날짜로

const writeWeight = function() {
	const weightData = ref({
		userId: store.loginUserId,
		weight: weight.value,
		regDate: format(date.value),
	})
	axios.post(`http://localhost:8080/api-mypage/weight`, weightData.value)
	.then((res)=>{
		if (res.data == 'success') {
			//성공
			getWeight(store.sessionUser.id);
			weight.value = '';
			date.value = format(new Date());
		} else {
			alert('몸무게 등록에 실패했습니다. 다시 시도하여 주세요.')
		}
	})
	.catch((err)=>{console.log(err)})
};

</script>

<style scoped>
	.container > .item > .title {
		font-size: 1.3rem;
		margin-bottom: 7px;
	}
.weight-con {
	border: 1px solid #9DB2BF;
	border-radius: 8px;
	padding: 20px 15px 35px;
}

</style>