import {getDiaryDetail, getAllDiary, deleteDiary, createDiary, updateDiary} from '@/api/diary'
import router from "@/router";

const diaryStore = {
    namespaced: true,
    // state: 변수들의 집합
    state:{
        diaryInfo :null,
        diaryList:{}
    },
    /*
        Gettes: state의 변수들을 get하는역할을 한다.
        - state 자체를 변경하지 않음.
    */
   getters:{
    getDiary: state =>{
        return state.diaryInfo
    },
    getDiaryList: state=>{
        return state.diaryList
    }
   },
    /*
        Mutations: 변수들을 조작하는 함수들의 집합
        - State는 반드시 Mutations가 가진 method를 통해서만 조작 함.
    */
   mutations:{
    SET_DIARY:(state, data) => {
        state.diaryInfo = data
    },
    SET_DIARY_LIST:(state, data)=>{
        state.diaryList = data
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
    },
    async getDiaryIdByClassId({commit}, classId){
        await getAllDiary(classId)
        .then(({data})=>{
            commit('SET_DIARY_LIST', data.result)
        })
        .catch(error =>{
            alert('학급의 일기장이 존재하지 않습니다.')
            console.error(error)
            window.history.back()
        })
    },

    //일기장 삭제 비동기 메서드
    async deleteMyDiary(_, {id, diaryId}){
        const response = await deleteDiary(id, diaryId)
       return response;
    },
    async createSchoolDiary(_, request){
        await createDiary(request)
        .then(({data})=>{
            if(data.resultCode==200){
                alert('등록에 성공했습니다')
                router.push("/diary/list/" + request.classId); //메인 페이지로 이동
            }
        })
        .catch(error=>{
            console.error(error)
            alert("등록에 실패했습니다.")
            window.history.back()
        })
    },
    async updateDiaryInfo({commit}, request){
        await updateDiary(request)
        .then(({data})=>{
            if(data.resultCode == 200){
                alert("수정에 성공했습니다.")
                commit('SET_DIARY', data.result)
                router.push("/diary/detail/"+request.diaryId)
            }
        })
        .catch(error=>{
            console.error(error)
            alert("등록에 실패했습니다.")
            window.history.back()
        })
    }
   },
}


export default diaryStore