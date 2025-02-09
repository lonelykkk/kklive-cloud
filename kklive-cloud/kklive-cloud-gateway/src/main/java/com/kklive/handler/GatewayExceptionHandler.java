package com.kklive.handler;

import com.kklive.entity.enums.ResponseCodeEnum;
import com.kklive.exception.BusinessException;
import com.kklive.utils.JsonUtils;
import com.kklive.entity.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * 全局异常拦截处理器
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2025/2/9 18:50
 * @Version V1.0
 */
@Component
@Slf4j
@Order(-1)
public class GatewayExceptionHandler implements WebExceptionHandler {

    protected static final String STATUC_ERROR = "error";
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable throwable) {
        ServerHttpResponse response = exchange.getResponse();
        ResponseVO responseVO = getResponse(exchange, throwable);
        //设置返回json
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        DataBuffer dataBuffer = response.bufferFactory().wrap(JsonUtils.convertObj2Json(responseVO).getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Mono.just(dataBuffer));
    }

    private ResponseVO getResponse(ServerWebExchange exchange, Throwable throwable) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(STATUC_ERROR);
        if (throwable instanceof ResponseStatusException) {
            ResponseStatusException responseStatusException = (ResponseStatusException) throwable;
            //404
            if (HttpStatus.NOT_FOUND == responseStatusException.getStatus()) {
                responseVO.setCode(ResponseCodeEnum.CODE_404.getCode());
                responseVO.setInfo(ResponseCodeEnum.CODE_404.getMsg());
                return responseVO;
            } else if (HttpStatus.SERVICE_UNAVAILABLE == responseStatusException.getStatus()) {
                //503
                responseVO.setCode(ResponseCodeEnum.CODE_503.getCode());
                responseVO.setInfo(ResponseCodeEnum.CODE_503.getMsg());
                return responseVO;
            } else {
                responseVO.setCode(responseStatusException.getStatus().value());
                responseVO.setInfo(ResponseCodeEnum.CODE_500.getMsg());
                return responseVO;
            }
            //业务异常
        } else if (throwable instanceof BusinessException) {
            BusinessException exception = (BusinessException) throwable;
            responseVO.setCode(exception.getCode());
            responseVO.setInfo(exception.getMessage());
            return responseVO;
        }
        responseVO.setCode(ResponseCodeEnum.CODE_500.getCode());
        responseVO.setInfo(ResponseCodeEnum.CODE_500.getMsg());
        return responseVO;
    }
}
