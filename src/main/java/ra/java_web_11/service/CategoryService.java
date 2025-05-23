package ra.java_web_11.service;

import ra.java_web_11.model.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);

    void updateCategory(int id, String categoryName, boolean status);

    void deleteCategory(int id);

    Category findById(int id);

    List<Category> getAllCategories();
}
