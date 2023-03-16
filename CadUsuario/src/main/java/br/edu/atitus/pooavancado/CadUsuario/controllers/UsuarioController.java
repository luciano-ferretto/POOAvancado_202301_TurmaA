package br.edu.atitus.pooavancado.CadUsuario.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Usuario;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController {
	
	List<Usuario> listaUsuarios = new ArrayList<>();
	
	@PatchMapping("/status/{id}")
	public ResponseEntity<Object> alteraStatusUsuario(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body("Status alteado com sucesso para o usuario com Id " + id);
	}
	
	@GetMapping()
	public ResponseEntity<Object> getUsuarios(@RequestParam(required = false) String nome) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.getNome().equals(nome))
				return ResponseEntity.status(HttpStatus.OK).body(usuario);
		}
		return ResponseEntity.status(HttpStatus.OK).body(listaUsuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUsuariobyId(@PathVariable long id) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.getId() == id)
				return ResponseEntity.status(HttpStatus.OK).body(usuario);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
	}
	
	@PostMapping
	public ResponseEntity<Object> postUsuario(@RequestBody Usuario usuario){
		listaUsuarios.add(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}
	
	

}
