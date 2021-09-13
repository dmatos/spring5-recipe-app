package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/recipe")
@Controller
@Slf4j
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/list"})
    public String listRecipes(Model model){
        model.addAttribute("recipes", recipeService.findAll());
        return "recipe/list";
    }

    @RequestMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        model.addAttribute("recipe", recipeService.findById(id));
        return "recipe/recipe";
    }
}
