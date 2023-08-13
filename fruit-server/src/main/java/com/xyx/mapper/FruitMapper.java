package com.xyx.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xyx.entity.Fruit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xyx
 * @since 2023-08-12
 */
@Mapper
@Repository
public interface FruitMapper extends BaseMapper<Fruit> {



}
