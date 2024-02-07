<template>
  <div style="margin: 100px">
    <div v-if="schoolInfo.length > 0" class="school-grid">
      <!-- 여러 학교 정보를 동적으로 렌더링하기 위해 v-for 디렉티브 사용 -->
      <b-card
        v-for="(school, index) in schoolInfo"
        :key="index"
        :title="school.schoolName"
        header-tag="header"
        footer-tag="footer"
        style="max-width: 20rem; margin: 20px"
      >
        <template #header>
          <!-- 학교 정보를 표시 -->
          <h6 class="mb-0">학교 정보</h6>
        </template>
        <!-- 학교 정보 텍스트 출력 -->
        <b-card-text>
          학년: {{ school.schoolGrade }}<br />
          반: {{ school.schoolClass }}<br />
          닉네임: {{ school.nickname }}
        </b-card-text>
        <!-- 상세 보기 버튼 -->
        <button class="btn-main entry-submit-btn" type="submit">
          상세 보기
        </button>
        <template #footer>
          <!-- 푸터 슬롯 -->
          <em>Footer Slot</em>
        </template>
      </b-card>
    </div>
    <div v-else>
      <!-- 학교 정보가 없을 때 출력할 메시지 -->
      <p class="journal-label">내가 참여한 학급이 없어요</p>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
const schoolStore = "schoolStore";
const userStore = "userStore";

export default {
  name: "SchoolListView",
  mounted() {
    // sessionStorage에서 사용자 정보 확인
    const userInfo = JSON.parse(sessionStorage.getItem("userInfo"));
    if (userInfo) {
      // 사용자 정보가 있을 때 getSchool 호출
      this.getSchool(userInfo.id);
    }
  },
  methods: {
    ...mapActions(schoolStore, ["getSchool"]),
  },
  computed: {
    ...mapState(schoolStore, ["schoolInfo"]),
    ...mapState(userStore, ["getUser"]),
  },
};
</script>

<style>
.btn-main {
  display: block;
  padding: 0.6rem 2rem;
  margin: 1rem;
  transition: all 0.1s;
  border: none;
  border-radius: 2px;
  cursor: pointer;
  color: lightgoldenrodyellow;
  background-color: lightcoral;
}
.btn-main:hover {
  background-color: lightgoldenrodyellow;
  color: lightcoral;
  font-weight: 700;
  transform: scale(1.08);
}
.entry-submit-btn {
  margin: 0;
}

.school-grid {
  display: grid;
  grid-template-columns: repeat(5, 1fr); /* 가로 5열 */
  gap: 10px; /* 요소 사이의 간격 */
}
b-card {
  max-width: calc(
    20% - 10px
  ); /* 20%로 설정하여 가로 5열로 나눈 후 간격을 빼줍니다. */
}
</style>
