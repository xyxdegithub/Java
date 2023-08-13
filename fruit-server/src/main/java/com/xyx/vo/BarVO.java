package com.xyx.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/12 012 21:42
 * @description: 对应柱状图
 */
@Data
public class BarVO {
    private List<String> names;
    private List<DataVO> values;
}
