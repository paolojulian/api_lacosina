package com.lacosina.api.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient createIngredient(@Valid @RequestBody Ingredient ingredient) {
        return this.ingredientService.createIngredient(ingredient);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(
            @RequestParam(name = "id") final int id,
            @Valid @RequestBody Ingredient ingredient
    ) {
        return this.ingredientService.updateIngredient(id, ingredient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteIngredient(@RequestParam(name = "id") final int id) { return this.ingredientService.deleteIngredient(id); }
}
