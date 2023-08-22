package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 0:52
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductParams {
    private String paramId;
    private String productId;
    private String productPlace;
    private String footPeriod;
    private String brand;
    private String factoryName;
    private String factoryAddress;
    private String packagingMethod;
    private String weight;
    private String storageMethod;
    private String eatMethod;
    private Date createTime;
    private Date updateTime;
}
