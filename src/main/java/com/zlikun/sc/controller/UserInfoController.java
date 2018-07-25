package com.zlikun.sc.controller;

import com.zlikun.sc.dto.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟一个数据接口
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/8/15 14:13
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @GetMapping("/{userId}")
    public Object get(@PathVariable long userId) {
        // TODO Mock Data
        return new UserInfo(userId, "用户-" + userId, "12100000001");
    }

}
