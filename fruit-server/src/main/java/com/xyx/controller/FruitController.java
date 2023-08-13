package com.xyx.controller;


import com.xyx.entity.Fruit;
import com.xyx.service.FruitService;
import com.xyx.vo.PageVO;
import com.xyx.vo.BarVO;
import com.xyx.vo.PieVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xyx
 * @since 2023-08-12
 */
@RestController
@RequestMapping("/fruit")
public class FruitController {
    @Resource
    private FruitService fruitService;

    @RequestMapping("/queryAll")
    public List<Fruit> QueyAll() {
        return fruitService.list();
    }

    //分页查询
    @GetMapping("/getPage")
    public PageVO getPage(PageVO pageVO) {
        PageVO pages = fruitService.getPages(pageVO);
        return pages;
    }

    //分页查询，点击改变size时
    @GetMapping("/getPage2/{size}")
    public PageVO getPage2(PageVO pageVO, @PathVariable("size") Long size) {
//        public PageVO getPage2(PageVO pageVO, Long size){
        PageVO pages = fruitService.getPages2(pageVO, size);
        return pages;
    }

    //分页查询，点击改变当前页面时
//    @GetMapping("/getPage3/{current}")
//    public PageVO getPage3(PageVO pageVO,@PathVariable("current") Long current){
//        PageVO pages = fruitService.getPages3(pageVO,current);
//        return pages;
//    }

    //分页查询，点击改变当前页面时
    @GetMapping("/getPage3")
    public PageVO getPage3(PageVO pageVO, HttpServletRequest request) {
        //得到前端传的参数
        String current = request.getParameter("current");
        long c = Long.parseLong(current);
        String size = request.getParameter("size");
        long s = Long.parseLong(size);

        PageVO pages = fruitService.getPages3(pageVO, c,s);
        return pages;
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteById(@PathVariable("id") Integer id) {
        return fruitService.removeById(id);
    }

    @GetMapping("/queryById/{id}")
    public Fruit queryById(@PathVariable("id") Integer id) {
        return fruitService.getById(id);
    }

    @PutMapping("/updataById")
    public Boolean updateById(@RequestBody Fruit fruit) {
        return fruitService.updateById(fruit);
    }

    @PutMapping("/add")
    public Boolean add(@RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @GetMapping("/getbarVO")
    public BarVO barVO() {
        return fruitService.queryAllBarVO();
    }

    @GetMapping("/getpieVO")
    public List<PieVO> pieVO() {
        return fruitService.queryAllPieVO();
    }
}

