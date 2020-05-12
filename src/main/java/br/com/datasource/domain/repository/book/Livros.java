package br.com.datasource.domain.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.datasource.domain.model.book.Livro;

@Repository
public interface Livros extends JpaRepository<Livro, Integer> {

}
