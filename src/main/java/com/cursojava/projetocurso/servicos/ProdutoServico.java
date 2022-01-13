package com.cursojava.projetocurso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.projetocurso.entidades.Produto;
import com.cursojava.projetocurso.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServico {
	
	@Autowired
	private ProdutoRepositorio repositorio;
	
	public List<Produto> encontrarTudo(){
		return repositorio.findAll();
	}
	
	public Produto encontrarPorId(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}

}
