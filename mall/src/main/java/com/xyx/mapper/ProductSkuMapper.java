package com.xyx.mapper;

import com.xyx.entity.ProductSku;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 11:17
 * @description: TODO
 */
@Mapper
@Repository
public interface ProductSkuMapper extends GeneralMapper<ProductSku> {
//    根据商品ID，查询当前商品所有套餐中价格最低的套餐
    public List<ProductSku> selectLowerestPriceByProductId(String productId);
}
