package pe.rx.mini.person.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import pe.rx.mini.person.handler.PersonHandler;

@Configuration
public class RouterConfig {

    @Value("${config.base.endpoint}")
    private String url;

    @Bean
    public WebClient addWebPerson() {
        return WebClient.create(url);
    }

    @Bean
    public RouterFunction<ServerResponse> router(PersonHandler handler){
        return RouterFunctions.route(RequestPredicates
                .GET("/rx/person"),handler::select)
                .andRoute(RequestPredicates
                .GET("/rx/person/{id}"),handler::get)
                .andRoute(RequestPredicates
                .POST("/rx/person"),handler::insert)
                .andRoute(RequestPredicates
                .PUT("/rx/person/{id}"),handler::update)
                .andRoute(RequestPredicates
                .DELETE("/rx/person/{id}"),handler::delete);
    }
}
