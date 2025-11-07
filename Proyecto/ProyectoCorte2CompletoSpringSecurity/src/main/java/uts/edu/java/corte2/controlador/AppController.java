package uts.edu.java.corte2.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {
	
	// Método de inicio de proyecto
	@GetMapping("/")
	public String index() {
		return "home";
	}
}
