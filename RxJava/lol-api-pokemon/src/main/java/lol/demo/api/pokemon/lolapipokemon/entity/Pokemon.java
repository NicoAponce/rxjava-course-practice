package lol.demo.api.pokemon.lolapipokemon.entity;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {

    @Id
    public String id;
    public String name;
    public Type type;
    public Generation generation;
    public String power;
    public String sex;
    public int attack;
    public int defense;
    public int stamina;
    public int cp;
}
