package lol.demo.api.pokemon.lolapipokemon.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Generation {

    @Id
    public String id;
    public String name;
}
