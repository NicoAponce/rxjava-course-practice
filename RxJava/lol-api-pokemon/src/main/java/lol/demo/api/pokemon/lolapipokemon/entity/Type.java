package lol.demo.api.pokemon.lolapipokemon.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Type {

    @Id
    public String id;
    public String name;
}
