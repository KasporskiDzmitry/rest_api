package by.dz.test.test_project.service.impl;

import by.dz.test.test_project.dto.ProductRatingRequest;
import by.dz.test.test_project.entity.Product.Product;
import by.dz.test.test_project.entity.ProductRating.ProductRating;
import by.dz.test.test_project.entity.ProductRating.ProductRatingKey;
import by.dz.test.test_project.entity.User.User;
import by.dz.test.test_project.repository.ProductRatingRepository;
import by.dz.test.test_project.repository.ProductRepository;
import by.dz.test.test_project.repository.UserRepository;
import by.dz.test.test_project.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ProductRatingRepository productRatingRepository;
    private ProductRepository productRepository;

    public UserServiceImpl(UserRepository userRepository, ProductRatingRepository productRatingRepository, ProductRepository productRepository) {
        this.productRatingRepository = productRatingRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getUsers(int page, int size, String direction, String sortBy) {
        Page<User> userPage =  userRepository.findAll(PageRequest.of(page ,size, Sort.Direction.fromString(direction), sortBy));
        return userPage.getContent();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateProfile(User newProfile) {
        return userRepository.findById(newProfile.getId())
                .map(user -> {
                    user.setFirstName(newProfile.getFirstName());
                    user.setLastName(newProfile.getLastName());
                    user.setEmail(newProfile.getEmail());
                    user.setAddress(newProfile.getAddress());
                    user.setRatings(newProfile.getRatings());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newProfile.setId(newProfile.getId());
                    return userRepository.save(newProfile);
                });
    }

    @Override
    public Product rateProduct(ProductRatingRequest request) {
        Product product = productRepository.findById(request.getProduct_id()).get();
        User user = userRepository.findById(request.getUser_id()).get();
        ProductRating rating = new ProductRating();
        ProductRatingKey productRatingKey = new ProductRatingKey();

        productRatingKey.setProduct_id(request.getProduct_id());
        productRatingKey.setUser_id(request.getUser_id());

        rating.setId(productRatingKey);
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(request.getRating());
        ProductRating productRating = productRatingRepository.save(rating);

        return productRepository.findById(productRating.getProduct().getId()).get();
    }

}
