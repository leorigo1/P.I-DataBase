package leonardo.rigo.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import leonardo.rigo.backend.entities.User;
import leonardo.rigo.backend.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User loginGoogle(@RequestBody User usuario) {
        // Se o usuário já existe, apenas retorna ele
        return userRepository.findByEmail(usuario.getEmail())
                .orElseGet(() -> userRepository.save(usuario));
    }
	
}
