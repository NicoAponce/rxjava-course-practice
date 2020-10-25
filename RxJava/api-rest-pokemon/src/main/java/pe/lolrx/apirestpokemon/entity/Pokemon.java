package pe.lolrx.apirestpokemon.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
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
