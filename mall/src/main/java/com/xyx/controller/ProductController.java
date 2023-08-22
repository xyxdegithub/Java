package com.xyx.controller;

import com.xyx.service.ProductCommontsService;
import com.xyx.service.ProductService;
import com.xyx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 11:08
 * @description: TODO
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCommontsService productCommontsService;

    @GetMapping("/detail-info/{pid}")
//    商品基本信息查询
    public ResultVO getProductBasicInfo(@PathVariable("pid") String pid) {
        return productService.getProductBasicInfo(pid);
    }

    @GetMapping("/detail-params/{pid}")
//    商品参数信息查询
    public ResultVO getProductParams(@PathVariable("pid") String pid) {
        return productService.getProductParamsById(pid);
    }


    @GetMapping("/detail-commonts/{pid}")
//    商品评论信息查询
    public ResultVO getProductCommonts(@PathVariable("pid") String pid, int pageNum, int limit) {
        return productCommontsService.listCommontsByProductId(pid, pageNum, limit);
    }

    @GetMapping("/detail-commontscount/{pid}")
//    商品评价统计查询
    public ResultVO getProductCommontsCount(@PathVariable("pid") String pid){
        return productCommontsService.getCommentsCountByProductId(pid);
    }


    @GetMapping("/listbycid/{cid}")
//    根据类别查询商品
    public ResultVO getProductsByCategoryId(@PathVariable("cid") int cid,int pageNum,int limit){
        return productService.getProductsByCategoryId(cid,pageNum,limit);
    }

    @GetMapping("/listbrands/{cid}")
//    根据类别查询商品品牌
    public ResultVO getBrandsByCategoryId(@PathVariable("cid") int cid){
        return productService.listBrands(cid);
    }

    @GetMapping("/listbykeyword")
//    根据关键字查询商品
    public ResultVO searchProducts(String keyword,int pageNum,int limit){
        return productService.searchProduct(keyword,pageNum,limit);
    }

    @GetMapping("/listbrands-keyword")
//    根据关键字查询商品品牌
    public ResultVO getBrandsByKeyword(String keyword){
        return productService.listBrands(keyword);
    }
}
