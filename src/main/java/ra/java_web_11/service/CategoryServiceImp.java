package ra.java_web_11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.java_web_11.model.Category;
import ra.java_web_11.repository.CategoryRepository;

import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void addCategory(Category category) {
        categoryRepository.addCategory(category);
    }

    @Override
    public void updateCategory(int id, String categoryName, boolean status) {
        categoryRepository.updateCategory(id, categoryName, status);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteCategory(id);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }
}
