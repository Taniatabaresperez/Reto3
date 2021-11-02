package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.repositorio.crud;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tania
 */

public interface interfaceReservation extends CrudRepository<Reservation, Integer>{
    public List<Reservation> findAllByStatus(String status);
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationByClient ();
    
}
