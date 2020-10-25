package pe.rx.person;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import pe.rx.person.entity.Person;
import pe.rx.person.entity.Profession;
import pe.rx.person.services.PersonService;
import pe.rx.person.services.ProfessionService;
import reactor.core.publisher.Flux;

import java.util.Date;

@SpringBootApplication
@Log
public class ApiRestPersonApplication /*implements CommandLineRunner*/ {

    /*@Autowired
    public ProfessionService professionService;

    @Autowired
    public PersonService personService;

    @Autowired
    public ReactiveMongoTemplate mongoTemplate;*/

    public static void main(String[] args) {
        SpringApplication.run(ApiRestPersonApplication.class, args);
        log.info("Hola mundo cruel");
    }


    /*@Override
    public void run(String... args) throws Exception {
        mongoTemplate.dropCollection("profession").subscribe();
        mongoTemplate.dropCollection("person").subscribe();

        Profession doctor = Profession.builder().name("Doctor").build();
        Profession engineer = Profession.builder().name("Engineer").build();
        Profession chef = Profession.builder().name("Chef").build();
        Profession firefighter = Profession.builder().name("Firefighter").build();
        Profession police = Profession.builder().name("Police").build();

        Person p1 = Person.builder().name("Nico").lastName("Aponce").age(24).document("98765433")
                .mail("nico@gmail.com").phone("987654321").sex("Male").createdAt(new Date()).profession(doctor).build();
        Person p2 = Person.builder().name("Jeni").lastName("alvino").age(22).document("72637473")
                .mail("jeni@gmail.com").phone("993747737").sex("Female").createdAt(new Date()).profession(engineer).build();
        Person p3 = Person.builder().name("Carla").lastName("Gomez").age(29).document("73774734")
                .mail("carla@gmail.com").phone("987654321").sex("Female").createdAt(new Date()).profession(chef).build();
        Person p4 = Person.builder().name("Lissa").lastName("Simpson").age(24).document("9876543")
                .mail("lissa@gmail.com").phone("987654321").sex("Female").createdAt(new Date()).profession(firefighter).build();
        Person p5 = Person.builder().name("Luis").lastName("Ramos").age(24).document("9876543")
                .mail("luis@gmail.com").phone("987654321").sex("Male").createdAt(new Date()).profession(police).build();

        Flux.just(doctor, engineer, chef, firefighter, police)
                .flatMap(professionService::insert)
                .doOnNext(val -> {
                    log.info("Created Profession " + val.name);
                }).thenMany(Flux.just(p1, p2, p3, p4, p5))
                .flatMap(personService::insert)
                .subscribe(val -> log.info("Created Person " + val.name + " " + val.lastName));
    }*/
}
