import api from '@/api/auth'

const getDiaryDetail = diaryId => api.get(`/diary/detail?diaryId=${diaryId}`)
const getAllDiary = classId => api.get(`/diary?classId=${classId}`)
const deleteDiary = (id, diaryId) => api.delete(`/diary?id=${id}&diaryId=${diaryId}`)
const createDiary = request => api.post(`/diary`, request)
const updateDiary = request => api.put(`/diary`, request)
export {getDiaryDetail, getAllDiary, deleteDiary, createDiary, updateDiary}