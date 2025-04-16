//package com.DatNguyen.API_Gateway.Route;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions;
//import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
//import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.servlet.function.RouterFunction;
//import org.springframework.web.servlet.function.ServerResponse;
//import java.net.URI;
//
//@Configuration
//public class SubscriptionServiceRoutesImpl implements SubscriptionServiceRoutes {
//    @Value("${spring.cloud.gateway.routes[5].id}")
//    private String createID;
//
//    @Value("${spring.cloud.gateway.routes[5].predicates[0]}")
//    private String createPredicate;
//
//    @Value("${spring.url[1].uri}")
//    private String subscriptionURL;
//
//
//    @Override
//    public RouterFunction<ServerResponse> subscriptionServiceCreateRoutes() {
//        return GatewayRouterFunctions.route(createID)
//                .POST(createPredicate, HandlerFunctions.http(subscriptionURL))
//                .filter(CircuitBreakerFilterFunctions.circuitBreaker("authServiceCircuitBreaker",
//                        URI.create("forward:/fallbackRoute")))
//                .build();
//    }
//
//    @Override
//    public RouterFunction<ServerResponse> fallbackRoutes() {
//        return GatewayRouterFunctions.route("fallbackRoute")
//                .POST("/fallbackRoute",
//                        request -> ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE)
//                                .body("Auth service is down"))
//                .build();
//    }
//}
