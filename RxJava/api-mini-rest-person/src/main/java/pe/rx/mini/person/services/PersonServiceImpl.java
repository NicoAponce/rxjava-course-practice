package pe.rx.mini.person.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pe.rx.mini.person.entity.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private WebClient webClient;

    @Override
    public Flux<Person> select() {
        return webClient.get().accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .flatMapMany(val ->val.bodyToFlux(Person.class));
    }

    @Override
    public Mono<Person> get(String id) {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("id",id);
        return webClient.get().uri("/{id}",map)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve()
                .bodyToMono(Person.class);
    }

    @Override
    public Mono<Person> insert(Person person) {
        return webClient.post()
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody(person)
                .retrieve()
                .bodyToMono(Person.class);
    }

    @Override
    public Mono<Person> update(Person person, String id) {
        return webClient.put()
                .uri("/{id}", Collections.singletonMap("id",id))
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody(person)
                .retrieve()
                .bodyToMono(Person.class);
    }

    @Override
    public Mono<Void> delete(String id) {
        return webClient.delete().uri("/{id}",Collections.singletonMap("id",id))
                .exchange()
                .then();
    }
}
