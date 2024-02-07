import { loginUser, signUpUser } from "@/api/user";
import router from "@/router";

const userStore = {
  namespaced: true,
  state: {
    userInfo: {},
    isLogin: false, // 사용자 로그인 여부를 저장하는 상태 추가
  },
  getters: {
    getUser: (state) => {
      return state.userInfo;
    },
    getUserId: () => {
      return JSON.parse(sessionStorage.getItem('userInfo'));
    },
    getIsLogin:()=>{
      return JSON.parse(sessionStorage.getItem("isLogin"));
    }
  },
  mutations: {
    SET_USER: (state, data) => {
      state.userInfo = data;
      sessionStorage.setItem("userInfo", JSON.stringify(data));
      sessionStorage.setItem("isLogin", true);// 사용자 로그인 상태 변경
      state.isLogin=true
    },
    LOGOUT(state) {
      state.userInfo = {};
      state.isLogin=false
      sessionStorage.setItem("userInfo", {});
      sessionStorage.setItem("isLogin", false)// 사용자 로그아웃 상태 변경
    },
  },
  actions: {
    async login({ commit }, request) {
      try {
        await loginUser(request); // 로그인 요청 보내기
        alert("로그인에 성공했습니다.");
        const user = {
          id: request.id, // 요청 객체에서 사용자 ID 가져오기
        };
        commit("SET_USER", user);
        router.push("/"); //메인 페이지로 이동
      } catch (error) {
        alert("로그인에 실패했습니다.");
        console.error(error);
        window.history.back();
      }

    },

    async signUp(_, request) {
      try {
        await signUpUser(request);
        alert("회원가입에 성공했습니다.");
        router.push("/user/login"); //로그인 페이지로 이동
      } catch (error) {
        alert("회원가입에 실패했습니다.");
        console.error(error);
        window.history.back();
      }
    },
    logout({ commit }) {
      commit("LOGOUT"); // 로그아웃 상태 변경
    },
  },
};

export default userStore;
