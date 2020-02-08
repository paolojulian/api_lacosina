package com.lacosina.api.Ingredient;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ingredient_name")
    private String ingredientName;

    @Column(name="description")
    private String description;

    @Column(name="category")
    private String category;

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
