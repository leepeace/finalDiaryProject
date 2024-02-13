import { loginUser, signUpUser ,checkId} from "@/api/user";
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
      const userInfo = sessionStorage.getItem('userInfo');
      return JSON.parse(JSON.stringify(userInfo));
    },
    getIsLogin: () => {
      return sessionStorage.getItem("isLogin");
    }
  },
  mutations: {
    SET_USER: (state, data) => {
      state.userInfo = data;
      sessionStorage.setItem("userInfo", JSON.stringify(data));
      sessionStorage.setItem("isLogin", true);
    },
    LOGOUT() {
      sessionStorage.setItem("isLogin", false);
      sessionStorage.setItem("userInfo", null);
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
        router.push("/school/list"); //메인 페이지로 이동
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
        router.push("/"); //로그인 페이지로 이동
      } catch (error) {
        alert("회원가입에 실패했습니다.");
        console.error(error);
        window.history.back();
      }
    },
    logout({ commit }) {
      commit("LOGOUT"); // 로그아웃 상태 변경
      location.reload();
    },

    //id 중복 체크
    async checkDuplicateId(_, id){
      const response = await checkId(id);
      return response
    }
  },
};

export default userStore;
