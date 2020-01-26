package com.lacosina.api.Playlist;

import com.lacosina.api.User.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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

    @ManyToOne
    private User user;
}
