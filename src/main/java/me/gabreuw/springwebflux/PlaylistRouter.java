package me.gabreuw.springwebflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class PlaylistRouter {

    @Bean
    public RouterFunction<ServerResponse> route(PlaylistHandler handler) {
        return RouterFunctions
                .route(
                        GET("playlists").and(accept(APPLICATION_JSON)),
                        handler::findAll
                )
                .andRoute(
                        GET("/playlists/{id}").and(accept(APPLICATION_JSON)),
                        handler::findById
                )
                .andRoute(
                        POST("/playlists").and(accept(APPLICATION_JSON)),
                        handler::save
                );
    }

}
