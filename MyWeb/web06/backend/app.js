// 서버 실행 , 라우팅
// 백앤드 서버 메인 진입점

const express = require('express'); // 백앤드 서버를 웹 프레임워크 서버로 구현하겠다.
const cors = require('cors'); // 모듈 호출 React(3000)  <-> Node.js (3001) 통신 허용
// => 위 2개 모듈 가져오는 코드들


// 앱 객체, 미들웨어 등록
const app = express(); //가지고 온 모듈을 객체 생성
app.use(cors()); //가져 온 모듈을 객체 생성 (포트 충돌하지 말라고 사용)
app.use(express.json()); // request했을 때 모든 body값을 그다음 페이지 서버로 요청하게 되는데,
                //json형식으로 request.body를 파싱하겠다. 

// 테스트용 기본 라우트 http://localhost:3001/    =>백앤드에서 서버를 잘 실행하고 있는지 테스트
app.get('/', (req, res) => {
  res.send('Backend server is running');
});

// 여행지 관련 API 엔드포인트는 여기에 추가 예정
app.use('/api/travels', require('./routes/travelRoutes'));


// 서버 실행
const PORT = 3001; //포트번호 명시 하지 않아도 자동으로 
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});


/*
  포스트맨에서 테스트하면 좋음

  요청이 막힐 경우 어떤식으로 순회?
  CORS 객체 실행 -> PORT -> JSON -> 라우팅 연결   순으로 돌면서 재탐색한다!!


*/
