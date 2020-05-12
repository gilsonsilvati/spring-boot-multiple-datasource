package br.com.datasource.domain.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.datasource.domain.model.user.Usuario;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Integer> {

}
