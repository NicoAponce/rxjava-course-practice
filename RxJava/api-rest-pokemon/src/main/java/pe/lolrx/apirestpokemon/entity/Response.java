package pe.lolrx.apirestpokemon.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {

    @Builder.Default
    public boolean ok=true;

    @Builder.Default
    public Object result=null;

    @Builder.Default
    public Object error=null;
}
