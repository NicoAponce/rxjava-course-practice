package pe.lol.app.apirestpokedex.interfaze.service;

import pe.lol.app.apirestpokedex.model.entity.Type;
import pe.lol.app.apirestpokedex.model.vo.Response;

public interface ITypeService {

    Response select();

    Response insert(Type type);

    Response get(Long id);

    Response update(Long id, Type type);

    Response delete(Long id);

}
