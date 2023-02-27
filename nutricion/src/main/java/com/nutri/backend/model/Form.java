package com.nutri.backend.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
public class Form {
	//Columns
	//ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column
	private String sex;

	@Column
	private String activity;

	@Column
	private String interes;

	@Column
	private String diet;

	@Column
	private String age;

	@Column
	private  double weight;

	@Column
	private  double height;

	@OneToOne(mappedBy = "form")
	private User user;

	public Form() {
	}

	public Form(String sex, String age, String activity, double weight,double height, String service,
	        String diet) {

		this.sex = sex;
		this.age = age;
		this.activity = activity;
		this.weight = weight;
		this.height = height;
		this.interes = service;
		this.diet = diet;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getInteres() {
		return interes;
	}

	public void setInteres(String interes) {
		this.interes = interes;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Long getId(){return id;}
}
