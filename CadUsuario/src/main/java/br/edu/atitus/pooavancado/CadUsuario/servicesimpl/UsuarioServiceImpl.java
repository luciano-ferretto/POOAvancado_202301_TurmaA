package br.edu.atitus.pooavancado.CadUsuario.servicesimpl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.repositories.UsuarioRepository;
import br.edu.atitus.pooavancado.CadUsuario.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	final UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UsuarioRepository getRepository() {
		return usuarioRepository;
	}
	
	private boolean existsByNomeAndIdNot(String nome, long id) {
		return usuarioRepository.existsByNomeAndIdNot(nome, id);
	}

	@Override
	public Page<Usuario> findByNome(Pageable pageable, String nome) {
		return usuarioRepository.findByNomeContainingIgnoreCase(pageable, nome);
	}

	@Override
	public void alteraStatus(long id) throws Exception {
		if (!usuarioRepository.existsById(id))
			throw new Exception("Não existe usuário com este Id");
		usuarioRepository.alteraStatusById(id);
	}
}
