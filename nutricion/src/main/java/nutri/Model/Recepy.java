package nutri.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Recepy {
    //Columns
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    //name
    @Column(nullable = false)
    @NotNull
    private String name = "";

    //description
    @Column(nullable=false)
    @NotNull
    private String description="";

    //image
    @Lob
    @JsonIgnore
    private Blob image;

    public Recepy(){}

    public Recepy(long id, String name, String description, Blob image){
        this.description=description;
        this.id=id;
        this.image=image;
        this.name=name;
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
}
