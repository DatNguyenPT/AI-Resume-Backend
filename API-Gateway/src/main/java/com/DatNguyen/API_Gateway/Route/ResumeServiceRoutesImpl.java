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
//
//import java.net.URI;
//
//@Configuration
//public class ResumeServiceRoutesImpl implements ResumeServiceRoutes {
//    @Value("${spring.cloud.gateway.routes[6].id}")
//    private String createID;
//
//    @Value("${spring.cloud.gateway.routes[6].predicates[0]}")
//    private String createPredicate;
//
//    @Value("${spring.url[2].uri}")
//    private String resumeURL;
//
//    @Override
//    public RouterFunction<ServerResponse> resumeServiceCreateRoutes() {
//        return GatewayRouterFunctions.route(createID)
//                .POST(createPredicate, HandlerFunctions.http(resumeURL))
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
//                                .body("Resume service is down"))
//                .build();
//    }
//}
