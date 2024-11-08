package alvarez.jose.prueba.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Bienvenido a la aplicación de registro de alumnos");
        return "index";  // Esto se refiere al archivo index.html en la carpeta templates
    }
}
