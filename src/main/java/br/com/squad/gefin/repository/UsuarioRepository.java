package br.com.squad.gefin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.squad.gefin.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{


    /**
	 * Metodo utilizado para selecionar apenas um Usuario pelo email (Chave unica)
	 * 
	 * @param email
	 * @return Optional com Usuario unico
	 * @since 1.0
	 * @author Carlos Henrique.
	 */
    Optional<Usuario> findByEmail (String email);
    
}
