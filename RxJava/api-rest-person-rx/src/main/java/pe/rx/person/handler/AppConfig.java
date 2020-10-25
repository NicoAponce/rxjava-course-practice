package pe.rx.person.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AppConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(ProfessionHandler hPro,PersonHandler hPer){
        return RouterFunctions.route(RequestPredicates
        .GET("/api/v2/profession"),hPro::select)
                .andRoute(RequestPredicates
                .GET("/api/v2/profession/{id}"),hPro::get)
                .andRoute(RequestPredicates
                .POST("/api/v2/profession"),hPro::insert)
                .andRoute(RequestPredicates
                .PUT("/api/v2/profession/{id}"),hPro::update)
                .andRoute(RequestPredicates
                .GET("api/v2/person"),hPer::select)
                .andRoute(RequestPredicates
                .GET("/api/v2/person/{id}"),hPer::get)
                .andRoute(RequestPredicates
                .POST("/api/v2/person"),hPer::insert)
                .andRoute(RequestPredicates
                .PUT("/api/v2/person/{id}"),hPer::update)
                .andRoute(RequestPredicates
                .DELETE("/api/v2/person/{id}"),hPer::delete);
    }
}
