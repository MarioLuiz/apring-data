package br.com.arrudamorreira.springdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.arrudamorreira.springdata.orm.Unidade;

@Repository
public interface UnidadeRepository extends CrudRepository<Unidade, Integer>{

}
