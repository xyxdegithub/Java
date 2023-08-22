package com.xyx.mapper;

import com.xyx.entity.ProductImg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 0:35
 * @description: TODO
 */
@Mapper
@Repository
public interface ProductImgMapper extends GeneralMapper<ProductImg>{

    public List<ProductImg> selectProductImgByProductId(int productId);
}
