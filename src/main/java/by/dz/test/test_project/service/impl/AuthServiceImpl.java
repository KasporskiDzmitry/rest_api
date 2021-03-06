package by.dz.test.test_project.service.impl;

import by.dz.test.test_project.entity.User.User;
import by.dz.test.test_project.repository.UserRepository;
import by.dz.test.test_project.security.JwtTokenProvider;
import by.dz.test.test_project.service.AuthService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("authService")
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;
    private PasswordEncoder passwordEncoder;


    public AuthServiceImpl(UserRepository userRepository, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Map<String, String> login(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User doesn't exists");
        }

        String token = jwtTokenProvider.createToken(email, user.getRole().name());
        return generateMapForResponse(email, token, user.getRole().name(), user.getId(), user.getFirstName() + " " + user.getLastName());
    }

    private Map<String, String> generateMapForResponse(String email, String token, String role, Long id, String name) {
        Map<String, String> response = new HashMap<>();
        response.put("email", email);
        response.put("token", token);
        response.put("role", role);
        response.put("userId", String.valueOf(id));
        response.put("name", name);

        return response;
    }
}
