package com.nelson.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nelson.bookstore.domain.Categoria;
import com.nelson.bookstore.domain.Livro;
import com.nelson.bookstore.dtos.LivroDTO;
import com.nelson.bookstore.repositories.LivroRepository;
import com.nelson.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findBy(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findBy(id_cat);
		return repository.findAllByCategoria(id_cat);
	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findBy(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findBy(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setNome(obj.getNome());
		newObj.setTexto(obj.getTexto());
		newObj.setTitulo(obj.getTitulo());

	}

	public void delete(Integer id) {
		Livro obj = findBy(id);
		repository.delete(obj);

	}

}
