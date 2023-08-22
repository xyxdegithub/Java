package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/21 021 21:48
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSku {
    private String skuId;
    private String productId;
    private String skuName;
    private String skuImg;
    private String untitled;
    private Integer originalPrice;
    private Integer sellPrice;
    private BigDecimal discounts;
    private Integer stock;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
