<template>
  <footer class="p-10 footer bg-primary text-accent footer-center">
    <div class="grid grid-flow-col gap-4">
      <a href="/intro/" class="link link-hover">소개</a>
      <a href="/notice/" class="link link-hover">공지사항</a>
      <a href="/qna/" class="link link-hover">자주 묻는 질문</a>
      <a href="/contact/" class="link link-hover">문의/제안</a>
    </div>

    <div>
      <p>Copyright © 2022 - All right reserved by Classbinu</p>
    </div>
  </footer>
</template>

<script>
export default {
  name: "TheFooter",
};
</script>

<style>
footer {
  background-color: #fffcf3; /* Footer 배경색상 설정 */
  color: white;
  padding: 20px 0;
  text-align: center;
  position: fixed;
  bottom: 0;
  width: 100%;
}

.footer-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

nav a {
  color: white;
  margin-left: 10px;
  text-decoration: none;
}
</style>
