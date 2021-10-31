package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.servicio;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Client;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.repositorio.RepositorioClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tania
 */

@Service
public class ServiciosClient {
    @Autowired
    private RepositorioClient metodosCrud;
    
    public List<Client> getAll(){
        return metodosCrud.getAll();
    }  
    
    public Optional<Client> getClient(int id){
        return metodosCrud.getClient(id);
    }
    
    public Client save(Client client){
        if(client.getIdClient()==null){
	    return metodosCrud.save(client);
	}else{
	    Optional<Client> evt=metodosCrud.getClient(client.getIdClient());
	    if(evt.isEmpty()){
	    return metodosCrud.save(client);
	    }else{
                return client;
	    }
        }
    }
    
    public Client update(Client client){
        if (client.getIdClient() != null) {
            Optional<Client> evt = metodosCrud.getClient(client.getIdClient());
            if (!evt.isEmpty()) {
                if (client.getEmail() != null) {
                    evt.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    evt.get().setPassword(client.getPassword());
                }
                if (client.getName() != null) {
                    evt.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    evt.get().setAge(client.getAge());
                }
                metodosCrud.save(evt.get());
                return evt.get();

            } else {
                return client;
            }
        } else {
            return client;
        }
    }
    
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
