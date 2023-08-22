package com.xyx.mapper;

import com.xyx.entity.ProductComments;
import com.xyx.vo.ProductCommentsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 11:40
 * @description: TODO
 */
@Mapper
@Repository
public interface ProductCommentsMapper extends GeneralMapper<ProductComments>{
    /**
     * 根据商品id分页查询评论信息
     * @param productId 商品ID
     * @param start 起始索引
     * @param limit 查询条数
     * @return
     */
    public List<ProductCommentsVO> selectCommontsByProductId(@Param("productId") String productId,
                                                             @Param("start") int start,
                                                             @Param("limit") int limit);
}
