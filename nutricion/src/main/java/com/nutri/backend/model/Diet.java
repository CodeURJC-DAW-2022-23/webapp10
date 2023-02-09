package com.nutri.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

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

    //Users List
    @OneToMany(mappedBy = "diet")
    private List<User> users;

    //Recepies List
    @OneToMany(mappedBy = "dietRecepy")
    private List<Recepy> recepies;

    public List<Recepy> getRecepies() {
        return recepies;
    }

    public void setRecepies(List<Recepy> recepies) {
        this.recepies = recepies;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }




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
