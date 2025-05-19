const mysql = require('mysql2'); // require() 해당 컴포넌트 module을 불러옴 (mysql 플러그인 호출)

const pool = mysql.createPool({
  host: '%', //localhost
  user: 'uk60', //root
  password: 'thdbsWkd123', // 실제 비밀번호로 변경 // ' '
  database: 'travel_db'
});

module.exports = pool.promise();  // DB연결 객체를 Promise기반으로 내보내겠다.
