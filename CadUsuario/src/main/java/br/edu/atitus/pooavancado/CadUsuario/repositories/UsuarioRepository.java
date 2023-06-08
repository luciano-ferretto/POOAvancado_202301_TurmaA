package br.edu.atitus.pooavancado.CadUsuario.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario>{
	
	@Query(value = "update Usuario set status = not status where id = :ident", nativeQuery = true)
	@Modifying
	@Transactional
	void alteraStatusById(@Param("ident") long id);
	
	Optional<Usuario> findByEmail(String email);

}
