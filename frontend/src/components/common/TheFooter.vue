<template>
    <div>
      <!-- 여기에 다른 컴포넌트나 내용이 있다면 추가하세요 -->
  
      <footer>
        <div class="footer-content">
          <p>© 2024 Your Website</p>
          <nav>
            <router-link to="/about">About</router-link>
            <router-link to="/contact">Contact</router-link>
          </nav>
        </div>
      </footer>
    </div>
  </template>
  
  <script>
  export default {
    name: 'TheFooter',
  };
  </script>
  
  <style>
  footer {
    background-color: #FFFCF3; /* Footer 배경색상 설정 */
    color: white;
    padding: 20px 0;
    text-align: center;
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
  