package ra.java_web_11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.java_web_11.model.Category;
import ra.java_web_11.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "category-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-add";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute("category") Category category, Model model) {
        try {
            categoryService.addCategory(category);
            return "redirect:/categories";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "category-add";
        }
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") int id, Model model) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return "redirect:/categories";
        }
        model.addAttribute("category", category);
        return "category-edit";
    }
    @PostMapping("/edit")
    public String updateCategory(@Valid @ModelAttribute("category") Category category,
                                 BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            return "category-edit";
        }

        try {
            categoryService.updateCategory(category.getId(), category.getCategoryName(), category.isStatus());
            return "redirect:/categories";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "category-edit";
        }
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam("id") int id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }


}