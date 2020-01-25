package com.lacosina.api.Recipe;

import com.lacosina.api.Exception.InvalidDurationException;
import com.lacosina.api.Ingredient.Ingredient;
import com.lacosina.api.User.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "duration_from_min")
    private Long durationFrom;

    @Column(name = "duration_to_m")
    private Long durationTo;

    @OneToMany
    private Set<Ingredient> ingredients;

    @ManyToOne
    private User user;

    public Recipe() {}

    public Recipe(String name, String description, Long durationFrom, Long durationTo) {
        this.name = name;
        this.description = description;
        if (durationFrom > durationTo) {
//            throw new InvalidDurationException();
        }
        this.durationFrom = durationFrom;
        this.durationTo = durationTo;
    }

    public String toString() {
        return String.format(
                "Recipe(name: %s, duration: %s to %s minute/s)",
                this.name,
                this.durationFrom,
                this.durationTo
        );
    }

}
