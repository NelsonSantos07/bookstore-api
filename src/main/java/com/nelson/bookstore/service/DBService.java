package com.nelson.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelson.bookstore.domain.Categoria;
import com.nelson.bookstore.domain.Livro;
import com.nelson.bookstore.repositories.CategoriaRepository;
import com.nelson.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção", "Livros de Ficção");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");
		
		Livro l1 =  new Livro(null, "Clean code", "Robert Martin", "Loren ipsum", cat1);
		Livro l2 =  new Livro(null, "Engenharia de Software", "Louis V", "Loren ipsum", cat1);
		Livro l3 =  new Livro(null, "The time Machine", "H.G. Wells", "Loren ipsum", cat2);
		Livro l4 =  new Livro(null, "The War od the Worlds", "H.G. Wells", "Loren ipsum", cat2);
		Livro l5 =  new Livro(null, "I, Robot", "Isaac Asimov", "Loren ipsum", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat1.getLivros().addAll(Arrays.asList(l3,l4,l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
		
		
		
		
		
	}

	

}
