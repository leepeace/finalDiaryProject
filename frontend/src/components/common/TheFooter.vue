<template>
  <footer class="p-10 footer bg-primary text-accent footer-center">
    <div>
      <p>Copyright © 2024</p>
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

</style>
