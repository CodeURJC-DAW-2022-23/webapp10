package com.nutri.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import java.sql.Blob;

@Entity
public class Diet {
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
    @Column(nullable=false)
    private String description;

    //image
    @Lob
    @JsonIgnore
    private Blob image;

    public Diet(){}

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

    public Diet(long id, String name, String description, Blob image){
       this.id=id;
       this.name=name;
       this.description=description;
       this.image=image;

    }

}
