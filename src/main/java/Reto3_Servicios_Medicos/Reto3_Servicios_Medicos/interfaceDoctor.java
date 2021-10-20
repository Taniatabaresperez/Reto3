
package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Doctor;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tania
 */
//reto 3 solo se hace el get y el post  
public interface interfaceDoctor extends CrudRepository<Doctor, Integer>{
    
}
