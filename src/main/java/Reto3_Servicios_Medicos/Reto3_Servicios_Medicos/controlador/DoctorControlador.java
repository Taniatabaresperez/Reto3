
package Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.controlador;


import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.servicio.ServiciosDoctor;
import Reto3_Servicios_Medicos.Reto3_Servicios_Medicos.modelo.Doctor;
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
@RequestMapping("/Doctor")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class DoctorControlador {
    @Autowired
    private ServiciosDoctor servicios;
    @GetMapping("/all")
    public List<Doctor> getAll(){
        return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable("id") int idDoctor){
        return servicios.getDoctor(idDoctor);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED) //ESTE REQUESTBODY PUEDE GENERAR PTOBLEMAS EN EL FRONT
    public Doctor save(@RequestBody Doctor doctor){
        return servicios.save(doctor);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor update(@RequestBody Doctor doctor) {
        return servicios.update(doctor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int doctorId) {
        return servicios.deleteDoctor(doctorId);
    }
}
