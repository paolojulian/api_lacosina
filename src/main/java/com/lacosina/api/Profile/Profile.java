package com.lacosina.api.Profile;

import com.lacosina.api.User.User;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="profile_id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="handle")
    private String handle;

    @Column(name="birth_date")
    private Date birthDate ;

    @Column(name="address")
    private String address;

    @Column(name="avatar")
    private String avatar;

    @CreatedDate
    @Column(name = "created")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified")
    private Date modifiedDate;

    @OneToOne
    private User user;
}
