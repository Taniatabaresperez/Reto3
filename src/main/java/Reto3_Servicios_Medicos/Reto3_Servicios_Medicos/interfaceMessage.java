package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tania
 */
public interface interfaceMessage extends CrudRepository<Message, Integer> {
    
}
