package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 0:40
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private String itemId;
    private String orderId;
    private String productId;
    private String productName;
    private String productImg;
    private String skuId;
    private String skuName;
    private BigDecimal productPrice;
    private Integer buyCounts;
    private BigDecimal totalAmount;
    private Date basketDate;
    private Date buyTime;
    private Integer isComment;
}
