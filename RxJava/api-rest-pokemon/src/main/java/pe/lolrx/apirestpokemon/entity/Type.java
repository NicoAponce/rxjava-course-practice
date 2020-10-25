package pe.lolrx.apirestpokemon.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Type {

    @Id
    public String id;
    public String name;
}
