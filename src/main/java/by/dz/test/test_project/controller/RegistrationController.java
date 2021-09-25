package by.dz.test.test_project.controller;

import by.dz.test.test_project.dto.RegistrationRequest;
import by.dz.test.test_project.mapper.UserMapper;
import by.dz.test.test_project.service.RegistrationService;
import by.dz.test.test_project.service.impl.RegistrationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/registration")
public class RegistrationController {
    private final RegistrationServiceImpl registrationService;
    private final UserMapper userMapper;


    public RegistrationController(RegistrationServiceImpl registrationService, UserMapper userMapper) {
        this.registrationService = registrationService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(userMapper.register(request));
    }
}
