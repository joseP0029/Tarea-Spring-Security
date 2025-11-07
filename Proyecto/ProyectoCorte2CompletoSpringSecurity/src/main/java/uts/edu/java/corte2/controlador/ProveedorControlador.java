package uts.edu.java.corte2.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import uts.edu.java.corte2.modelo.Proveedor;
import uts.edu.java.corte2.servicio.ProveedorServicio;

@Controller
@RequestMapping("/views/proveedor")
public class ProveedorControlador {

	// Atributo es un objeto de la clase servicio
	@Autowired
	ProveedorServicio proveedorServicio;

	// Métoddos

	@GetMapping("/")
	public String verIndex(Model model) {
		List<Proveedor> listaProveedores = proveedorServicio.getProveedores();
		model.addAttribute("listaProveedores", listaProveedores);
		return "/views/proveedor/proveedor";
	}

	@GetMapping("/new")
	public String mostraPaginaNuevoProveedor(Model model) {
		Proveedor proveedor = new Proveedor();
		model.addAttribute("proveedor", proveedor);
		return "/views/proveedor/nuevo_proveedor";
	}

	@PostMapping("/save")
	public String saveProveedor(@Valid @ModelAttribute("proveedor") Proveedor proveedor, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "views/proveedor/nuevo_proveedor"; // Volver al formulario con errores
		}
		proveedorServicio.nuevoProveedor(proveedor);
		return "redirect:/views/proveedor/";
	}

	// Editar un proveedor
	@GetMapping("/listar/{nit}")
	public String listarId(@PathVariable int nit, Model model) {
		model.addAttribute("proveedor", proveedorServicio.buscarProveedor(nit));
		return "/views/proveedor/editar_proveedor";
	}

	// Eliminar un Proveedor
	@GetMapping("/delete/{nit}")
	public String deleteProveedor(@PathVariable(name = "nit") int nit) {
		proveedorServicio.borrarProveedor(nit);
		return "redirect:/views/proveedor/";
	}
}
