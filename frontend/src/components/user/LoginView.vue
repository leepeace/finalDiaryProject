<template>
  <!-- Entry Section -->
  <section class="section journal-section">
    <div class="container">
      <div class="container-row container-row-journal">
        <div class="container-item container-item-journal">
          <form id="entryForm" @submit.prevent="handleSubmit">
            <label for="entry-id" class="journal-label">아이디</label>
            <input
              type="text"
              name="entry-id"
              id="entry-id"
              class="entry-text-title"
              v-model="formData.id"
            />
            <div style="display: flex; justify-content: space-between">
              <label for="entry-password" class="journal-label">비밀번호</label>
            </div>
            <input
              type="password"
              name="entry-password"
              id="entry-password"
              class="entry-text-title"
              v-model="formData.pwd"
            />
            <div style="display: flex; justify-content: space-between">
              <button class="btn-main entry-submit-btn">로그인</button>
              <router-link
                to="/user/signup"
                id="login-link"
                style="text-decoration: none"
              >
                <button class="btn-main entry-submit-btn">회원가입</button>
              </router-link>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { mapActions } from "vuex";

const userStore = "userStore";

export default {
  name: "LoginView",
  data() {
    return {
      formData: {
        id: "",
        pwd: "",
      },
    };
  },
  methods: {
    ...mapActions(userStore, ["login"]),
    handleSubmit() {
      this.login(this.formData);
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
