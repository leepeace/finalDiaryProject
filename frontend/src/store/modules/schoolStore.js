import {getSchoolClass, searchByKeywordSchool} from '@/api/school'


const schoolStore = {
    namespaced: true,
    state:{
        schoolInfo: {},
        searchSchoolInfo: {}
    },

    getters:{
        getSchool: state =>{
            return state.schoolInfo
        }
    },
    mutations:{
        SET_SCHOOL:(state, data)=>{
            state.schoolInfo = data
        },
        SET_SCHOOL_BY_KEYWORD: (state, data) => {
            state.searchSchoolInfo = data
        }
    },
    actions:{
        async getSchool({commit}, id){
            try{
                const response = await getSchoolClass(id);
                if(response.data.resultCode == 200){
                    commit('SET_SCHOOL', response.data.result)
                }else if(response.data.resultCode == 204){
                    commit('SET_SCHOOL', null);
                }
            }catch(error){
                alert('나의 학급을 조회 실패했습니다.')
                console.error(error);
                window.history.back();
            }
            
        },
        async searchSchool({ commit }, keyword) {
            try {
                const response = await searchByKeywordSchool(keyword);
                commit('SET_SCHOOL_BY_KEYWORD', response.data.result)
            }catch(error){
                alert('학급 검색 조회 실패했습니다.')
                console.error(error);
                window.history.back();
            }
        }
    }
}

export default schoolStore