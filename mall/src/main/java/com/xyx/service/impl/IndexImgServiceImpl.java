package com.xyx.service.impl;

import com.xyx.entity.IndexImg;
import com.xyx.mapper.IndexImgMapper;
import com.xyx.service.IndexImgService;
import com.xyx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ResStatus;

import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/21 021 20:01
 * @description: 处理业务流程
 */
@Service
public class IndexImgServiceImpl implements IndexImgService {

    @Autowired
    private IndexImgMapper indexImgMapper;

    @Override
    public ResultVO listIndexImgs() {
        List<IndexImg> indexImgs = indexImgMapper.listIndexImgs();
//        System.out.println(indexImgs.get(0));
        if (indexImgs.size()==0){
            return new ResultVO(ResStatus.NO,"fail",null);
        }else {
            return new ResultVO(ResStatus.OK,"success",indexImgs);
        }
    }
}
