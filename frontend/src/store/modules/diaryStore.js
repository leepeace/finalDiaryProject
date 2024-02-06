import {getDiaryDetail} from '@/api/diary'


const diaryStore = {
    namespaced: true,
    // state: 변수들의 집합
    state:{
        diaryInfo :null
    },
    /*
        Gettes: state의 변수들을 get하는역할을 한다.
        - state 자체를 변경하지 않음.
    */
   getters:{
    getDiary: state =>{
        return state.diaryInfo
    },
   },
    /*
        Mutations: 변수들을 조작하는 함수들의 집합
        - State는 반드시 Mutations가 가진 method를 통해서만 조작 함.
    */
   mutations:{
    SET_DIARY:(state, data) => {
        state.diaryInfo = data
    }
   },
    /*
        Actions: 비동기 처리를 하는 함수들의 집합
    - Actions에서는 비동기적 작업을 Mutations에서는 동기적 작업만을 함.
    */
   actions:{
    async getDiaryDetail({commit}, diaryId){
        await getDiaryDetail(diaryId)
        .then(({data})=>{
            commit('SET_DIARY', data.result)
        })
        .catch(error => {
            alert('존재하지 않는 일기장입니다.')
            console.error(error)
            window.history.back()
        })
    }
   },
}


export default diaryStore