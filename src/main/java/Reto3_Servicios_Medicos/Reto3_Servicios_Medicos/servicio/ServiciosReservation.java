package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.servicio;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Reservation;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.reportes.CountClient;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.reportes.ReservationStatus;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.repositorio.RepositorioReservation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tania
 */

/**
 * Creacion de la clase Servicios Reservation para plantear los metodos crud
 * repository
 *
 * @param List Reservation
 * @param Optional Reservation
 * @param save Reservation
 * @param update Reservation
 * @param Boolean Delete Reservation
 */
@Service
public class ServiciosReservation {

    
    @Autowired
    private RepositorioReservation metodosCrud;

    /**
     * Clase que permite obtener todos los elementos
     */
    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }

    /**
     * Clase que permite obtener un elemento en especifico
     */
    public Optional<Reservation> getReservation(int id) {
        return metodosCrud.getReservation(id);
    }

    /**
     * Clase que permite guardar un nuevo elemento
     */
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservation> evt = metodosCrud.getReservation(reservation.getIdReservation());
            if (evt.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    /**
     * Clase que permite modificar un elemento existente
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> evt = metodosCrud.getReservation(reservation.getIdReservation());
            if (!evt.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    evt.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    evt.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    evt.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(evt.get());
                return evt.get();

            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * Clase que permite borrar un elemento en especifico
     */
    public boolean deleteReservation(int reservationId) {
        return getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
    }
    /**
     * Clase que trae el reporte de status
     */
    public ReservationStatus getReservationStatusReport(){
        List<Reservation> completed = metodosCrud.getReservationByStatus("completed");
        List<Reservation> cancelled = metodosCrud.getReservationByStatus("cancelled");
        return new ReservationStatus(completed.size(), cancelled.size());
    }
    /**
     * Clase que tre el reporte de las fechas
     */
    public List<Reservation> getReservationPeriod(String dateOne, String dateTwo){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(dateOne);
            Date endDate = dateFormat.parse(dateTwo);
            if (startDate.before(endDate)){
                return metodosCrud.getReservationPeriod(startDate, endDate);
            }
        }catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }
    /**
     * Clase trae el reporte de los clientes
     */
    public List<CountClient> getTopClients(){
        return metodosCrud.getTopClient();
    }
}
