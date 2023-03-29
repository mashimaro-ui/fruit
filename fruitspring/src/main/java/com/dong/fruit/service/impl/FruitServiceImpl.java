package com.dong.fruit.service.impl;

import com.dong.fruit.entity.Fruit;
import com.dong.fruit.mapper.FruitMapper;
import com.dong.fruit.service.FruitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dong.fruit.util.DataUtil;
import com.dong.fruit.vo.BarVO;
import com.dong.fruit.vo.DataVO;
import com.dong.fruit.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-09-12
 */
@Service
public class FruitServiceImpl extends ServiceImpl<FruitMapper, Fruit> implements FruitService {
    @Autowired
    private FruitMapper fruitMapper;

    @Override
    public BarVO barVOList() {
        BarVO barVO = new BarVO();
        List<String> names = new ArrayList<>();
        List<DataVO> values = new ArrayList<>();
        //先查出数据
        List<Fruit> fruits = this.fruitMapper.selectList(null);
        for (Fruit fruit : fruits) {
            names.add(fruit.getName());
            DataVO dataVO = new DataVO();
            dataVO.setValue(fruit.getSale());
            dataVO.setItemStyle(DataUtil.createItemStyle(fruit.getSale()));
            values.add(dataVO);
        }
        barVO.setNames(names);
        barVO.setValues(values);
        //转换VO
        return barVO;
    }

    @Override
    public List<PieVO> pieVOList() {
        List<PieVO> pieVOList = new ArrayList<>();
        List<Fruit> fruits = this.fruitMapper.selectList(null);
        for (Fruit fruit : fruits) {
            PieVO pieVO = new PieVO();
            pieVO.setValue(fruit.getSale());
            pieVO.setName(fruit.getName());
            pieVO.setItemStyle(DataUtil.createItemStyle(fruit.getSale()));
            pieVOList.add(pieVO);
        }
        return pieVOList;
    }

}
