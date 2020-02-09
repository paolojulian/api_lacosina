package com.lacosina.api.Recipe;

import com.lacosina.api.User.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table(name="recipe")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Please enter a name for your recipe")
    @NotNull(message = "Please enter a name for your recipe")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "duration_from_minutes")
    private Long durationFrom_minutes;

    @Column(name = "duration_to_minutes")
    private Long durationTo_minutes;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private List<RecipeIngredient> ingredients = new ArrayList<>();

    @ManyToOne
    private User user;

    public Recipe() {}

    public Recipe(String name, String description, Long durationFrom, Long durationTo) {
        this.name = name;
        this.description = description;
        this.durationFrom_minutes = durationFrom;
        this.durationTo_minutes = durationTo;
    }

    public String toString() {
        return String.format(
                "Recipe(name: %s, duration: %s to %s minute/s)",
                this.name,
                this.durationFrom_minutes,
                this.durationTo_minutes
        );
    }

}
