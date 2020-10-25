package pe.lol.app.apirestpokedex.model.vo;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Response {

    public boolean ok;

    public Object result;

    public Object error;
}
