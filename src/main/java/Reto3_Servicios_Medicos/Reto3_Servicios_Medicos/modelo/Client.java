package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
@Table(name = "client")
/**
 * Creacion de la clase Client para asociar los datos ingresados en la base de
 * datos
 *
 * @param Integer idClient, age
 * @param String email, password, name
 */
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Atributo Integer idClient
     */
    private Integer idClient;
    /**
     * Atributo String email
     */
    private String email;
    /**
     * Atributo String password
     */
    private String password;
    /**
     * Atributo String name
     */
    private String name;
    /**
     * Atributo Integer age
     */
    private Integer age;
    /**
     * Creacion de una relacion One to Many con la tabla message
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Message> messages;
    /**
     * Creacion de una relacion One to Many con la tabla reservation
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Reservation> reservations;

    /**
     * Creacion de los Getters y Setters de cada uno de los atributos y
     * relaciones
     */
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
