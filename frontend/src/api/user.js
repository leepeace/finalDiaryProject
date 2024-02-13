import api from '@/api/auth'

const signUpUser = request => api.post(`/user/sign-up`, request)

const loginUser = request => api.post(`/user/login`, request)

const checkId = id => api.get(`/user/check-id?id=${id}`)

export {signUpUser, loginUser, checkId}