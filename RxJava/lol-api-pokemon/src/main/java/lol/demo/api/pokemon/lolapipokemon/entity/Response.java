package lol.demo.api.pokemon.lolapipokemon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    @Builder.Default
    public boolean ok=true;

    @Builder.Default
    public Object error=null;

    @Builder.Default
    public Object result=null;
}
