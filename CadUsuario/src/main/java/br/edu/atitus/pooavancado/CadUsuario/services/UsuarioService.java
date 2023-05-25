package br.edu.atitus.pooavancado.CadUsuario.services;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;

public interface UsuarioService extends GenericService<Usuario>{
	
	void alteraStatus(long id) throws Exception;

}
