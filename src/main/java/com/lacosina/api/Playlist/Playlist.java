package com.lacosina.api.Playlist;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lacosina.api.Recipe.Recipe;
import com.lacosina.api.User.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class Playlist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "favorite")
    private Boolean favorite;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = "playlist_recipe",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id")
    )
    public Set<Recipe> recipes;
}
