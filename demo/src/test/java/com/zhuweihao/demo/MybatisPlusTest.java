package com.zhuweihao.demo;

import com.zhuweihao.demo.mapper.FruitMapper;
import com.zhuweihao.demo.pojo.Fruit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhuweihao
 * @Date 2023/2/21 13:33
 * @Description com.zhuweihao.demo
 */
@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private FruitMapper fruitMapper;

    @Test
    public void testSelectList() {
//        List<Fruit> fruitList = fruitMapper.selectList(null);
//        fruitList.forEach(System.out::println);

//        List<Fruit> fruits = fruitMapper.selectBatchIds(Arrays.asList(4, 5, 6));
//        System.out.println(fruits);
        Map<String, Object> map = new HashMap<>();
        map.put("fname", "石榴");
        List<Fruit> fruits1 = fruitMapper.selectByMap(map);
        System.out.println(fruits1);
    }

    @Test
    public void testInsert() {
        Fruit fruit = new Fruit();
        fruit.setFname("荔枝");
        fruit.setPrice(34);
        fruit.setFcount(44);
        fruit.setRemark("空运过来的，很新鲜");
        fruitMapper.insert(fruit);
    }

    @Test
    public void testDelete() {
        Map<String, Object> map = new HashMap<>();
        map.put("fname", "火龙果");
        fruitMapper.deleteByMap(map);
    }

    @Test
    public void testUpdate() {
        Fruit fruit = new Fruit();
        fruit.setFid(4);
        fruit.setFname("荔枝");
        fruit.setPrice(34);
        fruit.setFcount(44);
        fruit.setRemark("陆运过来的，不新鲜");
        fruitMapper.updateById(fruit);
    }
}
