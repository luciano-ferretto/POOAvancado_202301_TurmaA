package br.edu.atitus.pooavancado.CadUsuario.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.repositories.UsuarioRepository;

public interface UsuarioService extends GenericService<Usuario, Long, UsuarioRepository>{
	
	Page<Usuario> findByNome(Pageable pageable, String nome);
	
	void alteraStatus(long id) throws Exception;

}
