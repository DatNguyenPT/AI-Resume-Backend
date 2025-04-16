package com.DatNguyen.API_Gateway.Route;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;

@Configuration
public class AuthServiceRoutesImpl implements AuthServiceRoutes {
    @Value("${spring.url[0].uri}")
    private String authURL;

    @Bean
    public RouterFunction<ServerResponse> authServiceRoutes() {
        return org.springframework.web.servlet.function.RouterFunctions
                .route(RequestPredicates.path("/auth/register")
                                .and(RequestPredicates.method(HttpMethod.POST)),
                        this::handleRegister)
                .andRoute(RequestPredicates.path("/auth/login")
                                .and(RequestPredicates.method(HttpMethod.POST)),
                        this::handleLogin)
                .andRoute(RequestPredicates.path("/auth/logout")
                                .and(RequestPredicates.method(HttpMethod.POST)),
                        this::handleLogout)
                .andRoute(RequestPredicates.path("/auth/otp")
                                .and(RequestPredicates.method(HttpMethod.GET)),
                        this::handleOtp)
                .andRoute(RequestPredicates.path("/user/{userID}")
                                .and(RequestPredicates.method(HttpMethod.GET)),
                        this::handleUserID);
    }

    private ServerResponse handleRegister(ServerRequest request) {
        URI redirectUri = URI.create(authURL + "/auth/register");
        return ServerResponse.permanentRedirect(redirectUri).build();
    }

    private ServerResponse handleLogin(ServerRequest request) {
        URI redirectUri = URI.create(authURL + "/auth/login");
        return ServerResponse.permanentRedirect(redirectUri).build();
    }

    private ServerResponse handleLogout(ServerRequest request) {
        URI redirectUri = URI.create(authURL + "/auth/logout");
        return ServerResponse.permanentRedirect(redirectUri).build();
    }

    private ServerResponse handleOtp(ServerRequest request) {
        URI redirectUri = URI.create(authURL + "/auth/otp");
        return ServerResponse.permanentRedirect(redirectUri).build();
    }

    private ServerResponse handleUserID(ServerRequest request) {
        String userID = request.pathVariable("userID");
        URI redirectUri = URI.create(authURL + "/user/" + userID);
        return ServerResponse.permanentRedirect(redirectUri).build();
    }
}