package pe.rx.person.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Builder
@Data
@Document(collection = "person")
public class Person {

    @Id
    public String id;

    public String name;

    public String lastName;

    public String document;

    public int age;

    public String phone;

    public String mail;

    public String sex;

    public Date createdAt;

    public Profession profession;

}
