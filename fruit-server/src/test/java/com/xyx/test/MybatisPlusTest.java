package com.xyx.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyx.entity.Fruit;
import com.xyx.mapper.FruitMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/13 013 11:18
 * @description:测试分页插件
 */
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private FruitMapper fruitMapper;

    @Test
    public void testPage(){
//        Page<Fruit> page=new Page<>(2,4);
//        Page<Fruit> page1 = fruitMapper.selectPage(page, null);
//        System.out.println(page);
    }


}
