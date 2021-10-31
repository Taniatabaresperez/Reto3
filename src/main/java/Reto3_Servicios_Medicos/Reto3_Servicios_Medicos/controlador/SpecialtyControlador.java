package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.controlador;

import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Specialty;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.servicio.ServiciosSpecialty;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author tania
 */

@RestController
@RequestMapping("/Specialty")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SpecialtyControlador {
    @Autowired
    private ServiciosSpecialty servicios;
    @GetMapping("/all")
    public List<Specialty> getAll(){
        return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Specialty> getSpecialty(@PathVariable("id") int idSpecialty){
        return servicios.getSpecialty(idSpecialty);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED) //ESTE REQUESTBODY PUEDE GENERAR PTOBLEMAS EN EL FRONT
    public Specialty save(@RequestBody Specialty specialty){
        return servicios.save(specialty);
    } 
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty update(@RequestBody Specialty specialty) {
        return servicios.update(specialty);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int specialtyId) {
        return servicios.deleteSpecialty(specialtyId);
    }
}
