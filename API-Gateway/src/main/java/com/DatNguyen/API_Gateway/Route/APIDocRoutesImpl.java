//package com.DatNguyen.API_Gateway.Route;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
//import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.function.RequestPredicates;
//import org.springframework.web.servlet.function.RouterFunction;
//import org.springframework.web.servlet.function.ServerResponse;
//import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;
//
//@Configuration
//public class APIDocRoutesImpl implements APIDocRoutes {
//    @Value("${api-doc.path}")
//    private String apiDocPath;
//
//    @Value("${api-doc.routes[0].id}")
//    private String authAPIDocRoutesId;
//
//    @Value("${api-doc.routes[1].id}")
//    private String subscriptionAPIDocRoutesId;
//
//    @Value("${api-doc.routes[2].id}")
//    private String resumeAPIDocRoutesId;
//
//    @Value("${api-doc.routes[0].url}")
//    private String authAPIDocRoutesURI;
//
//    @Value("${api-doc.routes[1].url}")
//    private String subscriptionAPIDocRoutesURI;
//
//    @Value("${api-doc.routes[2].url}")
//    private String resumeAPIDocRoutesURI;
//
//    @Override
//    public RouterFunction<ServerResponse> authAPiDocRoutes() {
//        return GatewayRouterFunctions.route(authAPIDocRoutesId)
//                .route(RequestPredicates.path(apiDocPath),
//                        HandlerFunctions.http(authAPIDocRoutesURI))
//                .filter(setPath(apiDocPath))
//                .build();
//    }
//
//    @Override
//    public RouterFunction<ServerResponse> subscriptionAPIDocRoutes() {
//        return GatewayRouterFunctions.route(subscriptionAPIDocRoutesId)
//                .route(RequestPredicates.path(apiDocPath),
//                        HandlerFunctions.http(subscriptionAPIDocRoutesURI))
//                .filter(setPath(apiDocPath))
//                .build();
//    }
//
//    @Override
//    public RouterFunction<ServerResponse> resumeAPIDocRoutes() {
//        return GatewayRouterFunctions.route(resumeAPIDocRoutesId)
//                .route(RequestPredicates.path(apiDocPath),
//                        HandlerFunctions.http(resumeAPIDocRoutesURI))
//                .filter(setPath(apiDocPath))
//                .build();
//    }
//}
