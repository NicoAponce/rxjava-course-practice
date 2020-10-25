package pe.lol.app.apirestpokedex.model.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "generation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Generation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public Long id;

    @Column(name = "Name")
    public String name;

    @Column(name = "State")
    public boolean state;
}
