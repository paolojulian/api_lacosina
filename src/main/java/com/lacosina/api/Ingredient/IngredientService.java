package com.lacosina.api.Ingredient;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Transactional
    public Ingredient createIngredient(final String name, final String description, final String category){
        final Ingredient ingredient = new Ingredient(name,description,category);
        return this.ingredientRepository.save(ingredient);
    }

    @Transactional
    public Ingredient updateIngredient(final int id, Ingredient ingredient){
        Ingredient ingredientUpdate = this.ingredientRepository.findById(id).orElseThrow();
        ingredientUpdate.setIngredientName(ingredient.getIngredientName());
        ingredientUpdate.setCategory(ingredient.getIngredientName());
        ingredientUpdate.setDescription(ingredient.getDescription());
        return this.ingredientRepository.save(ingredientUpdate);
    }

    @Transactional
    public Ingredient getIngredient(final int id){
        return this.ingredientRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Boolean deleteIngredient(final int id) {
        try {
            this.ingredientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
