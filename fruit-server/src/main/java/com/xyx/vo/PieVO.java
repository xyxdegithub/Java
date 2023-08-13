package com.xyx.vo;

import lombok.Data;

import java.util.Map;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/12 012 22:27
 * @description: TODO
 */
@Data
public class PieVO {
    private Integer value;
    private Map<String,String> ItemValue;
    private String name;
}
