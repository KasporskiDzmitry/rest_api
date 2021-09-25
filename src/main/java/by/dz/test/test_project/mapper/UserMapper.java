package by.dz.test.test_project.mapper;

import by.dz.test.test_project.dto.RegistrationRequest;
import by.dz.test.test_project.dto.UserRequest;
import by.dz.test.test_project.dto.UserResponse;
import by.dz.test.test_project.entity.User.User;
import by.dz.test.test_project.service.RegistrationService;
import by.dz.test.test_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final RegistrationService registrationService;

    private User convertToEntity(UserRequest userRequest) {
        return modelMapper.map(userRequest, User.class);
    }

    private User convertToEntity(RegistrationRequest registrationRequest) {
        return modelMapper.map(registrationRequest, User.class);
    }

    private UserResponse convertToResponseDto(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

    public UserResponse updateProfile(UserRequest userRequest) {
        return convertToResponseDto(userService.updateProfile(convertToEntity(userRequest)));
    }

    public String register(RegistrationRequest registrationRequest) {
        return registrationService.register(convertToEntity(registrationRequest));
    }
}
