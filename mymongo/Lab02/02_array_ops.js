// MongoDB 배열 연산 문제 - students_scores 컬렉션 기반

// Q1. 모든 학생의 이름을 배열로 수집하자.
print("-- Q1. 모든 학생의 이름을 배열로 수집하자. --");
db.students_scores.aggregate([
  { $group: { _id: null, 이름목록: { $push: "$name" } } }
]).forEach(printjson);


// Q1-1. 모든 학생의 이름을 중복없이 배열로 수집하자. $addToSet, $sortArray
print("-- Q1-1. 모든 학생의 이름을 중복없이 배열로 수집하자. --");
db.students_scores.aggregate([
  {$group: {_id:null, 이름목록: {$addToSet: "$name"}}},
  {$project: {정렬된이름: {$sortArray: {input: "$이름목록", sortBy: 1}}}}
]).forEach(printjson);


// Q2. 학생별 이름과 국어, 영어 점수를 하나의 배열 객체로 수집하자.
print("-- Q2. 학생별 이름과 국어, 영어 점수를 하나의 배열로 수집하자. --");
db.students_scores.aggregate([
  { $group: {
      _id: null,
      목록: { $push: { name: "$name", kor: "$kor", eng: "$eng" } }
    }
  }
]).forEach(printjson);

// Q2-1. 학생별 이름, 영어 점수를 하나의 배열로 수집하자. 영어점수 85점 이상만 우수 학생
print("-- Q2-1. 학생별 이름, 영어 점수를 하나의 배열로 수집하자. 영어점수 85점 이상만 우수 학생--");
db.students_scores.aggregate([
  { $match: {eng: {$gte:85}}},
  { $group: {
      _id: null,
      우수학생: { $push: { name: "$name", eng: "$eng" } }
    },
  }
]).forEach(printjson);



// Q3. 국어 점수가 배열인 경우 총합으로 변환하여 수집하자.
print("-- Q3. 국어 점수가 배열인 경우 총합으로 변환하여 수집하자. --");
db.students_scores.aggregate([
  { $project: {
      name: 1,
      test: 1,
      kor_total: {
        $cond: {
          if: { $isArray: "$kor" }, //배열 일 경우
          then: { $sum: "$kor" }, //sum구하고
          else: "X" //그렇기 않으면 출력
        }
      }
    }
  }
]).forEach(printjson);

// Q3. 국어 점수가 배열인 경우 평균으로 변환하여 수집하자.
print("--Q3-1. 국어 점수가 배열인 경우 평균을 출력. 그렇지 않으면 X--")
db.students_scores.aggregate([
  { $project: {
      name: 1,
      test: 1,
      kor_total: {
        $cond: {
          if: { $isArray: "$kor" }, //배열 일 경우
          then: { $avg: "$kor" }, //sum구하고
          else: "X" //그렇기 않으면 출력
        }
      }
    }
  }
]).forEach(printjson);


// Q4. 영어 점수 배열을 만들어 길이를 출력하자.
print("-- Q4. 영어 점수 배열을 만들어 길이를 출력하자. --");
db.students_scores.aggregate([
  { $group: {
      _id: null,
      영어배열: { $push: "$eng" }
    }
  },
  { $project: {
      _id: 0,
      총영어인원: { $size: "$영어배열" },
      총영어합: { $sum: "$영어배열"}
    }
  }
]).forEach(printjson);

// Q5. 이름이 '문'으로 시작하는 학생 이름만 필터링해서 배열로 출력하자.
print("-- Q5. 이름이 '문'으로 시작하는 학생 이름만 필터링 --");
db.students_scores.aggregate([
  { $group: {
      _id: null,
      이름목록: { $push: "$name" }
    }
  },
  { $project: {
      _id: 0,
      문으로시작: {
        $filter: {
          input: "$이름목록",
          as: "이름", //별칭
          cond: { $regexMatch: { input: "$$이름", regex: "^문" } }
        }
      }
    }
  }
]).forEach(printjson);


