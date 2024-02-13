<template>
  <div>
    <!-- Entry Section -->
    <section class="section journal-section">
      <div class="container">
        <div class="container-row container-row-journal">
          <div class="container-item container-item-journal">
            <form id="entryForm" @submit.prevent="handleSubmit">
              <!-- 입력 항목 -->
              <label for="schoolName" class="journal-label">학교 이름</label>
              <input
                type="text"
                name="schoolName"
                id="schoolName"
                v-model="formData.schoolName"
                class="entry-text-title"
                placeholder="School Name"
              />
              <label for="schoolGrade" class="journal-label">학년</label>
              <input
                type="text"
                name="schoolGrade"
                id="schoolGrade"
                v-model="formData.schoolGrade"
                class="entry-text-title"
                placeholder="School Grade"
              />
              <label for="schoolClass" class="journal-label">반</label>
              <input
                type="text"
                name="schoolClass"
                id="schoolClass"
                v-model="formData.schoolClass"
                class="entry-text-title"
                placeholder="School Class"
              />
              <label for="schoolPwd" class="journal-label">학급 비밀번호</label>
              <input
                type="password"
                name="schoolPwd"
                id="schoolPwd"
                v-model="formData.schoolPwd"
                class="entry-text-title"
                placeholder="School Password"
              />
              <label for="nickname" class="journal-label">학급 닉네임</label>
              <input
                type="text"
                name="nickname"
                id="nickname"
                v-model="formData.nickname"
                class="entry-text-title"
                placeholder="Nickname"
              />
              <!-- 추가 입력 항목 끝 -->
              <button class="btn-main entry-submit-btn" type="submit">
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </section>

    <!-- Journal Entry Results -->
    <section class="section sectionEntryResults" id="entryResultsSection">
      <div class="container">
        <div class="container-row entryResultRow"></div>
      </div>
    </section>
  </div>
</template>

<script>
import { mapActions } from "vuex";
const schoolStore = "schoolStore";

export default {
  name: "SchoolCreateView",
  data() {
    return {
      formData: {
        schoolName: "",
        schoolGrade: "",
        schoolClass: "",
        schoolPwd: "",
        nickname: "",
      },
      id: "", //login id
    };
  },
  mounted() {
    this.id = JSON.parse(sessionStorage.getItem("userInfo")).id;
  },
  methods: {
    ...mapActions(schoolStore, ["createSchool"]),
    handleSubmit() {
      this.createSchool({ id: this.id, request: this.formData });
    },
  },
};
</script>

<style></style>
