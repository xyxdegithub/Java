package com.xyx.service;

import com.xyx.vo.ResultVO;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/21 021 21:53
 * @description: TODO
 */
public interface CategoryService {
    public ResultVO listCategories();

    public ResultVO listFirstLevelCategories();
}
