package com.nutri.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Recepy {
    //Columns
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    //name
    @Column(nullable = false)
    private String name;

    //description
    @Column(nullable=false, length = 2048)
    private String description;

    @Column(nullable=false)
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

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

    @Column(nullable = false)
    private String kindOfRecepy;

    //image
    @Lob
    @JsonIgnore
    private Blob image;

    @ManyToOne
    private Diet dietRecepy;


    public Recepy(){}

    public Recepy(String name,String ingredients,String description, Blob image, String tipo_dieta){
        this.description=description;
        this.kindOfRecepy=tipo_dieta;
        this.ingredients=ingredients;
        this.image=image;
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

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
