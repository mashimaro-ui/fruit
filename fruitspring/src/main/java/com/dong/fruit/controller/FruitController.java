package com.dong.fruit.controller;


import com.dong.fruit.entity.Fruit;
import com.dong.fruit.service.FruitService;
import com.dong.fruit.vo.BarVO;
import com.dong.fruit.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-09-12
 */
@RestController
@RequestMapping("/fruit")
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @GetMapping("/list")
    public List<Fruit> list(){
        return this.fruitService.list();
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Integer id){
        return this.fruitService.removeById(id);

    }

    @GetMapping("/find/{id}")
    public Fruit findById(@PathVariable("id") Integer id){
        return this.fruitService.getById(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Fruit fruit){
        return this.fruitService.updateById(fruit);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Fruit fruit){
        return this.fruitService.save(fruit);
    }

    @GetMapping("/barVO")
    public BarVO barVO(){
        return this.fruitService.barVOList();
    }

    @GetMapping("/pieVO")
    public List<PieVO> pieVO(){
        return this.fruitService.pieVOList();
    }



}

