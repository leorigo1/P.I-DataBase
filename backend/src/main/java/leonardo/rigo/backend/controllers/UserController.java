package leonardo.rigo.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardo.rigo.backend.entities.User;
import leonardo.rigo.backend.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	 @GetMapping
	 public ResponseEntity<String> getUser() {
		 return ResponseEntity.ok("sucesso!");
	 }
}
