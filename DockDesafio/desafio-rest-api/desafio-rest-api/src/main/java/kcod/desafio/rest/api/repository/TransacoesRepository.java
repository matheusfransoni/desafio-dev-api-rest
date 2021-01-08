package kcod.desafio.rest.api.repository;

import kcod.desafio.rest.api.model.TransacoesModel;
import org.springframework.data.repository.CrudRepository;

public interface TransacoesRepository extends CrudRepository<TransacoesModel, Integer> {
}
