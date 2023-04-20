package br.edu.atitus.pooavancado.CadUsuario.services;

import java.util.List;
import java.util.Optional;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;

public interface UsuarioService {
	
	Usuario save(Usuario usuario) throws Exception;
	
	List<Usuario> findByNome(String nome);
	
	Optional<Usuario> findById(long id);
	
	void deleteById(long id);
	
	void alteraStatus(long id);

}
