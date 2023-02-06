package nutri.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;

import javax.persistence.*;

public class Form {
    //Interface for client columns: all
    public interface ClientBasic{}
    //Interface for worker columns: all
    public interface WorkerBasic{}
    //Columns
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @JsonView({User.WorkerBasic.class,Form.ClientBasic.class})
    private long id;

    //sexo
    @Column(nullable = false)
    @NotNull
    @JsonView({User.WorkerBasic.class,Form.ClientBasic.class})
    private String sex = "";

    //actividad
    @Column(nullable = false)
    @NotNull
    @JsonView({User.WorkerBasic.class,Form.ClientBasic.class})
    private String activity = "";

    //interes
    @Column(nullable = false)
    @NotNull
    @JsonView({User.WorkerBasic.class,Form.ClientBasic.class})
    private String interes = "";

    //dieta
    @Column(nullable = false)
    @NotNull
    @JsonView({User.WorkerBasic.class,Form.ClientBasic.class})
    private String diet = "";

    //edad
    @Column(nullable = false)
    @NotNull
    @JsonView({User.WorkerBasic.class,Form.ClientBasic.class})
    private Integer age = 0;

    //peso
    @Column(nullable = false)
    @NotNull
    @JsonView({User.WorkerBasic.class,Form.ClientBasic.class})
    private Integer weight = 0;

    //altura
    @Column(nullable = false)
    @NotNull
    @JsonView({User.WorkerBasic.class,Form.ClientBasic.class})
    private Integer height = 0;

    public Form() {
    }

    public Form(long id, String sexo, Integer edad, String actividad, Integer peso, Integer altura, String servicio
    , String dieta){
        this.id=id;
        this.sex=sexo;
        this.age=edad;
        this.activity=actividad;
        this.weight=peso;
        this.height=altura;
        this.interes=servicio;
        this.diet=dieta;
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
