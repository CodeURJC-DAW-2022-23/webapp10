package com.nutri.backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.type.DateType;
import java.util.Date;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name="userTable")
public class User{
    //Interface for client columns: id and name and NIF
    public interface ClientBasic{}
    //Interface for client columns: id, name, surname, NIF, email.
    public interface ClientLog{}
    //Interface for worker columns: id, name
    public interface WorkerBasic{}
    //Interface for worker columns: id, name, surname, NIF, email, description.
    public interface WorkerLog{}

    //Columns
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @JsonView({WorkerBasic.class, WorkerLog.class, ClientBasic.class, ClientLog.class})
    private long id;

    //name
    @Column(nullable = false)
    @JsonView({WorkerBasic.class, WorkerLog.class, ClientBasic.class, ClientLog.class})
    private String name = "";

    //surmane
    @Column(nullable = false)
    @JsonView({ClientLog.class, WorkerLog.class})
    private String surname = "";


    //email
    @Column(nullable = false)
    @JsonView({ClientLog.class, WorkerLog.class})
    private String email = "";

    //password
    @Column(nullable = false)
    private String encodedPassword = "";

    @OneToOne(cascade=CascadeType.ALL)
    private Form form;

    //entryDate
    private int entryDate;

    public int getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate.getMonth();
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    //description
    @Column(columnDefinition = "TEXT", nullable = false)
    @JsonView(WorkerLog.class)
    private String description = "";

    //image
    @Lob
    @JsonIgnore
    private Blob image;

    //type
    @Column(nullable = false)
    @JsonView({ClientLog.class, WorkerLog.class, ClientBasic.class, WorkerBasic.class})
    private String userType = "";

    //DietTables
    @ManyToOne
    private Diet diet;

    public User() {}

    //admin constructor
    public User( String email,String password) {
        this.email = email;
        this.userType = "admin";
        this.encodedPassword = password;
    }

    //worker constructor
    public User(String name, String surname,String email, String description,String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.description = description;
        this.userType = "worker";
        this.encodedPassword = password;

    }
    //client constructor
    public User(String name, String surname, String email, String password){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userType = "client";
        this.encodedPassword = password;

    }
}
