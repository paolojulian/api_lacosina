package com.lacosina.api.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository implements JpaRepository<Ingredient, Integer> {
}
