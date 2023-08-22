package com.xyx.mapper;

import com.xyx.entity.Orders;
import com.xyx.vo.OrdersVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 12:23
 * @description: TODO
 */
@Mapper
@Repository
public interface OrdersMapper extends GeneralMapper<Orders> {
    public List<OrdersVO> selectOrders(@Param("userId") String userId,
                                       @Param("status") String status,
                                       @Param("start") int start,
                                       @Param("limit") int limit);
}
