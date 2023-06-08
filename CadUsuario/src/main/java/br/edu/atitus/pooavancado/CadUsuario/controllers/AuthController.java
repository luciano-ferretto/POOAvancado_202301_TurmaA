package br.edu.atitus.pooavancado.CadUsuario.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.CadUsuario.comum.JwtUtils;
import br.edu.atitus.pooavancado.CadUsuario.controllers.payloads.LoginPayload;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtUtils jwtUtils;
	public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtUtils = jwtUtils;
	}


	@PostMapping("/signin")
	public ResponseEntity<Object> signin(@RequestBody LoginPayload login) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String tokenJwt = jwtUtils.generateTokenFromEmail(login.getEmail());
		return ResponseEntity.ok().body(tokenJwt);
		
	}

}
