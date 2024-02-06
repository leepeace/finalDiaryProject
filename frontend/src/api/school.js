import api from '@/api/auth'

const getSchoolClass = id => api.get(`/school?id=${id}`)

export {getSchoolClass}