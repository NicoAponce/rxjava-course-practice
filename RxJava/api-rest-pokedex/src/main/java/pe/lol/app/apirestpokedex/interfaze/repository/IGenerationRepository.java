package pe.lol.app.apirestpokedex.interfaze.repository;

import pe.lol.app.apirestpokedex.model.dto.GenerationResponse;

import java.util.List;

public interface IGenerationRepository {

    List<GenerationResponse> select();
}
