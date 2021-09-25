package by.dz.test.test_project.repository;

import by.dz.test.test_project.entity.ProductRating.ProductRating;
import by.dz.test.test_project.entity.ProductRating.ProductRatingKey;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRatingRepository extends JpaRepository<ProductRating, ProductRatingKey> {
}
