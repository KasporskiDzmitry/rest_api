package by.dz.test.test_project.dto;

import lombok.Data;

@Data
public class ProductRatingRequest {
    private Long product_id;
    private Long user_id;
    private int rating;
}
