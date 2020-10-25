package pe.lolrx.apirestpokemon.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.lolrx.apirestpokemon.entity.Type;

public interface TypeRepository extends ReactiveMongoRepository<Type,String> {
}
