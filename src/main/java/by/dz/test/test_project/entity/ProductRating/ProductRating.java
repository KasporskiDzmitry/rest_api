package by.dz.test.test_project.entity.ProductRating;

import by.dz.test.test_project.entity.Product.Product;
import by.dz.test.test_project.entity.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_rating")
public class ProductRating {
    @EmbeddedId
    ProductRatingKey id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    @JsonIgnore
    User user;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    @JsonIgnore
    Product product;

    @Column(name = "rating")
    int rating;

    @Override
    public String toString() {
        return "ProductRating{" +
                "id=" + id +
                ", user_id=" + user.getId() +
                ", product_id=" + product.getId() +
                ", rating=" + rating +
                '}';
    }
}
