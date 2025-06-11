print("-- Q14.  부서별 월급의 합, 전체 총합 및 세부내역을 출력 해보자.  "); 
const 부서별합 = db.emp.aggregate([
  {
    $group: {
      _id: "$deptno",
      부서총급여: { $sum: "$sal" }
    }
  }
]).toArray();
부서별합.forEach(printjson);
print("=======> :")
const 전체총합 = 부서별합.reduce((acc, d) => acc + d.부서총급여, 0);
print("전체 부서 월급 총합:", 전체총합);

print("========================================================= ")
db.emp.aggregate([
    {
        $group: {
            _id: "$deptno",
            부서별_월급_합: { $sum: "$sal" },
            세부내역: {
          $push: { 
            ename: "$ename",
            sal: "$sal"
          }
        }
      }
    },
    {
      $group: {
        _id: null,
        전체_월급_총합: { $sum: "$부서별_월급_합" }, 
        부서별_상세: {
          $push: {
            deptno: "$_id",
            합계: "$부서별_월급_합",
            사원_리스트: "$세부내역"
          }
        }
      }
    },
    { $project: { _id: 0 } } 
  ]).forEach(printjson); 