package com.xyx.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 1:53
 * @description: TODO
 */

public interface GeneralMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
