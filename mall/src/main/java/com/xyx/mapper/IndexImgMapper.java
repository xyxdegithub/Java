package com.xyx.mapper;

import com.xyx.entity.IndexImg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/21 021 19:55
 * @description: TODO
 */
@Mapper
@Repository
public interface IndexImgMapper {
    //1.查询轮播图信息： 查询status=1 且 按照seq进行排序
    public List<IndexImg> listIndexImgs();
}
