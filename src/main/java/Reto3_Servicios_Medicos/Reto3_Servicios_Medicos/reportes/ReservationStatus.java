package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.reportes;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Client;

/**
 *
 * @author tania
 */
public class ReservationStatus {
    
    private Integer completed;
    private Integer cancelled;

    public ReservationStatus(Integer completed, Integer cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }

}
