package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 0:42
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private String orderId;
    private String userId;
    private String untitled;
    private String receiverName;
    private String receiverMobile;
    private String receiverAddress;
    private BigDecimal totalAmount;
    private Integer actualAmount;
    private Integer payType;
    private String orderRemark;
    private String status;
    private String deliveryType;
    private String deliveryFlowId;
    private BigDecimal orderFreight;
    private Integer deleteStatus;
    private Date createTime;
    private Date updateTime;
    private Date payTime;
    private Date deliveryTime;
    private Date flishTime;
    private Date cancelTime;
    private Integer closeType;
}
