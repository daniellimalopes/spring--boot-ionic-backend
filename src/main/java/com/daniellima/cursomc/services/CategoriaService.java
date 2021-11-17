package com.daniellima.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.daniellima.cursomc.domain.Categoria;
import com.daniellima.cursomc.dto.CategoriaDTO;
import com.daniellima.cursomc.repositorys.CategoriaRepository;
import com.daniellima.cursomc.services.exception.DataIntegrityException;
import com.daniellima.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo" + Categoria.class.getName()));

	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produto");
		}
	}
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	//Paginacao
	public Page<Categoria> findPage(Integer page, Integer linesperpage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesperpage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO objetoDto) {
		return new Categoria(objetoDto.getId(),objetoDto.getNome());
	}
}
