package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tania
 */


public interface interfaceReservation extends CrudRepository<Reservation, Integer>{
    
}
