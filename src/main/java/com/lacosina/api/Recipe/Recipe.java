package com.lacosina.api.Recipe;

import com.lacosina.api.User.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name = "durationFrom_min")
    private Integer durationFrom_m;

    @Column(name = "durationTo_min")
    private Integer durationTo_m;

    @ManyToOne
    private User user;
}
