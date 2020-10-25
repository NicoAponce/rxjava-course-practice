package lol.demo.api.pokemon.lolapipokemon.entity;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hero {

    @Id
    public String id;
    public String name;
    public String power;
    public String weakness;
    public String origin;
}
