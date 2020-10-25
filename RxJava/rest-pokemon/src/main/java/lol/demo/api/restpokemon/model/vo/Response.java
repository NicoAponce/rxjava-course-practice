package lol.demo.api.restpokemon.model.vo;

public class Response {
    public Boolean ok;
    public Object errors;
    public Object result;

    public Response(){

    }

    public Response(Boolean ok, Object errors, Object result) {
        this.ok = ok;
        this.errors = errors;
        this.result = result;
    }
}
