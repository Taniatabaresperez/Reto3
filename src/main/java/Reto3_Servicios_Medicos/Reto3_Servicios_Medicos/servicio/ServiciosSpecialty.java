package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.servicio;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.repositorio.RepositorioSpecialty;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Specialty;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tania
 */

@Service
public class ServiciosSpecialty {
    @Autowired
    private RepositorioSpecialty metodosCrud;
    
    public List<Specialty> getAll(){
        return metodosCrud.getAll();
    }  
    
    public Optional<Specialty> getSpecialty(int idSpecialty){
        return metodosCrud.getSpecialty(idSpecialty);
    }
    
    public Specialty save(Specialty specialty){
        if(specialty.getId()==null){
	    return metodosCrud.save(specialty);
	}else{
	    Optional<Specialty> evt=metodosCrud.getSpecialty(specialty.getId());
	    if(evt.isEmpty()){
	    return metodosCrud.save(specialty);
	    }else{
                return specialty;
	    }
        }
    }
    
    public Specialty update(Specialty specialty){
        if (specialty.getId() != null) {
            Optional<Specialty> g = metodosCrud.getSpecialty(specialty.getId());
            if (!g.isEmpty()) {
                if (specialty.getDescription() != null) {
                    g.get().setDescription(specialty.getDescription());
                }
                if (specialty.getName() != null) {
                    g.get().setName(specialty.getName());
                }
                metodosCrud.save(g.get());
                return g.get();

            } else {
                return specialty;
            }
        } else{
                return specialty;
            }
    }
    
    public boolean deleteSpecialty(int specialtyId){
        return getSpecialty(specialtyId).map(specialty -> {
            metodosCrud.delete(specialty);
            return true;
        }).orElse(false);
    }
}
