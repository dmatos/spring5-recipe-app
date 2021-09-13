package guru.springframework.bootstrap;

import guru.springframework.model.*;
import guru.springframework.repositories.UnityOfMeasureRepository;
import guru.springframework.services.CategoryService;
import guru.springframework.services.IngredientService;
import guru.springframework.services.RecipeService;
import guru.springframework.services.UnityOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Component
@Slf4j
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeService recipeService;
    private final UnityOfMeasureService unityOfMeasureService;
    private final CategoryService categoryService;
    private final IngredientService ingredientService;

    public DataLoader(
            RecipeService recipeService,
            UnityOfMeasureService unityOfMeasureService,
            CategoryService categoryService,
            IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.unityOfMeasureService = unityOfMeasureService;
        this.categoryService = categoryService;
        this.ingredientService = ingredientService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event){
        recipeService.saveAll(getRecipes());
    }
    
    public List<Recipe> getRecipes() {

        List<Recipe> recipes = new LinkedList<>();

        log.debug("Loading data...");

        UnityOfMeasure g = unityOfMeasureService.findByDescription("g");
        UnityOfMeasure cup = unityOfMeasureService.findByDescription("Cup");

        Category mexican = categoryService.findByDescription("Mexican");

        Recipe chilliRecipe = new Recipe();
        chilliRecipe.setDescription("CHILLI COM CARNE MOÍDA E FEIJÃO");
        chilliRecipe.setDifficulty(Difficulty.EASY);
        chilliRecipe.setPrepTime(20);
        chilliRecipe.setCookTime(30);

        chilliRecipe = recipeService.save(chilliRecipe);

        mexican.getRecipes().add(chilliRecipe);
        mexican = categoryService.save(mexican);

        chilliRecipe.getCategories().add(mexican);
        chilliRecipe = recipeService.save(chilliRecipe);

        Ingredient ground_meat = new Ingredient();
        ground_meat.setAmount(BigDecimal.valueOf(500));
        ground_meat.setUnityOfMeasure(g);
        ground_meat.setRecipe(chilliRecipe);
        ground_meat.setDescription("ground meat");

        ground_meat = ingredientService.save(ground_meat);

        chilliRecipe.getIngredients().add(ground_meat);
        chilliRecipe = recipeService.save(chilliRecipe);


        Ingredient beans = new Ingredient();
        beans.setAmount(BigDecimal.valueOf(2));
        beans.setUnityOfMeasure(cup);
        beans.setRecipe(chilliRecipe);
        beans.setDescription("cooked beans");

        beans = ingredientService.save(beans);

        chilliRecipe.getIngredients().add(beans);
        chilliRecipe = recipeService.save(chilliRecipe);

        recipes.add(chilliRecipe);

        return recipes;
    }
}
