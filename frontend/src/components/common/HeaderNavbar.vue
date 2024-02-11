<template>
  <div>
    <b-navbar type="light" variant="light">
      <b-navbar-nav>
        <div id="logo-box">
          <img src="@/assets/images/main_logo.png" id="logo-image" />
        </div>
        <b-collapse id="nav-text-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item href="#" id="item-text">일기장</b-nav-item>
          </b-navbar-nav>
        </b-collapse>
        <b-collapse id="nav-text-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item href="/school/list" id="item-text">우리의 학급</b-nav-item>
          </b-navbar-nav>
        </b-collapse>
        <b-collapse id="nav-text-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item v-if="isLoginUser" @click="logout" id="item-text"
              >{{ this.loginId }}님, 로그아웃</b-nav-item
            >
            <b-nav-item href="/" v-if="!isLoginUser" id="item-text">로그인</b-nav-item>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>
<script>
import { mapActions, mapGetters } from "vuex";
const userStore = "userStore";

export default {
  name: "HeaderNavbar",
  data() {
    return {
      loginId: null,
    };
  },

  created() {
    this.isLoginUser = sessionStorage.getItem("isLogin");
  },
  mounted() {
    var userInfo = JSON.parse(sessionStorage.getItem("userInfo"));
    if (userInfo !== null) {
      this.loginId = userInfo.id;
    }
  },

  computed: {
    ...mapGetters(userStore, ["getIsLogin"]),
    isLoginUser: {
      get() {
        return this.getIsLogin;
      },
    },
  },
  methods: {
    ...mapActions(userStore, ["logout"]),
  },
};
</script>
<style>
#logo-box {
  display: flex;
  justify-content: flex-end; /* 로고를 오른쪽으로 정렬 */
  align-items: center; /* 세로 방향 가운데 정렬 */
}

#logo-link {
  text-decoration: none; /* 링크의 기본 텍스트 장식 제거 */
}

#logo-image {
  margin-right: 35px; /* 이미지와 텍스트 간격 조절 */
  height: 30px;
}

#item-text {
  font-size: 25px; /* 텍스트 크기 조절 */
}
</style>
