package com.xyx.service;

import com.xyx.entity.ProductComments;
import com.xyx.mapper.GeneralMapper;
import com.xyx.vo.ResultVO;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 11:38
 * @description: TODO
 */
public interface ProductCommontsService {
//   根据商品id实现评论的分页查询
    public ResultVO listCommontsByProductId(String productId, int pageNum, int limit);

//    根据商品ID统计当前商品的评价信息
    public ResultVO getCommentsCountByProductId(String productId);
}
