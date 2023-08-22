package com.xyx.controller;

import com.xyx.service.UserAddrService;
import com.xyx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 2:17
 * @description: TODO
 */
@RestController
@RequestMapping("/useraddr")
public class UserAddrController {
    @Autowired
    private UserAddrService userAddrService;

    @GetMapping("/list")
    public ResultVO listAddr(Integer userId, @RequestHeader("token") String token) {
        ResultVO resultVO = userAddrService.listAddrsByUid(userId);
        return resultVO;
    }
}
