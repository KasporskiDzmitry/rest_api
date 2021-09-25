package by.dz.test.test_project.dto;

import by.dz.test.test_project.entity.User.Address;
import by.dz.test.test_project.entity.ProductRating.ProductRating;
import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private List<ProductRating> ratings;
}
