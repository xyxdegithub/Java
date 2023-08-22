package com.xyx.service;

import com.xyx.vo.ResultVO;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 0:25
 * @description: TODO
 */
public interface ProductService {
    public ResultVO listRecommendProducts();

    public ResultVO getProductBasicInfo(String productId);

    public ResultVO getProductParamsById(String productId);

    public ResultVO getProductsByCategoryId(int categoryId,int pageNum,int limit);

    public ResultVO listBrands(int categoryId);

    public ResultVO searchProduct(String kw,int pageNum,int limit);

    public ResultVO listBrands(String kw);
}
