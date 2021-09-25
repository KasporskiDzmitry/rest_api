package by.dz.test.test_project.controller;

import by.dz.test.test_project.entity.Category.Category;
import by.dz.test.test_project.entity.Product.Product;
import by.dz.test.test_project.service.impl.CategoryServiceImpl;
import by.dz.test.test_project.service.impl.ProductServiceImpl;
import by.dz.test.test_project.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static by.dz.test.test_project.util.Constants.*;
import static by.dz.test.test_project.util.Constants.DEFAULT_SORT_DIRECTION;

@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin")
public class AdminController {
    private CategoryServiceImpl categoryService;
    private ProductServiceImpl productService;
    private UserServiceImpl userService;

    public AdminController(CategoryServiceImpl categoryService, ProductServiceImpl productService, UserServiceImpl userService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
    }

    @PostMapping("/category")
    public ResponseEntity<?> saveCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable Long id) {
        return ResponseEntity.ok(categoryService.updateCategory(category, id));
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok(200);
    }

    @PostMapping("/product")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        return ResponseEntity.ok(productService.updateProduct(product, id));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok(200);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUsers(
            @RequestParam(required = false, defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(required = false, defaultValue = DEFAULT_PAGE_SIZE) int size,
            @RequestParam(required = false, defaultValue = DEFAULT_SORT_BY_FIELD) String sortBy,
            @RequestParam(required = false, defaultValue = DEFAULT_SORT_DIRECTION) String direction) {
        return ResponseEntity.ok(userService.getUsers(page, size, direction, sortBy));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
