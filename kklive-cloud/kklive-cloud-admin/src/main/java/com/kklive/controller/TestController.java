package com.kklive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2025/2/9 9:56
 * @Version V1.0
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "kklive微服务项目拆分admin";
    }
}
