import api from '@/api/auth'

const getSchoolClass = id => api.get(`/school?id=${id}`)
const searchByKeywordSchool = keyword => api.get(`/school/search?keyword=${keyword}`)
const joinSchoolClass = request => api.post(`/school/join`, request);
const createSchoolClass = (id, request) => api.post(`/school/create?id=${id}`, request)

export {getSchoolClass, searchByKeywordSchool, joinSchoolClass, createSchoolClass}