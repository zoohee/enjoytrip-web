<template>
  <!-- Page Content-->
  <div class="container px-4 px-lg-5">
    <!-- Heading Row-->
    <div class="row gx-4 gx-lg-5 align-items-center my-5">
      <div class="col-lg-7">
        <img
          class="img-fluid rounded mb-4 mb-lg-0"
          src="@/assets/thumbnail.png"
          alt="..."
        />
      </div>
      <div class="col-lg-5">
        <h1 class="font-weight-regular">여행은 항상 Enjoy하게✨</h1>
        <p>
          <br />여행지 정보부터 실시간 지도 서비스, 그리고 여행 친구를 찾을 수
          있는 게시판까지, 저희 EnjoyTrip은 여행을 더욱 특별하게 만들어주는
          다양한 기능을 제공합니다. <br />
          자세한 관광지 정보와 놀라운 사진들을 탐험하며, 지도 서비스를 활용하여
          목적지를 손쉽게 찾아가세요. 게시판을 통해 여행 친구를 만나고 새로운
          경험을 나누며 여행을 더욱 풍부하게 즐길 수 있는 특별한 여행
          커뮤니티입니다. <br />여행의 즐거움을 함께 나누고 싶다면 지금 바로
          가입하세요!
          <br />
        </p>
        <a class="btn btn-primary"
          ><router-link class="nav-link" :to="{ name: 'kakaoMap' }"
            >관광지를 둘러 보세요!</router-link
          ></a
        >
      </div>
    </div>
    <!-- Call to Action-->
    <div class="card bg-dark my-5 text-left">
      <div class="card-body row">
        <h3 class="text-white m-0 po-5 col-md-3 mx-1 my-1 py-5">
          엔조이트립과 함께<br />여행을<br />더 즐겁게!
        </h3>
        <div class="card-body rounded col-md-2 mx-1 my-1" style="display: flex; flex-direction: column; justify-content: flex-start;">
			<p style="font-weight: 600;">이번주 여행지 1 전주</p>
			<img src="@/assets/img/jeonju.png" alt="Image" style="width: 100%; height: 70%;">
		</div>
        <div class="card-body rounded col-md-2 mx-1 my-1" style="display: flex; flex-direction: column;justify-content: flex-start;">
			<p style="font-weight: 600;">이번주 여행지 2 애월</p>
			<img src="@/assets/img/aewol.jpg" alt="Image" style="width: 100%; height: 70%;">
		</div>
        <div class="card-body rounded col-md-2 mx-1 my-1" style="display: flex; flex-direction: column; justify-content: flex-start;">
			<p style="font-weight: 600;">이번주 여행지 3 광안리</p>
			<img src="@/assets/img/busan.png" alt="Image" style="width: 100%; height: 70%;">
		</div>
      </div>
    </div>

    <div class="row gx-4 gx-lg-5">
      <ReviewCardItem
        v-for="review in reviews"
        :key="review.review_no"
        :r="review"
      />
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import ReviewCardItem from "@/components/review/item/ReviewCardItem.vue";

const reviews = ref([
    {review_no : 1, title:'주말에 다녀온 강릉', img:'/src/assets/img/ocean.png', content: '은은한 커피향이 남다른 강원도 강릉시. 그중에도 카페거리로 유명한 안목해변은 발이 닿는 어디든 향긋한 커피 한 잔에 지평선 끝까지 펼쳐지는 바다 풍경은 덤으로 얻을 수 있다. 일출 명소로 유명한 정동진과 야경이 아름다운 경포대는 대표 여행 코스! 구름도 머물다 간다는 해발 1,100m에 위치한 강릉 안반데기 마을은 전망대에 올라 드넓게 펼쳐진 배추밭이 붉게 물드는 일출 전경이 일품이다.'},
    {review_no : 2, title:'쇠소깍 카누', img:'/src/assets/img/lake.jpg', content: '2011년 6월 30일 문화재청이 외돌개, 산방산과 함께 국가지정문화재 명승으로 지정했다. 서귀포시 하효동과 남원읍 하례리 사이를 흐르는 효돈천(孝敦川) 하구를 가리키며, 이곳은 제주 현무암 지하를 흐르는 물이 분출하여 바닷물과 만나 깊은 웅덩이를 형성한 곳이다. 쇠소깍이라는 이름은 제주도 방언이다. 쇠는 효돈마을을 뜻하며, 소는 연못, 각은 접미사로서 끝을 의미한다. 계곡의 풍경이 아름다운 곳으로 뛰어난 비경을 가진곳으로 알려져 있다.'},
    {review_no : 3, title:'해안도로 드라이브', img:'/src/assets/img/drive.jpg', content: '해안도로 여행은 자연의 아름다움과 모험을 동시에 즐길 수 있는 특별한 경험이다. 휴양지에서 시작해 작은 언덕을 넘고, 푸른 바다를 따라 달리며 끝없이 펼쳐진 해안 풍경이 눈에 펼쳐진다. 차와 함께하는 여행은 도시의 소란에서 벗어나 신선한 공기를 마시며 힐링할 수 있는 기회를 제공한다. 사진을 찍을 때마다 느껴지는 자유로움과 해안선을 따라 펼쳐진 풍경은 마치 삶의 작은 여정을 닮아있다. 해안도로 여행은 자연 속에서의 소중한 순간을 만들어주는 특별한 여행이다.'},
])
</script>

<style>
.card-body .rounded {
  background-color: #bfd4f5;
}
</style>
