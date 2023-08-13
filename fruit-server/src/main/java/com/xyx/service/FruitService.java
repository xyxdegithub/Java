package com.xyx.service;

import com.xyx.entity.Fruit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xyx.vo.PageVO;
import com.xyx.vo.BarVO;
import com.xyx.vo.PieVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xyx
 * @since 2023-08-12
 */
public interface FruitService extends IService<Fruit> {

    public BarVO queryAllBarVO();

    public List<PieVO> queryAllPieVO();

    public PageVO getPages(PageVO pageVO);

    //针对前端点击改变size时
    public PageVO getPages2(PageVO pageVO,Long size);

    //针对前端点击改变当前页面时
//    public PageVO getPages3(PageVO pageVO,Long current);
    public PageVO getPages3(PageVO pageVO,Long current,Long size);

}
