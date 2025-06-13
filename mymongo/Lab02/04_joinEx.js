//  Emp -Dept 조인
// db.students.aggregate([ 
//   { 
//     $lookup: { 
//       from: "scores",             // 조인할 컬렉션 
//       localField: "name",         // 현재 컬렉션 기준 필드 
//       foreignField: "name",       // 외부 컬렉션 기준 필드 
//       as: "scoreInfo"             // 결과 저장 필드 (배열) 
//     } 
//   },
//  { $unwind: "$scoreInfo" },   // null 제거 (배열 해제) 
//  { $match: { "scoreInfo": { $ne: null } } }  // 없어도 되지만 명시 가능 
// ]) 


// Emp  -Dept 조인 

print("1. INNER JOIN  $lookup + $unwind + $match ")
db.emp.aggregate([
    {
      $lookup: {
        from: "dept",
        localField: "deptno",
        foreignField: "deptno",
        as: "deptInfo"
      }
    },
    { $unwind: "$deptInfo" },
    { $match: { deptInfo: { $ne: null } } }
  ]).forEach(printjson);

print("2. LEFT OUTER JOIN $lookup 기본" ) 
db.emp.aggregate([
    {
      $lookup: {
        from: "dept",
        localField: "deptno",
        foreignField: "deptno",
        as: "deptInfo"
      }
    }
  ]).forEach(printjson); 

print("3. RIGHT OUTER JOIN  직접 구현 필요 ($unionWith + 커스텀) 없음")  

db.dept.aggregate([
  {
    $lookup: {
      from: "emp",
      localField: "deptno",
      foreignField: "deptno",
      as: "empInfo"
    }
  },
  {
    $addFields: {
        joinSource: "dept" //소스의 출처를 식별하기 위해 반드시 명시  -> 조인의 방향을 추적
    }
  }
]).forEach(printjson);


print("4. FULL OUTER JOIN - $lookup 두 번 + $unionWith");
/*
    joinSource -> 조인방향 추적 (full 에서는 반드시 명시)
    joinSource: emp -> Emp 기준으로 조인
    joinSource: dept -> Dept 기준으로 조인

*/

// emp ->  dept
const empJoin = db.emp.aggregate([
    {
      //1. emp ->  dept
    $lookup: {
      from: "dept",
      localField: "deptno",
      foreignField: "deptno",
      as: "deptInfo"
    }
    }, 
    {
        $addFields: { source: "emp", joinSource: "emp" }
    }, 

  // 2. $unionWith   dept ->  emp 조인 추가
  {
    $unionWith: {
      coll: "dept",
      pipeline: [
        {
          $lookup: {
            from: "emp",
            localField: "deptno",
            foreignField: "deptno",
            as: "empInfo"
          }
        },
        {
          $addFields: { source: "dept", joinSource: "dept"}
        }
      ]
    }
  }
]).forEach(printjson);


// dept -> emp
const deptJoin = db.dept.aggregate([
    {
      //1. emp ->  dept
    $lookup: {
      from: "emp",
      localField: "deptno",
      foreignField: "deptno",
      as: "empInfo"
    }
    }, 
    {
        $addFields: { source: "dept" }
    }, 

  // 2. $unionWith   dept ->  emp 조인 추가
  {
    $unionWith: {
      coll: "dept",
      pipeline: [
        {
          $lookup: {
            from: "dept",
            localField: "deptno",
            foreignField: "deptno",
            as: "deptInfo"
          }
        },
        {
          $addFields: { source: "emp" }
        }
      ]
    }
  }
]).forEach(printjson);