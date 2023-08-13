package com.xyx.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/13 013 12:26
 * @description: 分页对象
 */
@Data
public class PageVO {
  //默认值第一页，每页4个,自定义
    private Long current=1L;
    //每页多少应该结合前端页码选择栏
    private Long size=4L;
    private Long totalCount;
    private List data;
}
