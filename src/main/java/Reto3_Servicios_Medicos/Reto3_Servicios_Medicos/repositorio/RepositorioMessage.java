package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.repositorio;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.repositorio.crud.interfaceMessage;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tania
 */

@Repository
public class RepositorioMessage {
    @Autowired
    private interfaceMessage crud;
    
    public List<Message> getAll(){
        return (List<Message>) crud.findAll();
    }
    
    public Optional <Message> getMessage(int id){
        return crud.findById(id);
    }
    
    public Message save(Message message){
        return crud.save(message);
    }
    
    public void delete(Message message){
       crud.delete(message);
    }
}
