package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tania
 */

@Entity
@Table(name = "message")
/**
 * Creacion de la clase Message para asociar los datos ingresados en la base de
 * datos
 *
 * @param Integer idMessage
 * @param String messageText
 */
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Atributo Integer idMessage
     */
    private Integer idMessage;
    /**
     * Atributo String messageText
     */
    private String messageText;
    
    /**
     * Creacion de una relacion Many To One con la tabla doctor
     */
    @ManyToOne
    @JoinColumn(name ="doctorId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Doctor doctor;
    /**
     * Creacion de una relacion Many To One con la tabla client
     */
    @ManyToOne
    @JoinColumn(name ="clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
    
    /**
     * Creacion de los Getters y Setters de cada uno de los atributos y
     * relaciones
     */
    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
    
}
