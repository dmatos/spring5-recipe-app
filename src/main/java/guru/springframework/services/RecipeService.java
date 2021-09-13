package guru.springframework.services;

import guru.springframework.model.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RecipeService  {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Iterable<Recipe> list(){
        return recipeRepository.findAll();
    }

    public Recipe save(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public Recipe findById(Long id){
        return recipeRepository.findById(id).get();
    }

    public Iterable<Recipe> findAll(){
        return recipeRepository.findAll();
    }

    public List<Recipe> saveAll(List<Recipe> recipes){
        List<Recipe> saved = new LinkedList<>();
        recipeRepository.saveAll(recipes).forEach(saved::add);
        return saved;
    }
}
