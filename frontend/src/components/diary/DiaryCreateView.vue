<template>
  <div>
    <!-- Entry Section -->
    <section class="section journal-section">
      <div class="container">
        <div class="container-row container-row-journal">
          <div class="container-item container-item-journal">
            <form id="entryForm" @submit.prevent="handleSubmit">
              <label for="entry-title" class="journal-label">제목</label>
              <input
                type="text"
                name="entry-title"
                id="entry-title"
                v-model="formData.title"
                class="entry-text-title"
                placeholder="Name of entry ✏️"
              />
              <label for="entry" class="journal-label">오늘의 일기</label>
              <textarea
                name="daily-entry"
                id="entry"
                class="entry-text-box"
                v-model="formData.content"
                placeholder="What's on your mind today? 💭"
              ></textarea>
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
  name: "DiaryCreateView",
  data() {
    return {
      formData: {
        title: "",
        content: "",
        id: "", //login id
        classId: "",
      },
    };
  },
  mounted() {
    this.formData.classId = this.$route.params.classId;
    this.formData.id = JSON.parse(sessionStorage.getItem("userInfo")).id;
  },
  methods: {
    ...mapActions(schoolStore, ["createSchoolDiary"]),
    handleSubmit() {
      this.createSchoolDiary(this.formData);
    },
  },
};
</script>

<style>
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

.entry-text-title::placeholder {
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

.entry-form {
  max-width: 100%;
  margin: 0 auto;
}

.journal-label {
  display: block;
  line-height: 1.6;
  font-size: 1.2rem;
  font-weight: 700;
}

.entry-text-box {
  width: 100%;
  height: 20em;
  margin: 1em auto;
  padding: 1em;
  border-radius: 2px;
  border: unset;
  background-color: lightgoldenrodyellow;
}

@media (min-width: 769px) {
  .entry-text-box {
    width: 40em;
    height: 20em;
    margin: 1em auto;
    padding: 1em;
    border-radius: 2px;
    border: unset;
    background-color: lightgoldenrodyellow;
  }
}

.entry-text-box:focus {
  outline-color: lightcoral;
  color: lightcoral;
}

.entry-text-box::placeholder {
  color: lightcoral;
}

.entry-submit-btn {
  margin: 0;
}

/* Journal Results Section */

.sectionEntryResults {
  width: 100%;
  margin: 0 auto;
}

.entryResultRow {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
}

.single-entry-div {
  max-width: 100%;
  margin: 1em auto;
  padding: 1em 1em;
}

.single-entry-date {
  background-color: lightgoldenrodyellow;
  width: 100%;
}

.heading-results {
  text-align: center;
  text-decoration: underline;
  text-decoration-color: lightgoldenrodyellow;
}
</style>
