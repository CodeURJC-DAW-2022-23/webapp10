package com.nutri.backend.model;

import javax.persistence.*;
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

    @Column(nullable = false)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Triplet[] getWeek() {
        return week;
    }

    public void setWeek(Triplet[] week) {
        this.week = week;
    }

    public String printWeek(Triplet[] week){
        Triplet[] semana=week;
        return "Week{\n" +
                "Monday=" + semana[0].toString() + "\n"+
                "Tuesday =" + semana[1].toString() + "\n"+
                "Wednesday =" + semana[2].toString() + "\n"+
                "Thursday =" + semana[3].toString() + "\n"+
                "Friday =" + semana[4].toString() + "\n"+
                "Saturday =" + semana[5].toString() + "\n"+
                "Sunday=" + semana[6].toString() + "\n"+
                '}';
    }

    @Column(length = 2048)
    private Triplet week[]=new Triplet[7];


    //Users List
    @OneToMany(mappedBy = "diet")
    private List<User> users;


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

    public Diet(String name, Triplet[] week, String type){
        this.name=name;
        this.week=week;
        this.type=type;
    }


}
