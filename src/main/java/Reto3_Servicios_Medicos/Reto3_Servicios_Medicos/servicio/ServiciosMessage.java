package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.servicio;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Message;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.repositorio.RepositorioMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tania
 */

@Service
public class ServiciosMessage {
    @Autowired
    private RepositorioMessage metodosCrud;
    
    public List<Message> getAll(){
        return metodosCrud.getAll();
    }  
    
    public Optional<Message> getMessage(int id){
        return metodosCrud.getMessage(id);
    }
    
    public Message save(Message message){
        if(message.getIdMessage()==null){
	    return metodosCrud.save(message);
	}else{
	    Optional<Message> evt=metodosCrud.getMessage(message.getIdMessage());
	    if(evt.isEmpty()){
	    return metodosCrud.save(message);
	    }else{
                return message;
	    }
        }
    }
    
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e= metodosCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
