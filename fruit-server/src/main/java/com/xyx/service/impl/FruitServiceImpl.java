package com.xyx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyx.entity.Fruit;
import com.xyx.mapper.FruitMapper;
import com.xyx.service.FruitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyx.util.ColorUtil;
import com.xyx.vo.PageVO;
import com.xyx.vo.BarVO;
import com.xyx.vo.DataVO;
import com.xyx.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xyx
 * @since 2023-08-12
 */
@Service
public class FruitServiceImpl extends ServiceImpl<FruitMapper, Fruit> implements FruitService {

    @Autowired
    private FruitMapper fruitMapper;

    @Override
    public BarVO queryAllBarVO() {
        BarVO barVO=new BarVO();
        List<String> names=new ArrayList<>();
        List<DataVO> values=new ArrayList<>();

        List<Fruit> fruits = fruitMapper.selectList(null);

        for (Fruit fruit:fruits){
            names.add(fruit.getName());

            DataVO dataVO = new DataVO();
            dataVO.setValue(fruit.getSale());

            Map<String,String> map=new HashMap<>();
            map.put("color",ColorUtil.getColor(fruit.getName()));
            dataVO.setItemStyle(map);
            values.add(dataVO);
        }
        barVO.setNames(names);
        barVO.setValues(values);

        return barVO;
    }

    @Override
    public List<PieVO> queryAllPieVO() {
        List<PieVO> pieVOList=new ArrayList<>();
        List<Fruit> fruits = fruitMapper.selectList(null);

        for (Fruit fruit:fruits){
            PieVO pieVO = new PieVO();
            pieVO.setValue(fruit.getSale());
            pieVO.setName(fruit.getName());

            Map<String,String> map=new HashMap<>();
            map.put("color",ColorUtil.getColor(fruit.getName()));
            pieVO.setItemValue(map);

            pieVOList.add(pieVO);
        }
        return pieVOList;
    }

    @Override
    public PageVO getPages(PageVO pageVO) {
        Page<Fruit> page = new Page<>(pageVO.getCurrent(), pageVO.getSize());
        //获取查询后的结果集
        Page<Fruit> fruitPage = fruitMapper.selectPage(page, null);

        PageVO pageVOResult = new PageVO();
        System.out.println("Current:"+fruitPage.getCurrent());
        pageVOResult.setCurrent(fruitPage.getCurrent());

        System.out.println("Size:"+fruitPage.getSize());
        pageVOResult.setSize(fruitPage.getSize());

        System.out.println("Total:"+fruitPage.getTotal());
        pageVOResult.setTotalCount(fruitPage.getTotal());

        System.out.println("Records:"+fruitPage.getRecords());
        pageVOResult.setData(fruitPage.getRecords());

        return pageVOResult;
    }

    @Override
    public PageVO getPages2(PageVO pageVO,Long size) {
        /**
         * @author: xyx & yx282947664@163.com
         * @description: 改变页面size的方法
         */
        Page<Fruit> page = new Page<>(pageVO.getCurrent(), size);
        //获取查询后的结果集
        Page<Fruit> fruitPage = fruitMapper.selectPage(page, null);

        PageVO pageVOResult = new PageVO();
        System.out.println("Current:"+fruitPage.getCurrent());
        pageVOResult.setCurrent(fruitPage.getCurrent());

        System.out.println("Size:"+fruitPage.getSize());
        pageVOResult.setSize(fruitPage.getSize());

        System.out.println("Total:"+fruitPage.getTotal());
        pageVOResult.setTotalCount(fruitPage.getTotal());

        System.out.println("Records:"+fruitPage.getRecords());
        pageVOResult.setData(fruitPage.getRecords());

        return pageVOResult;
    }

//    @Override
//    public PageVO getPages3(PageVO pageVO, Long current) {
//        /**
//         * @author: xyx & yx282947664@163.com
//         * @description: 改变页面当前页的方法
//         */
//        Page<Fruit> page = new Page<>(current, pageVO.getSize());
//        //获取查询后的结果集
//        Page<Fruit> fruitPage = fruitMapper.selectPage(page, null);
//
//        PageVO pageVOResult = new PageVO();
//        System.out.println("Current:"+fruitPage.getCurrent());
//        pageVOResult.setCurrent(fruitPage.getCurrent());
//
//        System.out.println("Size:"+fruitPage.getSize());
//        pageVOResult.setSize(fruitPage.getSize());
//
//        System.out.println("Total:"+fruitPage.getTotal());
//        pageVOResult.setTotalCount(fruitPage.getTotal());
//
//        System.out.println("Records:"+fruitPage.getRecords());
//        pageVOResult.setData(fruitPage.getRecords());
//
//        return pageVOResult;
//    }
    @Override
    public PageVO getPages3(PageVO pageVO, Long current ,Long size) {
        /**
         * @author: xyx & yx282947664@163.com
         * @description: 改变页面当前页的方法
         */
        Page<Fruit> page = new Page<>(current, size);
        //获取查询后的结果集
        Page<Fruit> fruitPage = fruitMapper.selectPage(page, null);

        PageVO pageVOResult = new PageVO();
        System.out.println("Current:"+fruitPage.getCurrent());
        pageVOResult.setCurrent(fruitPage.getCurrent());

        System.out.println("Size:"+fruitPage.getSize());
        pageVOResult.setSize(fruitPage.getSize());

        System.out.println("Total:"+fruitPage.getTotal());
        pageVOResult.setTotalCount(fruitPage.getTotal());

        System.out.println("Records:"+fruitPage.getRecords());
        pageVOResult.setData(fruitPage.getRecords());

        return pageVOResult;
    }

}
