package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.repositorio;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.interfaceClient;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tania
 */

@Repository
public class RepositorioClient {
    @Autowired
    private interfaceClient crud;
    
    public List<Client> getAll(){
        return (List<Client>) crud.findAll();
    }
    
    public Optional <Client> getClient(int id){
        return crud.findById(id);
    }
    
    public Client save(Client client){
        return crud.save(client);
    }
    
    public void delete(Client client){
       crud.delete(client);
    }
}
