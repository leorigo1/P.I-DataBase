package leonardo.rigo.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardo.rigo.backend.entities.User;
import leonardo.rigo.backend.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	 @PostMapping("/login-google")
	    public User loginGoogle(@RequestBody User usuario) {
	        return userService.loginGoogle(usuario);
	    }
}
