package com.xyx.mapper;

import com.xyx.entity.UserAddr;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 2:21
 * @description: TODO
 */
@Mapper
@Repository
public interface UserAddrMapper extends GeneralMapper<UserAddr> {
}
