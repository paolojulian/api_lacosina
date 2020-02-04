package com.lacosina.api.Playlist;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lacosina.api.Recipe.Recipe;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class Playlist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "favorite")
    private Boolean favorite;
//
//    @ManyToOne
//    private User user;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "playlist_recipe",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id")
    )
    public Set<Recipe> recipes;
}
