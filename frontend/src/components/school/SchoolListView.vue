<template>
  <div style="margin: 0 100px">
    <section class="section journal-section">
      <div class="container">
        <div class="container-row container-row-journal">
          <div
            class="container-item container-item-journal"
            style="margin-left: auto; margin-right: 0"
          >
            <div
              id="entryForm"
              style="display: flex; align-items: center; gap: 20px"
            >
              <input
                type="text"
                name="entry-title"
                id="entry-title"
                class="entry-text-title"
                placeholder="참여할 학급의 닉네임을 검색하세요"
                v-model="searchQuery"
              />
              <button class="btn-main entry-submit-btn" @click="searchSchool()">
                검색
              </button>
            </div>
          </div>
        </div>
      </div>
    </section>
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
          <h6 class="mb-0">내가 참여한 학급</h6>
        </template>
        <!-- 학교 정보 텍스트 출력 -->
        <b-card-text>
          학년: {{ school.schoolGrade }}<br />
          반: {{ school.schoolClass }}<br />
          학급 닉네임: {{ school.nickname }}
        </b-card-text>
        <!-- 상세 보기 버튼 -->
        <button
          class="btn-main entry-submit-btn"
          @click="goToDiaryList(school.classId)"
        >
          우리 반 가기
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
import router from "@/router";

const schoolStore = "schoolStore";
const userStore = "userStore";

export default {
  name: "SchoolListView",
  data() {
    return {
      searchQuery: "", // 입력된 검색어를 저장할 변수
    };
  },
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
    goToDiaryList(classId) {
      router.push({ name: "DiaryListView", params: { classId } });
    },
    searchSchool() {
      this.$router.push({
        path: "/school/search",
        query: {
          searchQuery: this.searchQuery,
        },
      });
    },
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
/* My Starter Template */

*,
*::before,
*::after {
  box-sizing: border-box;
}

/* Section Container Positions, Spacing, Utilities */

.section {
  padding: 1em 1em;
  width: 100%;
  margin: 1em auto;
}

.container {
  width: 100%;
  margin: 0 auto;
  padding: 1em 1em;
}

.container-row {
  width: 90%;
  margin: 0 auto;
}

/* Button Standard */

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

/* Journal Entry Section */

/* Title */

.entry-text-title {
  width: 20em;
  margin: 1em auto;
  padding: 1em;
  border-radius: 2px;
  border: unset;
  background-color: lightgoldenrodyellow;
}

.entry-text-title:focus {
  outline-color: lightcoral;
  color: lightcoral;
}

.entry-text-title::-ms-value {
  color: lightcoral;
}

/* Text Box */

.container-row-journal {
  display: flex;
  justify-content: center;
}

.entry-submit-btn {
  margin: 0;
}
</style>
