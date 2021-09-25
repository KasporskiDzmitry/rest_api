package by.dz.test.test_project.service.impl;

import by.dz.test.test_project.entity.User.Address;
import by.dz.test.test_project.entity.User.Role;
import by.dz.test.test_project.entity.User.Status;
import by.dz.test.test_project.entity.User.User;
import by.dz.test.test_project.repository.UserRepository;
import by.dz.test.test_project.service.RegistrationService;
import by.dz.test.test_project.util.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {
    private final EmailValidator emailValidator;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String register(User user) {
        boolean isValidEmail = emailValidator.
                test(user.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        User userDAO = userRepository.findByEmail(user.getEmail());

        if (userDAO == null) {
            String encodedPassword = bCryptPasswordEncoder
                    .encode(user.getPassword());
            user.setPassword(encodedPassword);
            user.setAddress(new Address());
            user.setRole(Role.USER);
            user.setStatus(Status.ACTIVE);

            userRepository.save(user);
        } else {
            throw new IllegalStateException("email already taken");
        }

        return "user successfully registered";
    }
}
