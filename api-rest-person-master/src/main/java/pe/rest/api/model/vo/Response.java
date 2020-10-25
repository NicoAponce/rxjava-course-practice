package pe.rest.api.model.vo;

import java.util.List;

public class Response {

	public Boolean ok;
    public List<String> errors;
    public Object result;

    public Response() {

    }

    public Response(Boolean ok, List<String> errors, Object result) {
        this.ok = ok;
        this.errors = errors;
        this.result = result;
    }
}
