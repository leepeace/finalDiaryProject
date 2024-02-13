<template>
  <div>
    <div style="display: flex; justify-content: space-between; align-items: center; gap:30px; margin-top: 40px;">
      <button
        class="btn-main entry-submit-btn"
        style="margin-left: auto;"
        @click.prevent="goToChatGPT()"
      >
        주제 추천받기
      </button>
      <button
        class="btn-main entry-submit-btn"
        @click="goToDiaryCreate()"
        style="margin-right:200px;"
      >
        일기 쓰기
      </button>
    </div>

    <div v-if="diaryList && diaryList.length > 0" class="diary-grid">
      <b-card
        v-for="(diary, index) in diaryList"
        :key="index"
        :title="diary.title"
        header-tag="header"
        footer-tag="footer"
        style="max-width: 20rem; margin: 20px"
      >
        <template #header>
          <h6 class="mb-0">우리의 일기장</h6>
        </template>
        <b-card-text>
          작성일: {{ formatDate(diary.regDate) }}<br />
          작성자: {{ diary.id }}
        </b-card-text>
        <!-- 상세 보기 버튼 -->
        <button class="btn-main entry-submit-btn" @click="goToDiaryDetail(diary.diaryId)">
          상세보기
        </button>
        <template #footer>
          <!-- 푸터 슬롯 -->
          <em>Footer Slot</em>
        </template>
      </b-card>
    </div>
    <div v-else>
      <!-- 일기 정보가 없을 때 출력할 메시지 -->
      <div>
        <b-card
          title="우리의 일기"
          tag="article"
          img-src="https://placekitten.com/480/210"
          img-alt="Image"
          style="max-width: 20rem; margin: 50px"
          class="mb-2"
        >
          <b-card-text> 아직 우리 학급의 일기장이 없어요! </b-card-text>
        </b-card>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import router from "@/router";
const diaryStore = "diaryStore";

export default {
  name: "DiaryListView",

  data() {
    return {
      classId: Number,
    };
  },
  mounted() {
    this.classId = this.$route.params.classId;
    this.getDiaryIdByClassId(this.classId);
  },
  methods: {
    ...mapActions(diaryStore, ["getDiaryIdByClassId"]),
    formatDate(dateTimeString) {
      const date = new Date(dateTimeString);
      const year = date.getFullYear();
      const month = (date.getMonth() + 1).toString().padStart(2, "0");
      const day = date.getDate().toString().padStart(2, "0");
      return `${year}-${month}-${day}`;
    },
    goToDiaryDetail(diaryId) {
      const classId = this.classId;
      router.push({ name: "DiaryDetailView", params: { diaryId, classId } });
    },
    goToDiaryCreate() {
      const classId = this.classId;
      router.push({ name: "DiaryCreateView", params: { classId } });
    },
    goToChatGPT() {
      router.push({name: "DiaryChatGPTView"})
    }
  },
  computed: {
    ...mapState(diaryStore, ["diaryList"]),
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

.diary-grid {
  display: grid;
  grid-template-columns: repeat(5, 1fr); /* 가로 5열 */
  gap: 10px; /* 요소 사이의 간격 */
}
b-card {
  max-width: calc(20% - 10px); /* 20%로 설정하여 가로 5열로 나눈 후 간격을 빼줍니다. */
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
