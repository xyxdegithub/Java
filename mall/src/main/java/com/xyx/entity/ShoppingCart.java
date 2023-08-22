package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 0:55
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    private Integer cartId;
    private String productId;
    private String skuId;
    private String userId;
    private String cartNum;
    private String cartTime;
    private BigDecimal productPrice;
    private String skuProps;
}
