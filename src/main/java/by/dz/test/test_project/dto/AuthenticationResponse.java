package by.dz.test.test_project.dto;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String email;
    private String token;
    private String role;
    private String name;
}
