<template>
  <div style="margin: 100px 100px">
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
          <h6 class="mb-0">우리의 학급</h6>
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
          @click.stop="showModal(school.classId)"
        >
          참여하기
        </button>
        <template #footer>
          <!-- 푸터 슬롯 -->
          <em>Footer Slot</em>
        </template>
      </b-card>
    </div>
    <div v-else>
      <!-- 학교 정보가 없을 때 출력할 메시지 -->
      <p class="journal-label">검색한 학급이 없어요</p>
    </div>

    <!-- 모달 -->
    <b-modal
      ref="my-modal"
      hide-footer
      title="참여할 학급의 비밀번호를 입력하세요."
    >
      <div class="d-block text-center">
        <b-form-input type="password" v-model="pwd"></b-form-input>
      </div>
      <div style="display: flex; align-items: center; gap: 10px">
        <b-button class="mt-3" variant="outline-danger" block @click="hideModal"
          >닫기</b-button
        >
        <b-button
          class="mt-3"
          variant="outline-warning"
          block
          @click="toggleModal"
          >참여하기</b-button
        >
      </div>
    </b-modal>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
const schoolStore = "schoolStore";

export default {
  name: "SchoolSearchView",
  data() {
    return {
      keyword: null, //검색 키워드
      pwd: null, //학급 비밀번호
      loginId: null, //로그인 아이디
      classId: Number,
    };
  },
  mounted() {
    this.keyword = this.$route.query.searchQuery;
    this.loginId = JSON.parse(sessionStorage.getItem("userInfo"));
    this.searchSchool(this.keyword);
    if (this.loginId) {
      this.getSchool(this.login)
    }
  },
  methods: {
    ...mapActions(schoolStore, ["searchSchool"]),
    ...mapActions(schoolStore, ["joinSchool"]),
    showModal(classId) {
      this.$refs["my-modal"].show();
      this.classId = classId;
    },
    hideModal() {
      this.$refs["my-modal"].hide();
    },
    toggleModal() {
      this.joinSchool({
        id: this.loginId.id,
        classId: this.classId,
        schoolPwd: this.pwd,
      });
      this.$refs["my-modal"].toggle("#toggle-btn");
    },
  },
  computed: {
    ...mapState(schoolStore, ["schoolInfo"]),
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
