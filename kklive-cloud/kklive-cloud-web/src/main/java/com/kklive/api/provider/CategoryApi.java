package com.kklive.api.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2025/2/9 19:17
 * @Version V1.0
 */
@RestController
public class CategoryApi {

    @RequestMapping("/loadAllCategory")
    public String loadAllCategory() {
        return "这里是admin提供的分类接口";
    }
}
