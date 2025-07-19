package com.cognizant.api_gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Global filter that logs incoming HTTP request details.
 */
@Component
public class LogFilter implements GlobalFilter {
    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);
    private static final String LOG_FORMAT = "Request: method={}, uri={}, headers={}";

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain filterChain) {
        logRequestDetails(serverWebExchange.getRequest());
        return filterChain.filter(serverWebExchange);
    }

    private void logRequestDetails(ServerHttpRequest request) {
        logger.info(LOG_FORMAT,
                request.getMethod(),
                request.getURI(),
                request.getHeaders());
    }
}