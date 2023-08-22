package com.xyx.mapper;

import com.xyx.entity.Product;
import com.xyx.vo.ProductVO;
import com.xyx.vo.ResultVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 0:22
 * @description: TODO
 */
@Mapper
@Repository
public interface ProductMapper extends GeneralMapper<Product>{
    public List<ProductVO> selectRecommendProducts();

    public List<ProductVO> selectTop6ByCategory(int cid);

    public List<ProductVO> selectProductByCategoryId(@Param("cid") int cid,
                                                     @Param("start") int start,
                                                     @Param("limit") int limit);
    public List<String> selectBrandByCategoryId(int cid);


    public List<ProductVO> selectProductByKeyword(@Param("kw") String keyword,
                                                  @Param("start") int start,
                                                  @Param("limit") int limit);

    public List<String> selectBrandByKeyword(String kw);
}
