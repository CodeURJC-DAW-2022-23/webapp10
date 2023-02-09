package com.nutri.backend.model;


import javax.persistence.*;

@Entity
public class Form {
	// Interface for client columns: all
	public interface ClientBasic {
	}

	// Interface for worker columns: all
	public interface WorkerBasic {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String sex;

	@Column
	private String activity;

	@Column
	private String interes;

	@Column
	private String diet = "";

	@Column
	private Integer age = 0;

	@Column
	private Integer weight = 0;

	@Column
	private Integer height = 0;

	public Form() {
	}

	public Form(long id, String sexo, Integer edad, String actividad, Integer peso, Integer altura, String servicio,
	        String dieta) {
		this.id = id;
		this.sex = sexo;
		this.age = edad;
		this.activity = actividad;
		this.weight = peso;
		this.height = altura;
		this.interes = servicio;
		this.diet = dieta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
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
