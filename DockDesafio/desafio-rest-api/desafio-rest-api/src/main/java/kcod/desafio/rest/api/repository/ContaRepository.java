package kcod.desafio.rest.api.repository;

import kcod.desafio.rest.api.model.ContaModel;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<ContaModel, Integer> {
}
