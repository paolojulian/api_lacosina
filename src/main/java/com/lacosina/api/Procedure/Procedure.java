package com.lacosina.api.Procedure;

import lombok.Data;
import org.apache.tomcat.jni.Proc;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "`procedure`")
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="procedure_id")
    private int id;

    @Column(name="procedure_name")
    private String procedureName;

    @Column(name="description")
    private String description;

    @Column(name="image")
    private String image;

    @Column(name="duration_in_seconds")
    private int durationInSeconds;

    public Procedure() {}

    public Procedure(String name, String description, String image, int durationInSeconds) {
        this.setProcedureName(name);
        this.setDescription(description);
        this.setImage(image);
        this.setDurationInSeconds(durationInSeconds);
    }
}
