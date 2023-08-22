package com.xyx.service;

import com.xyx.entity.Orders;
import com.xyx.vo.ResultVO;

import java.sql.SQLException;
import java.util.Map;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 12:10
 * @description: TODO
 */
public interface OrderService {
    public Map<String,String> addOrder(String cids, Orders order) throws SQLException;

    public int updateOrderStatus(String orderId, String status);

    public ResultVO getOrderById(String orderId);

    public void closeOrder(String orderId);

    public ResultVO listOrders(String userId,String status,int pageNum, int limit);
}
