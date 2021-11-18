package com.daniellima.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.daniellima.cursomc.domain.Cliente;
import com.daniellima.cursomc.dto.ClienteDTO;
import com.daniellima.cursomc.repositorys.ClienteRepository;
import com.daniellima.cursomc.services.exception.DataIntegrityException;
import com.daniellima.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo" + Cliente.class.getName()));

	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		 updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produto");
		}
	}
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	//Paginacao
	public Page<Cliente> findPage(Integer page, Integer linesperpage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesperpage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objetoDto) {
		return new Cliente(objetoDto.getId(), objetoDto.getName(), objetoDto.getEmail(),null, null);
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		
	}
	
	
}



