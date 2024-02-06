import Vue from 'vue'
import Vuex from 'vuex'
import diaryStore from '@/store/modules/diaryStore'
import userStore from '@/store/modules/userStore'
import schoolStore from '@/store/modules/schoolStore'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    diaryStore,
    userStore,
    schoolStore
  }
})

export default store