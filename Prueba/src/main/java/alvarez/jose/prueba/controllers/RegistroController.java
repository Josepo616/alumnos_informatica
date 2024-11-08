package alvarez.jose.prueba.controllers;

import alvarez.jose.prueba.models.Alumno;
import alvarez.jose.prueba.models.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    // Mostrar el formulario de registro de alumno
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("alumno", new Alumno());  // Agregar un nuevo objeto Alumno al modelo
        return "registroPage";  // Devuelve la vista registroPage.html
    }

    // Procesar el formulario de registro y guardar el alumno
    @PostMapping("/registro")
    public String registrarAlumno(@ModelAttribute Alumno alumno) {
        alumnoRepository.save(alumno);  // Guardar el alumno en la base de datos
        return "redirect:/alumnos";  // Redirigir a la lista de alumnos (asegúrate de tener un controlador para /alumnos)
    }
}
