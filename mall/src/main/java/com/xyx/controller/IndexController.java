package com.xyx.controller;

import com.xyx.service.CategoryService;
import com.xyx.service.IndexImgService;
import com.xyx.service.ProductService;
import com.xyx.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/21 021 20:18
 * @description: 首页
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Resource
    private IndexImgService indexImgService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private ProductService productService;

    @GetMapping("/indeximg")
    //首页轮播图
    public ResultVO listIndexImgs() {
        ResultVO resultsVO = indexImgService.listIndexImgs();
        return resultsVO;
    }

    @GetMapping("/category-list")
// 商品分类查询
    public ResultVO listCategory() {
        return categoryService.listCategories();
    }

    @GetMapping("/list-recommends")
    //新品推荐查询
    public ResultVO listRecommends() {
        ResultVO resultVO = productService.listRecommendProducts();
        return resultVO;
    }

    @GetMapping("/category-recommends")
    //分类推荐接口
    public ResultVO listRecommendProductsByCategory(){
        return categoryService.listFirstLevelCategories();
    }
}
