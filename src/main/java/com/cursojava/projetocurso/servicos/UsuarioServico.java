package com.cursojava.projetocurso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.projetocurso.entidades.Usuario;
import com.cursojava.projetocurso.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> encontrarTudo(){
		return repositorio.findAll();
	}
	
	public Usuario encontrarPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
	
	public Usuario atualizar(Long id, Usuario obj) {
		Usuario entidade = repositorio.getById(id); 
		atualizarDados(entidade, obj);
		return repositorio.save(entidade);
	}

	private void atualizarDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setFone(obj.getFone());
	}

}
