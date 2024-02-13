import Vue from "vue";
import Router from "vue-router";
import AppDiary from "@/views/AppDiary.vue";
import AppUser from "@/views/AppUser.vue";
import AppSchool from "@/views/AppSchool.vue";
import AppMain from "@/views/AppMain.vue"

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
        path: '/',
        name: 'Main',
        component:AppMain
    },
    {
      path: "/diary",
      name: "Diary",
      component: AppDiary,
      children: [
        {
          path: "detail/:diaryId",
          name: "DiaryDetailView",
          component: () => import("@/components/diary/DiaryDetailView"),
        },
        {
          path: "list/:classId",
          name: "DiaryListView",
          component: () => import("@/components/diary/DiaryListView"),
        },
        {
          path: "create",
          name: "DiaryCreateView",
          component: () => import("@/components/diary/DiaryCreateView")
        }
      ],
    },
    {
      path: "/user",
      name: "User",
      component: AppUser,
      children: [
        {
          path: "signup",
          name: "SignUpView",
          component: () => import("@/components/user/SignUpView"),
        },
      ],
    },
    {
      path: "/school",
      name: "School",
      component: AppSchool,
      children: [
        {
          path: "list",
          name: "SchoolListView",
          component: () => import("@/components/school/SchoolListView"),
        },
        {
          path: "search",
          name: "SchoolSearchView",
          component: () => import("@/components/school/SchoolSearchView"),
        },
      ],
    },
  ],
});
