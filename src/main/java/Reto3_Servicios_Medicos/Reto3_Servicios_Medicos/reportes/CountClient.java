package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.reportes;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Client;

/**
 *
 * @author tania
 */
public class CountClient {
    
    private Long total;
    private Client client;

    public CountClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
