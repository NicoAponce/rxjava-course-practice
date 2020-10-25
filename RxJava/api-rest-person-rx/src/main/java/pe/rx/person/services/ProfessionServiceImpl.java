package pe.rx.person.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.rx.person.entity.Profession;
import pe.rx.person.repository.ProfessionRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProfessionServiceImpl implements ProfessionService{

    @Autowired
    private ProfessionRepository repository;

    @Override
    public Flux<Profession> select() {
        return repository.findAll();
    }

    @Override
    public Mono<Profession> get(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Profession> insert(Profession profession) {
        return repository.save(profession);
    }
}
