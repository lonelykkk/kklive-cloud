package com.kklive.filter;

import com.kklive.entity.enums.ResponseCodeEnum;
import com.kklive.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2025/2/9 17:38
 * @Version V1.0
 */
@Component
@Slf4j
public class GatewayGlobalRequestFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String rawPath = exchange.getRequest().getURI().getRawPath();
        log.info("请求的路径是：{}", rawPath);
        // 不允许网关访问前缀innerApi的接口
        if (rawPath.indexOf("innerApi") != -1) {
            throw new BusinessException(ResponseCodeEnum.CODE_404);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
