package guru.springframework.services;

import guru.springframework.model.Category;
import guru.springframework.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findByDescription(String description){
        return categoryRepository.findByDescription(description).get();
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }
}
