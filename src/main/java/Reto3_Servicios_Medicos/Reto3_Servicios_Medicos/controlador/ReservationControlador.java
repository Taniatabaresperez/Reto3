package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.controlador;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Reservation;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.reportes.CountClient;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.reportes.ReservationStatus;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.servicio.ServiciosReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tania
 */

@RestController
@RequestMapping("/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationControlador {
    @Autowired
    private ServiciosReservation servicios;
    @GetMapping("/all")
    public List<Reservation> getAll(){
        return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int idReservation){
        return servicios.getReservation(idReservation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED) //ESTE REQUESTBODY PUEDE GENERAR PTOBLEMAS EN EL FRONT
    public Reservation save(@RequestBody Reservation reservation){
        return servicios.save(reservation);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return servicios.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicios.deleteReservation(reservationId);
    }

    @GetMapping("/report-status")
    public ReservationStatus getReservationsStatusReport(){
        return servicios.getReservationStatusReport();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationReportDate(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return servicios.getReservationPeriod(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<CountClient> getClients(){
        return servicios.getTopClients();
    }
}
