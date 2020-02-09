package com.lacosina.api.Ingredient;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ingredient_name")
    @NotNull
    @Size(min = 2, max = 30)
    private String ingredientName;

    @Column(name="description")
    @Size(min = 0, max = 1000)
    private String description;

    @Column(name="category")
    @Size(min = 0, max = 30)
    private String category;

    public Ingredient() {}

    public Ingredient(String name, String description, String category) {
        //validate dn dto bago iset?
        this.setIngredientName(name);
        this.setDescription(description);
        this.setCategory(category);
    }

    public Ingredient(String name, String description) {
        //validate dn dto bago iset?
        this.setIngredientName(name);
        this.setDescription(description);
        this.setCategory("Others");
    }
}
