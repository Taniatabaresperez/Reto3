package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 *
 * @author tania
 */

@Entity
@Table(name = "Score")
/**
 * Creacion de la clase Score para asociar los datos ingresados en la base de
 * datos
 *
 * @param Integer id, calification
 * @param String messageText
 */
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    /**
     * Atributo Integer id
     */
    private Integer id;
    /**
     * Atributo String messageText
     */
    private String messageText;
    /**
     * Atributo Integer calification
     */
    private Integer calification;
    
    /**
     * Creacion de una relacion One To One con la tabla reservation
     */
    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

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

    public Integer getCalification() {
        return calification;
    }

    public void setCalification(Integer calification) {
        this.calification = calification;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

}
