package com.lacosina.api.Procedure;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "`procedure`")
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="procedure_name")
    @Size(min = 2, max = 30)
    private String procedureName;

    @Column(name="description")
    @Size(max = 1000)
    private String description;

    @Column(name="image")
    private String image;

    @Column(name="duration_in_seconds")
    @Min(value = 0)
    private int durationInSeconds;

    public Procedure() {}

    public Procedure(String name, String description, String image, int durationInSeconds) {
        this.setProcedureName(name);
        this.setDescription(description);
        this.setImage(image);
        this.setDurationInSeconds(durationInSeconds);
    }
}
