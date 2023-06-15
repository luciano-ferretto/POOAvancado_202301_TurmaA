package br.edu.atitus.pooavancado.CadUsuario.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.services.GenericService;
import br.edu.atitus.pooavancado.CadUsuario.services.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController extends GenericController<Usuario>{

	final UsuarioService usuarioService;
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@Override
	GenericService<Usuario> getService() {
		return usuarioService;
	}

	@PatchMapping("/status/{id}")
	public ResponseEntity<Object> alteraStatusUsuario(@PathVariable long id) {
		try {
			usuarioService.alteraStatus(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Status alteado com sucesso para o usuario com Id " + id);
	}

	

}
