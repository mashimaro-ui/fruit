package com.dong.fruit;

import com.dong.fruit.entity.Fruit;
import com.dong.fruit.service.FruitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FruitApplicationTests {
    @Autowired
    private FruitService fruitService;

    @Test
    void contextLoads() {
    }

    @Test
    void add(){
        Fruit fruit = new Fruit();
        fruit.setName("西瓜");
        fruit.setSale(123);
        fruit.setIcon("dfddafadfa");
        Boolean result = fruitService.save(fruit);
        if (result){
            System.out.println("ok");
        }

    }

    @Test
    void count(){
        Fruit fruit = new Fruit();
        fruit.setName("西瓜");
        fruit.setSale(123);
        fruit.setIcon("dfddafadfa");
        Boolean result = fruitService.save(fruit);
        if (result){
            System.out.println("ok");
        }



    }

}
