package utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 11:45
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageUtil<T> {
    //总记录数
    private int count;

    //总页数
    private int pageCount;

    //分页数据
    private List<T> list;

}
