package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.repositorio;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Client;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.reportes.CountClient;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.repositorio.crud.interfaceReservation;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tania
 */

@Repository
public class RepositorioReservation {
    @Autowired
    private interfaceReservation crud;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }
    
    public Optional <Reservation> getReservation(int id){
        return crud.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }
    
    public void delete(Reservation reservation){
       crud.delete(reservation);
    }
    
    public List<Reservation> getReservationByStatus(String status){
        return crud.findAllByStatus(status);
    }
    
    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return crud.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<CountClient> getTopClient(){
        List<CountClient> clientList = new ArrayList<>();
        List<Object[]> report = crud.countTotalReservationByClient();
        for (int i = 0; i < report.size(); i++){
            clientList.add(new CountClient((Long) report.get(i)[1], (Client)report.get(i)[0]));
        }
        return clientList;

    }
}

