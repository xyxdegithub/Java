package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 0:50
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductComments {
    private String commId;
    private String productId;
    private String productName;
    private String orderItemId;
    private String userId;
    private Integer isAnonymous;
    private Integer commType;
    private Integer commLevel;
    private String commContent;
    private String commImgs;
    private Date sepcName;
    private Integer replyStatus;
    private String replyContent;
    private Date replyTime;
    private Integer isShow;
}
