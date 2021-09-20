package br.com.squad.gefin.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.squad.gefin.model.Usuario;
import br.com.squad.gefin.repository.UsuarioRepository;

/**
 * Classe utilizada para validação do usuário no banco de dados.
 * 

 * @since 1.0
 * @author Carlos Henrique.
 */

@Service
public class UserDetailsServiceImplements implements UserDetailsService {
	
	private @Autowired UsuarioRepository repositorio;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuarioEmail = repositorio.findByEmail(email);
		
		if (usuarioEmail.isPresent()) {
			return new UserDetailsImplements(usuarioEmail.get());
		} else {
			throw new UsernameNotFoundException(email + " não encontrado.");
		}
	}

}
