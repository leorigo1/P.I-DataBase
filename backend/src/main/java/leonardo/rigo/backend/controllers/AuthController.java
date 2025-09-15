package leonardo.rigo.backend.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardo.rigo.backend.DTOs.LoginRequestDTO;
import leonardo.rigo.backend.DTOs.RegisterRequestDTO;
import leonardo.rigo.backend.DTOs.ResponseDTO;
import leonardo.rigo.backend.entities.User;
import leonardo.rigo.backend.enums.Roles;
import leonardo.rigo.backend.repositories.UserRepository;
import leonardo.rigo.backend.security.TokenService;
import leonardo.rigo.backend.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final TokenService tokenService;
	private final UserService userService;
	
	
	public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService, UserService userService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.tokenService = tokenService;
		this.userService = userService;
	}
	
	@PostMapping("/login-google")
    public User loginGoogle(@RequestBody User usuario) {
        return userService.loginGoogle(usuario);
    }
	
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginRequestDTO body) {
		User user = this.userRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
		if(passwordEncoder.matches(body.senha(),user.getSenha())) {
			String token = this.tokenService.generateToken(user);
			return ResponseEntity.ok(new ResponseDTO(user.getName(),token));
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
		
		Optional<User> user = this.userRepository.findByEmail(body.email());
		
		if(user.isEmpty()) {
			User newUser = new User();
			newUser.setSenha(passwordEncoder.encode(body.senha()));
			newUser.setEmail(body.email());
			newUser.setName(body.name());
			newUser.setRole(Roles.USUARIO);
			this.userRepository.save(newUser);
			
			String token = this.tokenService.generateToken(newUser);
			return ResponseEntity.ok(new ResponseDTO(newUser.getName(),token));	
		}
		return ResponseEntity.badRequest().build();	
	}
}