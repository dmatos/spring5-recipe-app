package guru.springframework.controllers;

import guru.springframework.model.Category;
import guru.springframework.model.Recipe;
import guru.springframework.model.UnityOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnityOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.Set;

@Controller
public class IndexController {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnityOfMeasureRepository unityOfMeasureRepository;

    public IndexController(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnityOfMeasureRepository unityOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unityOfMeasureRepository = unityOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("Mexican");
        Optional<UnityOfMeasure> unityOfMeasure = unityOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is: "+categoryOptional.get().getId());
        System.out.println("UoM Id is: "+unityOfMeasure.get().getId());
        return "index";
    }


}
