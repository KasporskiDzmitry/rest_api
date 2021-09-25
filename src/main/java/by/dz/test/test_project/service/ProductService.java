package by.dz.test.test_project.service;


import by.dz.test.test_project.entity.Product.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(int page, int size, String direction, String sortBy);

    Product getProductById(Long id);

    Product saveProduct(Product product);

    Product updateProduct(Product product, Long id);

    void deleteProductById(Long id);

}
