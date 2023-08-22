package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 0:56
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddr {
    private String addrId;
    private String userId;
    private String receiverName;
    private String receiverMobile;
    private String province;
    private String city;
    private String area;
    private String addr;
    private String postCode;
    private Integer status;
    private Integer commonAddr;
    private Date createTime;
    private Date updateTime;
}
