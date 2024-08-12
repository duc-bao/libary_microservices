//package ducbao.vn.apigateway.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//
//import java.util.List;
//
//@Component
//@Slf4j
//public class AuthenticationFilter implements GlobalFilter, Ordered {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        log.info("AuthenticationFilter .....");
//        List<String> authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);
//        if(CollectionUtils.isEmpty(authHeader)){
//            return unauthorized(exchange.getResponse());
//        }
//        String token = authHeader.getFirst().replace("Bearer ", "");
//        log.info("AuthenticationFilter token : {}", token);
//
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return -1;
//    }
//    Mono<Void> unauthorized(ServerHttpResponse httpServerResponse){
//        String body = "Unthenticated";
//        httpServerResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
//        return httpServerResponse.writeWith(Mono.just(httpServerResponse.bufferFactory().wrap(body.getBytes())));
//    }
//}
