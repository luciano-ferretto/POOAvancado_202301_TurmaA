package br.edu.atitus.pooavancado.CadUsuario.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Departamento;
import br.edu.atitus.pooavancado.CadUsuario.repositories.DepartamentoRepository;


public interface DepartamentoService extends GenericService<Departamento, Long, DepartamentoRepository>{
	
	Page<Departamento> findByNome(Pageable pageable, String nome);
}
