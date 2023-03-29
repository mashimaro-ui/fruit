package com.dong.fruit.service;

import com.dong.fruit.entity.Fruit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dong.fruit.vo.BarVO;
import com.dong.fruit.vo.PieVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-09-12
 */
public interface FruitService extends IService<Fruit> {
    public BarVO barVOList();
    public List<PieVO> pieVOList();

}
