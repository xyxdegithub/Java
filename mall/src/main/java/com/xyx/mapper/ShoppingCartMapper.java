package com.xyx.mapper;

import com.xyx.entity.ShoppingCart;
import com.xyx.vo.ShoppingCartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 12:03
 * @description: TODO
 */
@Mapper
@Repository
public interface ShoppingCartMapper extends GeneralMapper<ShoppingCart>{
    public List<ShoppingCartVO> selectShopcartByUserId(int userId);

    public int updateCartnumByCartid(@Param("cartId") int cartId,
                                     @Param("cartNum") int cartNum);

    //1,8
    public List<ShoppingCartVO> selectShopcartByCids(List<Integer> cids);

}
