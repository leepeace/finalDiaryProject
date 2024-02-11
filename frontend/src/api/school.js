import api from '@/api/auth'

const getSchoolClass = id => api.get(`/school?id=${id}`)
const searchByKeywordSchool = keyword => api.get(`/school/search?keyword=${keyword}`)

export {getSchoolClass, searchByKeywordSchool}