package br.com.datasource.api.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.datasource.domain.model.book.Livro;
import br.com.datasource.domain.model.user.Usuario;
import br.com.datasource.domain.repository.book.Livros;
import br.com.datasource.domain.repository.user.Usuarios;

@RestController
public class TestDatasourceController {
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private Livros livros;

	@PostConstruct
	public void addData2DB() {
		usuarios.saveAll(Stream.of(new Usuario(744, "John"), new Usuario(455, "Pitter")).collect(Collectors.toList()));
		livros.saveAll(Stream.of(new Livro(111, "Core Java"), new Livro(222, "Spring Boot")).collect(Collectors.toList()));
	}

	@GetMapping("usuarios")
	public List<Usuario> buscarUsuario() {
		return usuarios.findAll();
	}

	@GetMapping("livros")
	public List<Livro> buscarLivro() {
		return livros.findAll();
	}

}
