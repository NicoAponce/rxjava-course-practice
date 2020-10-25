package pe.lol.app.apirestpokedex.interfaze.service;

import pe.lol.app.apirestpokedex.model.entity.Generation;
import pe.lol.app.apirestpokedex.model.vo.Response;

public interface IGenerationService {

    Response select();

    Response insert(Generation generation);

    Response get(Long id);

    Response update(Long id, Generation generation);

    Response delete(Long id);
}
