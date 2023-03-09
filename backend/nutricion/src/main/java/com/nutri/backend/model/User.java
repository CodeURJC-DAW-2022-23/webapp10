package com.nutri.backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;


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

    public void setImage(String image) {
        this.image = image;
    }

    //image
    @Column(nullable = true)
    private String image;

    @Column(nullable = false)
    @JsonView({ClientBasic.class, ClientLog.class})
    private int bCounter;
    @Column(nullable = false)
    @JsonView({ClientLog.class, ClientBasic.class})
    private int lCounter;
    @Column(nullable = false)
    @JsonView({ClientBasic.class, ClientLog.class})
    private int dCounter;


    //entryDate
    //Desde Fuera inyectar entryDate, sacando la fecha y haciendo Save, me quito doleres de cabeza. Paso un entero y
    //Uso este como controlador de meses.
    //Deberia funcionar correctamente, si cuando construyo el objeto tengo ese setter, el getter lo recoge y lo añade a ese elementto.
    @Column
    private int entryDate ;

    public int getbCounter() {return bCounter;}

    public void setbCounter(int bCounter){this.bCounter = bCounter;}
    public int getdCounter() {return dCounter;}
    public void setdCounter(int dCounter){this.dCounter = dCounter;}
    public int getlCounter() {return lCounter;}
    public void setlCounter(int lCounter){this.lCounter = bCounter;}


    public int getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(int entryDate) {
        this.entryDate = entryDate;
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

    public Blob getImageFile() {
        return imageFile;
    }

    public void setImageFile(Blob imageFile) {
        this.imageFile = imageFile;
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
    private Blob imageFile;

    public boolean hasImage() { return this.image != null; }

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
        this.entryDate = this.getEntryDate();
    }
    //client constructor
    public User(String name, String surname, String email, String password){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userType = "client";
        this.encodedPassword = password;
        this.bCounter = bCounter;
        this.dCounter = dCounter;
        this.lCounter = lCounter;
        this.entryDate = this.getEntryDate();
    }
}
