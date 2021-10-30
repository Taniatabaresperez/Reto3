package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tania
 */

@Entity
@Table(name = "specialty")
/**
 * Creacion de la clase Specialty para asociar los datos ingresados en la base de
 * datos
 *
 * @param Integer id
 * @param String name, description
 */
public class Specialty implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    /**
     * Atributo Integer id
     */
    private Integer id;
    /**
     * Atributo String name
     */
    @Column(length =45)
    private String name;
    /**
     * Atributo string description
     */
    @Column(length =250)
    private String description;
    
    /**
     * Creacion de una relacion One to Many con la tabla doctor
     */
    @OneToMany (cascade={CascadeType.PERSIST},mappedBy = "specialty")
    @JsonIgnoreProperties("specialty")
    private List<Doctor> doctors;
    
    /**
     * Creacion de los Getters y Setters de cada uno de los atributos y de la
     * relacion
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

}
