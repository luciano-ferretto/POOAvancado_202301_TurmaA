package br.edu.atitus.pooavancado.CadUsuario.servicesimpl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.CadUsuario.Entities.Departamento;
import br.edu.atitus.pooavancado.CadUsuario.repositories.DepartamentoRepository;
import br.edu.atitus.pooavancado.CadUsuario.services.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	final DepartamentoRepository departamentoRepository;
	
	public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
		super();
		this.departamentoRepository = departamentoRepository;
	}
	
	@Override
	public DepartamentoRepository getRepository() {
		return departamentoRepository;
	}
	
	private boolean existsByNomeAndIdNot(String nome, long id) {
		return departamentoRepository.existsByNomeAndIdNot(nome, id);
	}

	@Override
	public Page<Departamento> findByNome(Pageable pageable, String nome) {
		return departamentoRepository.findByNomeContainingIgnoreCase(pageable, nome);
	}

}
