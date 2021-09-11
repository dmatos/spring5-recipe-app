package guru.springframework.services;

import guru.springframework.model.Ingredient;
import guru.springframework.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }
}
