import {getSchoolClass, searchByKeywordSchool} from '@/api/school'


const schoolStore = {
    namespaced: true,
    state:{
        schoolInfo: {}
    },

    getters:{
        getSchool: state =>{
            return state.schoolInfo
        }
    },
    mutations:{
        SET_SCHOOL:(state, data)=>{
            state.schoolInfo = data
        }
    },
    actions:{
        async getSchool({commit}, id){
            try{
                const response = await getSchoolClass(id);
                commit('SET_SCHOOL', response.data.result)
            }catch(error){
                alert('나의 학급을 조회 실패했습니다.')
                console.error(error);
                window.history.back();
            }
            
        },
        async searchSchool({ commit }, keyword) {
            try {
                const response = await searchByKeywordSchool(keyword);
                commit('SET_SCHOOL', response.data.result)
            }catch(error){
                alert('학급 검색 조회 실패했습니다.')
                console.error(error);
                window.history.back();
            }
        }
    }
}

export default schoolStore