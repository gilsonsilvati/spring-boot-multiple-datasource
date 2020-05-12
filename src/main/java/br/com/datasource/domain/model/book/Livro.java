package br.com.datasource.domain.model.book;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "livro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
	
	@Id
	private int id;
	private String nome;

}
