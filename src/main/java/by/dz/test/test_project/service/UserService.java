package by.dz.test.test_project.service;


import by.dz.test.test_project.dto.ProductRatingRequest;
import by.dz.test.test_project.entity.Product.Product;
import by.dz.test.test_project.entity.ProductRating.ProductRating;
import by.dz.test.test_project.entity.User.User;

import java.util.List;

public interface UserService {
    List<User> getUsers(int page, int size, String direction, String sortBy);
    User getUserById(Long id);
    User updateProfile(User newProfile);
    Product rateProduct(ProductRatingRequest request);
}
