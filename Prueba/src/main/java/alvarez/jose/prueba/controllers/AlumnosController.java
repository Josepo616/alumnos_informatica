package alvarez.jose.prueba.controllers;

import alvarez.jose.prueba.models.Alumno;
import alvarez.jose.prueba.models.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnosController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    // Mostrar el formulario de registro de alumno
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("alumno", new Alumno());  // Crear un objeto Alumno vacío para el formulario
        return "registro_alumno";  // Vista de registro (HTML)
    }

    // Procesar el formulario de registro de alumno
    @PostMapping("/registro")
    public String registrarAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);  // Guardar el alumno en la base de datos
        return "redirect:/alumnos";  // Redirigir a la lista de alumnos
    }

    // Mostrar la lista de alumnos
    @GetMapping
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", alumnoRepository.findAll());  // Obtener todos los alumnos
        return "lista_alumnos";  // Vista de la lista de alumnos (HTML)
    }
}
