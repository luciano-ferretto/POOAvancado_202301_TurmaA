package br.edu.atitus.pooavancado.CadUsuario.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;

@Repository
public interface UsuarioRespository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByNomeContainingIgnoreCase(String nome);
	
	List<Usuario> findByEmailContainingIgnoreCase(String email);
}
