package pe.lol.app.apirestpokedex.interfaze.repository;

import pe.lol.app.apirestpokedex.model.dto.TypeResponse;

import java.util.List;

public interface ITypeRepository {
    List<TypeResponse> select();
}
