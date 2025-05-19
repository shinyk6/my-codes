const model = require('../models/travelModel'); // 모델 컴포넌트를 가져온다.

// controller - 유효성 검사, 페이지 이동 / 클라이언트 값을 서버 유효성 검사 -> 
// 유효성검사가 vaildate가 되면 페이지 이동 <1. 클라이언트값 <-> Dao> <2.클라이언트값 <-> biz <-> dao> <3. 클라이언트 값 <-> biz> 
// biz(Business) = 보통 service계층과 같은 말로 쓰임. (옛날에는 따로 세분화하기도 했지만, 요즘엔 거의 통일해서 부름)

exports.getAll = async (req, res) => { //pool.promise; 를 선언해서 비동기를 동기처럼 사용하는 await/async 사용
  try {
    const [rows] = await model.getAllTravels(); //값이 얼마나 올지 모르기에 배열의 객체로 처리
    res.json(rows);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

exports.getOne = async (req, res) => {
  try {
    const [rows] = await model.getTravelById(req.params.id); //id 값 보냄-get방식
    if (rows.length === 0) return res.status(404).json({ error: 'Not found' });
    res.json(rows[0]);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

exports.create = async (req, res) => {
  try {
    await model.createTravel(req.body); //body통째로 보냄-post방식
    res.status(201).json({ message: 'Travel created' });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

exports.update = async (req, res) => {
  try {
    await model.updateTravel(req.params.id, req.body);
    res.json({ message: 'Travel updated' });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

exports.delete = async (req, res) => {
  try {
    await model.deleteTravel(req.params.id);
    res.json({ message: 'Travel deleted' });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};
