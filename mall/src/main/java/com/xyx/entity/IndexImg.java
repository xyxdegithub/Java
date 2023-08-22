package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/21 021 19:51
 * @description: 主页轮播图图片实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexImg {
    private String imgId;
    private String imgUrl;
    private String imgBgColor;
    private String prodId;
    private String categoryId;
    private Integer indexType;
    private Integer seq;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
