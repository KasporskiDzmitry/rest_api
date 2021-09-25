package by.dz.test.test_project.dto;

import by.dz.test.test_project.entity.User.Address;
import by.dz.test.test_project.entity.ProductRating.ProductRating;
import by.dz.test.test_project.entity.User.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String status;
    private Address address;
    private List<ProductRating> ratings;
}