// Q5-1. 이름이 '이'로 시작하지 않는 학생 이름만 필터링해서 배열로 출력하자.
print("-- Q5-1. 이름이 '이'로 시작하지 않는 학생 이름만 필터링 --");
db.students_scores.aggregate([
  { $group: {
      _id: null,
      이름목록: { $push: "$name" }
    }
  },
  { $project: {
      _id: 0,
      문으로시작: {
        $filter: {
          input: "$이름목록",
          as: "이름", //별칭
          cond: { $not: {$regexMatch: { input: "$$이름", regex: "^이" }} } 
        }
      }
    }
  }
]).forEach(printjson);



// Q6. 이름 배열에서 세 번째 학생만 출력하자.
print("-- Q6. 이름 배열에서 세 번째 학생만 출력하자. --");
db.students_scores.aggregate([
  { $group: {
      _id: null,
      이름목록: { $push: "$name" }
    }
  },
  { $project: {
      _id: 0,
      세번째학생: { $arrayElemAt: ["$이름목록", 2] }
    }
  }
]).forEach(printjson);

// Q7. 이름 목록을 앞에서 3명만 잘라서 출력하자.
print("-- Q7. 이름 목록에서 앞 3명만 잘라서 추출하자. --");
db.students_scores.aggregate([
  { $group: {
      _id: null,
      이름목록: { $push: "$name" }
    }
  },
  { $project: {
      _id: 0,
      상위3명: { $slice: ["$이름목록", 3] } //3명만 자르기
    }
  }
]).forEach(printjson);


print("-- Q7-1. 이름 목록에서 마지막 학생만 추출하자. --");
db.students_scores.aggregate([
  {
    $group: {_id:null, 이름목록: {$push: "$name"}}
  },
  {
    $project: {
      마지막: {
        $arrayElemAt: ["$이름목록", {$subtract: [{$size: "$이름목록"},1] }]
      }
    }
  }
]).forEach(printjson);

print("-- Q7-2. 이름 목록에서 뒤에서 3명 학생만 추출하자. $slice  $subtract --");
// $slice : [배열, 개수] $slice : [배열, 시작인덱스, 개수]
db.students.students_scores.aggregate([
  { $group: {_id:null, 이름목록: {$push: "$name"}}},
  {
    $project : { Last3명: { $slice: ["이름목록", {$subtract: [ {$size: "$이름목록"}, 3]},3]}}
  }
]).forEach(printjson)


// Q8. 모든 이름을 대문자로 변환하여 배열로 출력하자.
print("-- Q8. 모든 이름을 대문자로 변환하여 배열로 출력하자. --");
db.students_scores.aggregate([
  { $group: {
      _id: null,
      이름목록: { $push: "$name" }
    }
  },
  { $project: {
      _id: 0,
      대문자이름: {
        $map: {
          input: "$이름목록",
          as: "이름",
          in: { $toUpper: "$$이름" }
        }
      }
    }
  }
]).forEach(printjson);


// Q9. 모든 이름의 첫 글자만 배열로 출력하자.
print("-- Q9. 모든 이름의 첫 글자만 배열로 출력하자. --");
db.students_scores.aggregate([
  { $group: {
      _id: null,
      이름목록: { $push: "$name" }
    }
  },
  { $project: {
      _id: 0,
      첫글자목록: {
        $map: {
          input: "$이름목록",
          as: "이름",
          in: { $substrCP: ["$$이름", 0, 1] } //$substrCP : 문자열 연산자  0번째 인덱스 1개 추출
        }
      }
    }
  }
]).forEach(printjson);

// Q10. 중복 없이 이름을 배열로 수집하자.
print("-- Q10. 중복 없이 이름을 배열로 수집하자. --");
db.students_scores.aggregate([
  { $group: {
      _id: null,
      유일이름목록: { $addToSet: "$name" }
    }
  }
]).forEach(printjson);

// Q11. 중복 없이 이름을 배열로 수집하자.
print("-- Q11. 중복 없이 이름을 배열로 담아 컬렉션으로 리턴하자. --");
db.students_scores.aggregate([
  { $group: {
      _id: null,
      유일이름목록: { $addToSet: "$name" }
    }
  }, {
    $out: "result"
  }
])

// $out - 덮어쓰기(옵션x) / $merge - 병합, 덮어쓰기 가능 (옵션o)