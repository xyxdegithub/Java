package com.xyx.service;

import com.xyx.entity.ShoppingCart;
import com.xyx.vo.ResultVO;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 12:01
 * @description: TODO
 */
public interface ShoppingCartService {
    public ResultVO addShoppingCart(ShoppingCart cart);

    public ResultVO listShoppingCartsByUserId(int userId);

    public ResultVO updateCartNum(int cartId,int cartNum);

    public ResultVO listShoppingCartsByCids(String cids);
}
