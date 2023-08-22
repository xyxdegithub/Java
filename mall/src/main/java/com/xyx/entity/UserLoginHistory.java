package com.xyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 0:57
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginHistory {
    private Integer id;
    private String area;
    private String country;
    private String userId;
    private String ip;
    private String loginTime;
}
