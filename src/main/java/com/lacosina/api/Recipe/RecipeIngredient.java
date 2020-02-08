package com.lacosina.api.Recipe;

import com.lacosina.api.Ingredient.Ingredient;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_ingredient_id")
    private int id;

    @Column(name = "order")
    private int order;

    @Column(name = "measurement")
    private String measurement;

    @ManyToOne
    private Recipe recipe;

    @OneToOne
    private Ingredient ingredient;
}
