import api from '@/api/auth'

const getDiaryDetail = diaryId => api.get(`/diary/detail?diaryId=${diaryId}`)



export {getDiaryDetail}