package com.kklive.controller;

import com.kklive.api.consumer.CategoryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2025/2/9 9:56
 * @Version V1.0
 */
@RestController
public class TestController {

    @Resource
    private CategoryClient categoryClient;
    @GetMapping("/test")
    public String test() {
        return categoryClient.loadAllCategory();
    }
}
