package pe.rx.mini.person.entity;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
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
