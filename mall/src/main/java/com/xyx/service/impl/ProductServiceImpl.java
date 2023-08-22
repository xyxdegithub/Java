package com.xyx.service.impl;

import com.xyx.entity.Product;
import com.xyx.entity.ProductImg;
import com.xyx.entity.ProductParams;
import com.xyx.entity.ProductSku;
import com.xyx.mapper.ProductImgMapper;
import com.xyx.mapper.ProductMapper;
import com.xyx.mapper.ProductParamsMapper;
import com.xyx.mapper.ProductSkuMapper;
import com.xyx.service.ProductService;
import com.xyx.vo.ProductVO;
import com.xyx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import utils.PageUtil;
import utils.ResStatus;

import java.util.HashMap;
import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 0:25
 * @description: TODO
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductImgMapper productImgMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private ProductParamsMapper productParamsMapper;
    @Override
    public ResultVO listRecommendProducts() {
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();

        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", productVOS);
        return resultVO;
    }

    @Override
    public ResultVO getProductBasicInfo(String productId) {
        //1.商品基本信息
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        criteria.andEqualTo("productStatus",1);//状态为1表示上架商品
        List<Product> products = productMapper.selectByExample(example);
        if(products.size()>0){
            //2.商品图片
            Example example1 = new Example(ProductImg.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("itemId",productId);
            List<ProductImg> productImgs = productImgMapper.selectByExample(example1);
            //3.商品套餐
            Example example2 = new Example(ProductSku.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("productId",productId);
            criteria2.andEqualTo("status",1);
            List<ProductSku> productSkus = productSkuMapper.selectByExample(example2);

            HashMap<String,Object> basicInfo = new HashMap<>();
            basicInfo.put("product",products.get(0));
            basicInfo.put("productImgs",productImgs);
            basicInfo.put("productSkus",productSkus);
            return new ResultVO(ResStatus.OK,"success",basicInfo);
        }else{
            return new ResultVO(ResStatus.NO,"查询的商品不存在！",null);
        }
    }

    @Override
    public ResultVO getProductParamsById(String productId) {
        Example example = new Example(ProductParams.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        List<ProductParams> productParams = productParamsMapper.selectByExample(example);
        if(productParams.size()>0){
            return new ResultVO(ResStatus.OK,"success",productParams.get(0));
        }else{
            return new ResultVO(ResStatus.NO,"此商品可能为三无产品",null);
        }
    }

    @Override
    public ResultVO getProductsByCategoryId(int categoryId, int pageNum, int limit) {
        //1.查询分页数据
        int start = (pageNum-1)*limit;
        List<ProductVO> productVOS = productMapper.selectProductByCategoryId(categoryId, start, limit);
        //2.查询当前类别下的商品的总记录数
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryId",categoryId);
        int count = productMapper.selectCountByExample(example);
        //3.计算总页数
        int pageCount = count%limit==0? count/limit : count/limit+1;
        //4.封装返回数据
        PageUtil<ProductVO> pageHelper = new PageUtil<>(count, pageCount, productVOS);
        return new ResultVO(ResStatus.OK,"SUCCESS",pageHelper);
    }

    @Override
    public ResultVO listBrands(int categoryId) {
        List<String> brands = productMapper.selectBrandByCategoryId(categoryId);
        return new ResultVO(ResStatus.OK,"success",brands);
    }

    @Override
    public ResultVO searchProduct(String kw, int pageNum, int limit) {
        //1.查询搜索结果
        kw = "%"+kw+"%";
        int start = (pageNum-1)*limit;
        List<ProductVO> productVOS = productMapper.selectProductByKeyword(kw, start, limit);

        //2.查询总记录数
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("productName",kw);
        int count = productMapper.selectCountByExample(example);

        //3.计算总页数
        int pageCount = count%limit==0? count/limit:count/limit+1;

        //4.封装，返回数据
        PageUtil<ProductVO> pageHelper = new PageUtil<>(count, pageCount, productVOS);
        ResultVO resultVO = new ResultVO(ResStatus.OK, "SUCCESS", pageHelper);
        return resultVO;
    }

    @Override
    public ResultVO listBrands(String kw) {
        kw = "%"+kw+"%";
        List<String> brands = productMapper.selectBrandByKeyword(kw);
        return new ResultVO(ResStatus.OK,"SUCCESS",brands);
    }
}
