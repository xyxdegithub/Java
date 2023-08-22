package com.xyx.service.impl;

import com.xyx.mapper.CategoryMapper;
import com.xyx.service.CategoryService;
import com.xyx.vo.CategoryVO;
import com.xyx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ResStatus;

import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/21 021 21:53
 * @description: TODO
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ResultVO listCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        for (int i = 0; i < categoryVOS.size(); i++) {
            System.out.println("categoryVO: "+categoryVOS.get(i));
        }
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }

    @Override
    public ResultVO listFirstLevelCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories();
        System.out.println(categoryVOS.get(0));
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }
}
