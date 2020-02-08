package com.lacosina.api.Recipe;

import com.lacosina.api.Ingredient.Ingredient;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "measurement")
    private String measurement;

    @ManyToOne
    @JoinColumn(name = "recipe_id", insertable = false)
    private Recipe recipe;

    @OneToOne
    private Ingredient ingredient;
}
