<template>
  <div class="center-container">
    <div
      style="display: flex; justify-content: space-between; align-items: center"
    >
      <h1>
        오늘의 일기 주제를 추천받으세요
        <img
          src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Smilies/Cat%20with%20Wry%20Smile.png"
          alt="Cat with Wry Smile"
          width="75"
          height="75"
        />
      </h1>
    </div>

    <button
      style="width: 160px; height: 50px"
      @click.prevent="createChatGPT"
      class="btn-main entry-submit-btn"
      v-if="messageContent == ''"
    >
      추천받기
    </button>

    <h3 v-html="formattedMessageContent"></h3>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "DiaryChatGPTView",
  data() {
    return {
      messageContent: "",
    };
  },
  computed: {
    formattedMessageContent() {
      return this.messageContent.replace(/(\d+)\. /g, "<br>$1. ");
    },
  },
  methods: {
    createChatGPT() {
      var api_key = process.env.VUE_APP_API_KEY;
      var keywords = "오늘의 일기";
      var messages = [
        { role: "system", content: "You are a helpful assistant." },
        {
          role: "user",
          content:
            keywords +
            "에 대해 다룰 주제를 10가지 추천해주세요. 각 주제는 한 줄로 작성되어야 하며, 오늘의 활동, 생각, 감정 또는 경험을 다룰 수 있는 다양한 주제여야 합니다.",
        },
      ];
      var config = {
        headers: {
          Authorization: `Bearer ${api_key}`,
          "Content-Type": "application/json",
        },
      };
      var data = {
        model: "gpt-3.5-turbo",
        temperature: 0.5,
        n: 1,
        messages: messages,
      };
      axios
        .post("https://api.openai.com/v1/chat/completions", data, config)
        .then(({ data }) => {
          this.messageContent = data.choices[0].message.content;
        })
        .catch(function (error) {
          console.error(error);
        });
    },
  },
};
</script>

<style>
.center-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 70vh; /* 화면 전체 높이를 기준으로 정렬합니다. */
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
</style>
