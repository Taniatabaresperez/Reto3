package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.repositorio;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.interfaceDoctor;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Doctor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tania
 */

@Repository
public class RepositorioDoctor {
    
    @Autowired
    private interfaceDoctor crud;
    
    public List<Doctor> getAll(){
        return (List<Doctor>) crud.findAll();
    }
    
    public Optional <Doctor> getDoctor(int id){
        return crud.findById(id);
    }
    
    public Doctor save(Doctor doctor){
        return crud.save(doctor);
    }
    
    public void delete(Doctor doctor){
        crud.delete(doctor);
    }
}
