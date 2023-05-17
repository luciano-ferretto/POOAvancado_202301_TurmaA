package br.edu.atitus.pooavancado.CadUsuario.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericService<TEntidade, TID, TRepository extends JpaRepository<TEntidade, TID>> {

	TRepository getRepository();
	
	default TEntidade save(TEntidade objeto) throws Exception {
		return getRepository().save(objeto);
	}

	default Optional<TEntidade> findById(TID id) {
		return getRepository().findById(id);
	}

	default void deleteById(TID id) {
		getRepository().deleteById(id);;
	}

	
}
