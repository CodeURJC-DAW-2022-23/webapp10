package com.nutri.backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    //NIF
    @Column(nullable = false)
    @JsonView({ClientBasic.class, ClientLog.class, WorkerLog.class})
    private String NIF = "";

    //email
    @Column(nullable = false)
    @JsonView({ClientLog.class, WorkerLog.class})
    private String email = "";

    //password
    @Column(nullable = false)
    private String encodedPassword = "";

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

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
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

    public List<Diet> getDietTables() {
        return exerciseTables;
    }

    public void setExerciseTables(List<Diet> exerciseTables) {
        this.exerciseTables = exerciseTables;
    }

    //description
    @Column(columnDefinition = "TEXT", nullable = false)
    @JsonView(WorkerLog.class)
    private String description = "";

    //image
    @Lob
    @JsonIgnore
    private Blob image;

    public List<String> getUserType() {
        return userType;
    }

    public void setUserType(List<String> userType) {
        this.userType = userType;
    }

    //type
    @Column(nullable = false)
    @JsonView({ClientLog.class, WorkerLog.class, ClientBasic.class, WorkerBasic.class})
    private List<String> userType;

    //DietTables
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Diet> exerciseTables = new ArrayList<>();

    public User() {}

    public User(String name, String surname, String NIF, String email, String encodedPassword,String member){
    }
    //admin constructor
    public User( String email,String password) {
        this.email = email;
        this.encodedPassword = password;
        this.userType = Collections.singletonList("admin");
    }

    //worker constructor
    public User(String name, String surname, String NIF, String email, String address, String postalCode, String phone,String password) {
        this.name = name;
        this.surname = surname;
        this.NIF = NIF;
        this.email = email;
        this.description = description;
        this.userType = Collections.singletonList("worker");
        this.encodedPassword = password;
    }
    //client constructor
    public User(String name, String surname, String NIF, String email,String password){
        this.name = name;
        this.surname = surname;
        this.NIF = NIF;
        this.email = email;
        this.userType = Collections.singletonList("client");
        this.encodedPassword = password;
    }
}
