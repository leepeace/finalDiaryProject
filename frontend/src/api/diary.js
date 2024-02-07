import api from '@/api/auth'

const getDiaryDetail = diaryId => api.get(`/diary/detail?diaryId=${diaryId}`)
const getAllDiary = classId => api.get(`/diary?classId=${classId}`)


export {getDiaryDetail, getAllDiary}