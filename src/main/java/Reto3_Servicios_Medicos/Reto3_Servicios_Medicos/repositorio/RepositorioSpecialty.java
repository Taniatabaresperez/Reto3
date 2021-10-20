package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.repositorio;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.interfaceSpecialty;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Specialty;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tania
 */

@Repository
public class RepositorioSpecialty {
    @Autowired
    private interfaceSpecialty crud;
    
    public List<Specialty> getAll(){
        return (List<Specialty>) crud.findAll();
    }
    
    public Optional <Specialty> getSpecialty(int id){
        return crud.findById(id);
    }
    
    public Specialty save(Specialty specialty){
        return crud.save(specialty);
    }
    
    public void delete(Specialty specialty){
       crud.delete(specialty);
    }
    
}
