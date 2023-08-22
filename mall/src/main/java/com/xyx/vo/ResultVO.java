package com.xyx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/21 021 19:55
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {
    private int code;
    private String msg;
    private Object data;
}
