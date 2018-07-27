package com.zlikun.sc.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zlikun.sc.dto.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟一个数据接口
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/8/15 14:13
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @GetMapping("/{userId}")
    public Object get(@PathVariable long userId) {
        // Mock Data
        log.info("Mock一个用户");
        return new UserInfo(userId, "用户-" + userId, "12100000001");
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody UserInfo user) {
        log.info("创建一个用户：{}", user);
        // Mock Data
        user.setUserId(10000L);
        return ResponseEntity.ok(user.getUserId());
    }

    @DeleteMapping("/{userId}")
    public void remove(@PathVariable long userId) {
        log.info("删除用户：{}", userId);
    }

    @PutMapping("/{userId}")
    public void update(@PathVariable long userId, @RequestBody UserInfo user) {
        user.setUserId(userId);
        log.info("更新用户：{}", user);
    }

    /**
     * 模拟搜索用户API
     *
     * @return
     */
    @GetMapping("/search")
    @HystrixCommand(fallbackMethod = "searchFailure")
    public List<UserInfo> search() {
        log.info("搜索用户");
        throw new RuntimeException("模拟出错情况");
    }

    public List<UserInfo> searchFailure() {
        log.info("触发熔断，调用替代逻辑");
        return new ArrayList<>();
    }

}
