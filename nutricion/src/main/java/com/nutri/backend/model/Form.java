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
	private  int weight;

	@Column
	private  int height;

	public Form() {
	}

	public Form(String sex, String age, String activity, int weight,int height, String service,
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

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
}
