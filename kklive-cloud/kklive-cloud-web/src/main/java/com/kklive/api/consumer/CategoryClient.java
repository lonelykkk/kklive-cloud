package com.kklive.api.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2025/2/9 19:21
 * @Version V1.0
 */
@FeignClient(name = "kklive-cloud-admin")
public interface CategoryClient {
    @RequestMapping("/innerApi/loadAllCategory")
    public String loadAllCategory();
}
