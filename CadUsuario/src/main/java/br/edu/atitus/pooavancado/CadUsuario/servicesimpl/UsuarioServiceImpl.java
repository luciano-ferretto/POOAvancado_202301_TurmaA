package br.edu.atitus.pooavancado.CadUsuario.servicesimpl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.repositories.GenericRepository;
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
	public GenericRepository<Usuario> getRepository() {
		return usuarioRepository;
	}

	@Override
	public void alteraStatus(long id) throws Exception {
		if (!usuarioRepository.existsById(id))
			throw new Exception("Não existe registro com este Id");
		usuarioRepository.alteraStatusById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email));
		return usuario;
	}

	@Override
	public void validarSave(Usuario objeto) throws Exception {
		UsuarioService.super.validarSave(objeto);
		if (objeto.getPassword().isEmpty())
			throw new Exception("Password não pode ser vazio");
		//Usuario usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//if (usuarioLogado.getId() != objeto.getId() && usuarioLogado.getDepartamento().getId() != 1)
		//	throw new Exception("Você só pode alterar os dados referente a sua conta");
		
		
	}


	

}
