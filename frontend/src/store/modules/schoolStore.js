import {getSchoolClass, searchByKeywordSchool, joinSchoolClass, createSchoolClass} from '@/api/school'
import router from '@/router'

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
        },
        async joinSchool(_, request){
            try{
                const response = await joinSchoolClass(request);
                if(response.data.resultCode == 200){
                    router.push("/school/list");
                }
            }catch(error){
                alert('학급 참여에 실패했습니다.')
                console.error(error);
                window.history.back();
            }
        
        },
        async createSchool(_, {id, request}){
            try{
                const response = await createSchoolClass(id, request);
                if(response.data.resultCode == 200){
                    router.push("/school/list");
                }
            }catch(error){
                alert('학급 등록에 실패했습니다.')
                console.error(error);
                window.history.back();
            }
        }
    }
}

export default schoolStore