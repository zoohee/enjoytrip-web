<template>
    <div class="container px-4 px-lg-5" id="reviewDiv">
  <div id="reviewBar" class="flex-container">
        <ReviewSortMenuItem></ReviewSortMenuItem>
          <v-btn color="primary" @click="moveWrite">글쓰기&nbsp; <v-icon icon="fa:fas fa-edit"></v-icon></v-btn>
    </div>
    <div class="row gx-4 gx-lg-5">
      <ReviewCardItem v-for="review in reviews" :key="review.review_no" :r="review" />
    </div>
</div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import ReviewCardItem from "./item/ReviewCardItem.vue";
import ReviewSortMenuItem from "./item/ReviewSortMenuItem.vue";

const router = useRouter();

// axios로 서버 요청 구현 예정
// 사진은 firebase storage   
const reviews = ref([
    {review_no : 1, title:'주말에 다녀온 강릉', img:'/src/assets/img/ocean.png', content: '은은한 커피향이 남다른 강원도 강릉시. 그중에도 카페거리로 유명한 안목해변은 발이 닿는 어디든 향긋한 커피 한 잔에 지평선 끝까지 펼쳐지는 바다 풍경은 덤으로 얻을 수 있다. 일출 명소로 유명한 정동진과 야경이 아름다운 경포대는 대표 여행 코스! 구름도 머물다 간다는 해발 1,100m에 위치한 강릉 안반데기 마을은 전망대에 올라 드넓게 펼쳐진 배추밭이 붉게 물드는 일출 전경이 일품이다.'},
    {review_no : 2, title:'쇠소깍 카누', img:'/src/assets/img/lake.jpg', content: '2011년 6월 30일 문화재청이 외돌개, 산방산과 함께 국가지정문화재 명승으로 지정했다. 서귀포시 하효동과 남원읍 하례리 사이를 흐르는 효돈천(孝敦川) 하구를 가리키며, 이곳은 제주 현무암 지하를 흐르는 물이 분출하여 바닷물과 만나 깊은 웅덩이를 형성한 곳이다. 쇠소깍이라는 이름은 제주도 방언이다. 쇠는 효돈마을을 뜻하며, 소는 연못, 각은 접미사로서 끝을 의미한다. 계곡의 풍경이 아름다운 곳으로 뛰어난 비경을 가진곳으로 알려져 있다.'},
    {review_no : 3, title:'해안도로 드라이브', img:'/src/assets/img/drive.jpg', content: '해안도로 여행은 자연의 아름다움과 모험을 동시에 즐길 수 있는 특별한 경험이다. 휴양지에서 시작해 작은 언덕을 넘고, 푸른 바다를 따라 달리며 끝없이 펼쳐진 해안 풍경이 눈에 펼쳐진다. 차와 함께하는 여행은 도시의 소란에서 벗어나 신선한 공기를 마시며 힐링할 수 있는 기회를 제공한다. 사진을 찍을 때마다 느껴지는 자유로움과 해안선을 따라 펼쳐진 풍경은 마치 삶의 작은 여정을 닮아있다. 해안도로 여행은 자연 속에서의 소중한 순간을 만들어주는 특별한 여행이다.'},
    {review_no : 4, title:'설악산 등반', img:'/src/assets/img/mountain.jpg', content: '설악산은 대한민국의 가장 높은 산으로, 동해안에 위치하고 있습니다. 설악산 등반은 산악인들과 여행객들 사이에서 인기가 높으며, 다양한 코스가 마련되어 있습니다. 난이도에 따라 다양한 산행 코스를 선택할 수 있으며, 정상에서는 아름다운 자연경관을 감상할 수 있습니다. 등반 전에는 안전을 위해 충분한 준비가 필요하며, 가이드나 안전장비를 활용하는 것이 좋습니다.'},
    {review_no : 5, title:'일요일 아침은 등산!', img:'/src/assets/img/mountain-top.jpg', content: '주말 등산은 일상의 스트레스를 풀고 몸과 마음을 활기차게 만들어주는데, 산악지형의 다양한 코스를 통해 다양한 난이도의 산행을 즐길 수 있습니다. 일요일 아침의 신선한 공기와 자연 속에서의 활동은 주말을 활기차게 시작하는 좋은 방법이며, 가족이나 친구들과 함께하는 등산은 소통과 연결을 강화시키는 기회가 됩니다. 하루의 시작을 건강한 활동으로 마무리하며 자연과 소통하는 즐거움을 느낄 수 있습니다.'},
    {review_no : 6, title:'일출보러 동해가요', img:'/src/assets/img/ocean.png', content: '동해안은 그 독특한 지형과 바다의 풍경으로 유명하며, 특히 일출은 그 중에서도 아름다운 순간으로 알려져 있습니다. 이 여행은 일출의 아름다움을 눈으로 직접 확인하며 자연 속에서의 평온한 순간을 경험할 수 있는 특별한 기회를 제공합니다. 동해안의 해안도로를 따라 여행하면서 일출 전후로 펼쳐지는 풍경은 많은 이들에게 감동과 여운을 안겨줍니다. 이로운 추억을 만들기 위해 카메라를 가져가며 함께하는 이들과 함께하는 것이 좋습니다.'},
    {review_no : 7, title:'주말에 다녀온 강릉', img:'/src/assets/img/ocean.png', content: '은은한 커피향이 남다른 강원도 강릉시. 그중에도 카페거리로 유명한 안목해변은 발이 닿는 어디든 향긋한 커피 한 잔에 지평선 끝까지 펼쳐지는 바다 풍경은 덤으로 얻을 수 있다. 일출 명소로 유명한 정동진과 야경이 아름다운 경포대는 대표 여행 코스! 구름도 머물다 간다는 해발 1,100m에 위치한 강릉 안반데기 마을은 전망대에 올라 드넓게 펼쳐진 배추밭이 붉게 물드는 일출 전경이 일품이다.'},
    {review_no : 8, title:'쇠소깍 카누', img:'/src/assets/img/lake.jpg', content: '2011년 6월 30일 문화재청이 외돌개, 산방산과 함께 국가지정문화재 명승으로 지정했다. 서귀포시 하효동과 남원읍 하례리 사이를 흐르는 효돈천(孝敦川) 하구를 가리키며, 이곳은 제주 현무암 지하를 흐르는 물이 분출하여 바닷물과 만나 깊은 웅덩이를 형성한 곳이다. 쇠소깍이라는 이름은 제주도 방언이다. 쇠는 효돈마을을 뜻하며, 소는 연못, 각은 접미사로서 끝을 의미한다. 계곡의 풍경이 아름다운 곳으로 뛰어난 비경을 가진곳으로 알려져 있다.'},
    {review_no : 9, title:'해안도로 드라이브', img:'/src/assets/img/drive.jpg', content: '해안도로 여행은 자연의 아름다움과 모험을 동시에 즐길 수 있는 특별한 경험이다. 휴양지에서 시작해 작은 언덕을 넘고, 푸른 바다를 따라 달리며 끝없이 펼쳐진 해안 풍경이 눈에 펼쳐진다. 차와 함께하는 여행은 도시의 소란에서 벗어나 신선한 공기를 마시며 힐링할 수 있는 기회를 제공한다. 사진을 찍을 때마다 느껴지는 자유로움과 해안선을 따라 펼쳐진 풍경은 마치 삶의 작은 여정을 닮아있다. 해안도로 여행은 자연 속에서의 소중한 순간을 만들어주는 특별한 여행이다.'},
    {review_no : 10, title:'설악산 등반', img:'/src/assets/img/mountain.jpg', content: '설악산은 대한민국의 가장 높은 산으로, 동해안에 위치하고 있습니다. 설악산 등반은 산악인들과 여행객들 사이에서 인기가 높으며, 다양한 코스가 마련되어 있습니다. 난이도에 따라 다양한 산행 코스를 선택할 수 있으며, 정상에서는 아름다운 자연경관을 감상할 수 있습니다. 등반 전에는 안전을 위해 충분한 준비가 필요하며, 가이드나 안전장비를 활용하는 것이 좋습니다.'},
    {review_no : 11, title:'일요일 아침은 등산!', img:'/src/assets/img/mountain-top.jpg', content: '주말 등산은 일상의 스트레스를 풀고 몸과 마음을 활기차게 만들어주는데, 산악지형의 다양한 코스를 통해 다양한 난이도의 산행을 즐길 수 있습니다. 일요일 아침의 신선한 공기와 자연 속에서의 활동은 주말을 활기차게 시작하는 좋은 방법이며, 가족이나 친구들과 함께하는 등산은 소통과 연결을 강화시키는 기회가 됩니다. 하루의 시작을 건강한 활동으로 마무리하며 자연과 소통하는 즐거움을 느낄 수 있습니다.'},
    {review_no : 12, title:'일출보러 동해가요', img:'/src/assets/img/ocean.png', content: '동해안은 그 독특한 지형과 바다의 풍경으로 유명하며, 특히 일출은 그 중에서도 아름다운 순간으로 알려져 있습니다. 이 여행은 일출의 아름다움을 눈으로 직접 확인하며 자연 속에서의 평온한 순간을 경험할 수 있는 특별한 기회를 제공합니다. 동해안의 해안도로를 따라 여행하면서 일출 전후로 펼쳐지는 풍경은 많은 이들에게 감동과 여운을 안겨줍니다. 이로운 추억을 만들기 위해 카메라를 가져가며 함께하는 이들과 함께하는 것이 좋습니다.'},
    
])

const moveWrite = () => {
  router.push({ name: "review-write" });
};

</script>

<style>
#reviewDiv {
    margin-top: 50px;
}

  .flex-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;
  }
</style>