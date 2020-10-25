package pe.lolrx.apirestpokemon.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AppConfig {

    @Bean
    public RouterFunction<ServerResponse> router(PokemonHandler handler){
        return RouterFunctions.route(RequestPredicates
                .GET("/lol/pokemon"),handler::select)
                .andRoute(RequestPredicates
                .POST("/lol/pokemon"),handler::insert)
                .andRoute(RequestPredicates
                .GET("/lol/pokemon/{id}"),handler::get)
                .andRoute(RequestPredicates
                .PUT("/lol/pokemon/{id}"),handler::update);
    }

}
