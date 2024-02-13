<template>
  <!-- Entry Section -->
  <section class="section journal-section">
    <div class="container">
      <div class="container-row container-row-journal">
        <div class="container-item container-item-journal">
          <form id="entryForm" @submit.prevent="handleSubmit">
            <label for="entry-id" class="journal-label">아이디</label>
            <div
              style="
                display: flex;
                justify-content: space-between;
                align-items: center;
                gap: 21px;
              "
            >
              <input
                type="text"
                name="entry-id"
                id="entry-id"
                class="entry-text-title"
                v-model="formData.id"
              />
              <button
                class="btn btn--basic"
                @click.prevent="handleCheckSubmit"
                style="height: 50px"
              >
                중복 체크
              </button>
            </div>

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
            <label for="entry-nickname" class="journal-label">닉네임</label>
            <input
              type="text"
              name="entry-nickname"
              id="entry-nickname"
              class="entry-text-title"
              v-model="formData.nickname"
            />
            <div
              style="
                display: flex;
                justify-content: space-between;
                align-items: center;
              "
            >
              <button class="btn-main entry-submit-btn" type="submit">
                회원가입
              </button>
              <router-link to="/" id="login-link" style="text-decoration: none">
                <button class="btn-main entry-submit-btn">로그인</button>
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
  name: "SignUpView",
  data() {
    return {
      formData: {
        id: "",
        pwd: "",
        nickname: "",
      },
      validateCheckId: false,
    };
  },
  methods: {
    ...mapActions(userStore, ["signUp"]),
    ...mapActions(userStore, ["checkDuplicateId"]),
    handleSubmit() {
      if (this.validateCheckId) {
        this.signUp(this.formData);
      } else {
        alert("중복된 아이디입니다. 다시 입력하세요");
      }
    },

    //id 중복체크 메서드
    handleCheckSubmit() {
      if (this.formData.id) {
        this.checkDuplicateId(this.formData.id)
          .then((response) => {
            if (response.data.resultCode == 200) {
              alert("사용할 수 있는 아이디입니다.");
              this.validateCheckId = true;
            } else {
              alert("사용할 수 없는 아이디입니다.");
            }
          })
          .catch((error) => {
            console.error(error);
            alert("중복체크에 실패했습니다.");
            window.history.back();
          });
      }
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

/* Transition */
.transition {
  transition: all 0.1s ease;
}

/* Basic Button */
.btn--basic {
  @extend .transition;
  position: relative;
  display: inline-block;
  padding: 1em 2em;
  border: 0;
  border-radius: 30px;
  cursor: pointer;
  font-size: 14px;
  background-color: #e3eacc;
  color: #455a00;
}
.btn--basic:hover {
  box-shadow: inset 0 -3px 0 rgba(0, 0, 0, 0.15);
}

.btn--basic:active {
  transform: translateY(1px);
  box-shadow: inset 0 3px 0 0 rgba(0, 0, 0, 0.15);
}

.btn--basic:focus {
  outline: none;
}
</style>
