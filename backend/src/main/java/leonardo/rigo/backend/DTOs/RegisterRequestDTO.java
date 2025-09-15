package leonardo.rigo.backend.DTOs;

import leonardo.rigo.backend.enums.Roles;

public record RegisterRequestDTO(String name,String email,String senha,Roles role) {

}
