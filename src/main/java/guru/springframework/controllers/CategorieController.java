package guru.springframework.controllers;

import guru.springframework.model.Category;
import guru.springframework.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping("category")
@Controller
public class CategorieController {
    private final CategoryRepository categoryRepository;

    public CategorieController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("{id}")
    public String getRecipes(@PathVariable("id") Long categoryId, Model model){
        Optional<Category> category = categoryRepository.findById(categoryId);

        if(category.isPresent()){
            model.addAttribute("category", category.get());
        }

        return "category/recipes";
    }

    @RequestMapping({"", "/"})
    public String getCategories(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        return "category/list";
    }
}
