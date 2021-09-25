package by.dz.test.test_project.entity.ProductRating;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ProductRatingKey implements Serializable {

    @Column(name = "user_id")
    Long user_id;

    @Column(name = "product_id")
    Long product_id;
}
