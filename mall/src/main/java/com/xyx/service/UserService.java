package com.xyx.service;

import com.xyx.vo.ResultVO;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 1:12
 * @description: TODO
 */
public interface UserService {
    //用户注册
    public ResultVO userResgit(String name, String pwd);

    //用户登录
    public ResultVO checkLogin(String name, String pwd);
}
