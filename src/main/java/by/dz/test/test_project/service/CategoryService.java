package by.dz.test.test_project.service;

import by.dz.test.test_project.entity.Category.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Long id);

    List<Category> getCategories(int page, int size, String direction, String sortBy);

    Category saveCategory(Category category);

    Category updateCategory(Category category, Long id);

    void deleteCategoryById(Long id);
}
