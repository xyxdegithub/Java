package com.xyx.controller;

import com.xyx.entity.Users;
import com.xyx.service.UserService;
import com.xyx.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/22 022 1:11
 * @description: TODO
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/regist")
    public ResultVO register(@RequestBody Users user) {
        ResultVO resultVO = userService.userResgit(user.getUsername(), user.getPassword());
        return resultVO;

    }

    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String name,
                          @RequestParam(value = "password") String pwd) {
        ResultVO resultVO = userService.checkLogin(name, pwd);
        return resultVO;
    }
}
