package pe.rx.person.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "profession")
public class Profession {

    @Id
    public String id;

    public String name;

}
