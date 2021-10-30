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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tania
 */

@Entity
@Table(name = "doctor")
/**
 * Creacion de la clase Doctor para asociar los datos ingresados en la base de
 * datos
 *
 * @param Integer id, year
 * @param String name, department, description
 */
public class Doctor implements Serializable {

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
     * Atributo String department
     */
    private String department;
    /**
     * Atributo Integer year
     */
    private Integer year;
    /**
     * Atributo string description
     */
    @Column(length =250)
    private String description;

    /**
     * Creacion de una relacion Many To One con la tabla specialty
     */
    @ManyToOne
    @JoinColumn(name = "specialtyId")
    @JsonIgnoreProperties("doctors")
    private Specialty specialty;
    /**
     * Creacion de una relacion One to Many con la tabla message
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "client"})
    private List<Message> messages;
    /**
     * Creacion de una relacion One to Many con la tabla reservation
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "messages"})
    public List<Reservation> reservations;

    /**
     * Creacion de los Getters y Setters de cada uno de los atributos y
     * relaciones
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
