package com.test03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary // 우선순위 1위로 먼저 호출된다 -> 동일한 타입의 빈이 여러 개 선언되었을 때 기본으로 호출
		//단, 호출하는 컨드롤러에서 Qualifier가 존재하면 Qualifier가가 우선이다. 
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper mapper;

    @Override
    public List<GoodsVo> getAll() {
        return mapper.listGoods();
    }

    @Override
    public GoodsVo get(String code) {
        return mapper.findGoods(code);
    }

    @Override
    @Transactional
    public void add(GoodsVo vo) {
        mapper.insertGoods(vo);
    }

    @Override
    @Transactional
    public void edit(GoodsVo vo) {
        mapper.updateGoods(vo);
    }

    @Override
    @Transactional
    public void delete(String name) {
        mapper.deleteGoods(name);
    }
}
