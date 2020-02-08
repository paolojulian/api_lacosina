package com.lacosina.api.User;

import com.lacosina.api.Profile.Profile;
import lombok.Data;
import org.aspectj.bridge.Message;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name="profile_id")
    private Profile profile;
//    private Collection<Recipe> recipes;
//    private Collection<Playlist> playlists;
//    private Collection<Friend> friends;

    @CreatedDate
    @Column(name = "created")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified")
    private Date modifiedDate;

    public User() {

    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = hashPassword(password);
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(this.generateSalt());
            return md.digest(password.getBytes(StandardCharsets.UTF_8)).toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Im sorry, but SHA-512 is not a valid algo");
        }
        return "";
    }

    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public String getFormattedCreatedDate() {
        return this.getCreatedDate().toString();
    }

    public String getFormattedModifiedDate() {
        return this.getModifiedDate().toString();
    }
}
