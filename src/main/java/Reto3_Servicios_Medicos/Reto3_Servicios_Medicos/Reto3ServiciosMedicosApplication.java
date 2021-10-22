//modelo o entidad
//Interface
//repositorio
//servicios
//controlador o web


package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo"})
@SpringBootApplication
public class Reto3ServiciosMedicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(Reto3ServiciosMedicosApplication.class, args);
	}

}
