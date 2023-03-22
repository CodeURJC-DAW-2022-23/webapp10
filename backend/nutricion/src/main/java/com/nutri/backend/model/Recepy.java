package com.nutri.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Recepy {
    public interface RecepyBasic{}

    //Columns
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(RecepyBasic.class)
    @Column(name = "ID")
    private long id;

    //name
    @JsonView(RecepyBasic.class)
    @Column(nullable = false)
    private String name;

    //description
    @JsonView(RecepyBasic.class)
    @Column(nullable=false, length = 2048)
    private String description;

    @Column(nullable=false)
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @JsonView(RecepyBasic.class)
    @Column(nullable=false)
    private String ingredients;

    public String getKindOfRecepy() {
        return kindOfRecepy;
    }

    public void setKindOfRecepy(String kindOfRecepy) {
        this.kindOfRecepy = kindOfRecepy;
    }

    public Diet getDietRecepy() {
        return dietRecepy;
    }

    public void setDietRecepy(Diet dietRecepy) {
        this.dietRecepy = dietRecepy;
    }

    @JsonView(RecepyBasic.class)
    @Column(nullable = false)
    private String kindOfRecepy;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //image
    @Column(nullable = true)
    private String image;
    @Lob
    @JsonIgnore
    private Blob imageFile;

    @ManyToOne
    private Diet dietRecepy;


    public Recepy(){}

    public Recepy(String name,String ingredients,String description, Blob image, String tipo_dieta){
        this.description=description;
        this.kindOfRecepy=tipo_dieta;
        this.ingredients=ingredients;
        this.imageFile=image;
        this.name=name;
    }
    public Recepy(String name,String ingredients, String description,String tipo_dieta){
        this.description=description;
        this.name=name;
        this.ingredients=ingredients;
        this.kindOfRecepy=tipo_dieta;
    }

    public Diet getDiet() {
        return dietRecepy;
    }

    public void setDiet(Diet diet) {
        this.dietRecepy = dietRecepy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blob getImageFile() {
        return imageFile;
    }

    public void setImageFile(Blob imageFile) {
        this.imageFile = imageFile;
    }
}
