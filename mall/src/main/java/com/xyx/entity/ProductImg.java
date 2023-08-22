package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/21 021 21:45
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImg {
    private String id;
    private String itemId;
    private String url;
    private Integer sort;
    private Integer isMain;
    private Date createdTime;
    private Date updatedTime;
}
