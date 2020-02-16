package com.lacosina.api.Recipe;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lacosina.api.Procedure.Procedure;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "recipe_procedure")
public class RecipeProcedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "notes")
    private String notes;

    @JoinColumn(name = "recipe_id", insertable = false)
    @JsonBackReference
    private Recipe recipe;

    @OneToOne
    private Procedure procedure;
}
