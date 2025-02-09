package com.kklive.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2025/2/9 17:59
 * @Version V1.0
 */
@Component
@Slf4j
public class AdminFilter extends AbstractGatewayFilterFactory {
    @Override
    public GatewayFilter apply(Object config) {
        return (((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String rawPath = request.getURI().getRawPath();
            log.info("管理端 rawPath:{}", rawPath);
            // TODO 管理端必须登录才行
            return chain.filter(exchange);
        }));
    }
}
