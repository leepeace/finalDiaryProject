import api from '@/api/auth'

const signUpUser = request => api.post(`/user/sign-up`, request)

const loginUser = request => api.post(`/user/login`, request)

export {signUpUser, loginUser}