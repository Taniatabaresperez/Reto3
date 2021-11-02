package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author tania
 */

@Entity
@Table(name = "reservation")
/**
 * Creacion de la clase Message para asociar los datos ingresados en la base de
 * datos
 *
 * @param Integer idReservation, score
 * @param String status
 * @param Date startDate, devolutionDate
 */
public class Reservation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    /*
      Atributo Integer idReservation
     */
    private Integer idReservation;
    /**
     * Atributo Date startDate
     */
    private Date startDate;
    /**
     * Atributo Date devolutionDate
     */
    private Date devolutionDate;
    /**
     * Atributo String status
     */
    private String status;
    
    /**
     * Creacion de una relacion Many To One con la tabla doctor
     */
    @ManyToOne
    @JoinColumn(name ="doctorId")
    @JsonIgnoreProperties("reservations")
    private Doctor doctor;
    /**
     * Creacion de una relacion Many To One con la tabla client
     */
    @ManyToOne
    @JoinColumn(name ="clientId")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    /**
     * Creacion de una relacion One To One con la tabla score
     */
    @OneToOne (cascade={CascadeType.REMOVE},mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;
//    
    /**
     * Creacion de los Getters y Setters de cada uno de los atributos y
     * relaciones
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

}
