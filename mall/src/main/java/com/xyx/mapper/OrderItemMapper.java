package com.xyx.mapper;

import com.xyx.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 12:25
 * @description: TODO
 */
@Mapper
@Repository
public interface OrderItemMapper extends GeneralMapper<OrderItem>{
    public List<OrderItem> listOrderItemsByOrderId(String orderId);
}
