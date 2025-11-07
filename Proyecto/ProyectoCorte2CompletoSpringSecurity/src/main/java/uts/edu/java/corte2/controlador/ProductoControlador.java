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
import uts.edu.java.corte2.modelo.Producto;
import uts.edu.java.corte2.modelo.Proveedor;
import uts.edu.java.corte2.servicio.ProductoServicio;
import uts.edu.java.corte2.servicio.ProveedorServicio;

@Controller
@RequestMapping("/views/producto")
public class ProductoControlador {

	@Autowired
	ProveedorServicio proveedorServicio;

	@Autowired
	ProductoServicio productoServicio;

	@GetMapping("/")
	public String verProductos(Model model) {
		List<Producto> listaProductos = productoServicio.getProductos();
		model.addAttribute("listaProductos", listaProductos);
		return "/views/producto/producto";
	}

	// Método para ir al formulario de captura "/new
	@GetMapping("/new")
	public String mostrarPaginaNuevoProducto(Model model) {
		Producto producto = new Producto();
		List<Proveedor> listaProveedores = proveedorServicio.getProveedores();
		model.addAttribute("listaProveedores", listaProveedores);
		model.addAttribute("producto", producto);
		return "/views/producto/nuevo_producto";
	}

	@PostMapping("/save")
	public String saveProducto(@Valid @ModelAttribute("producto") Producto producto, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("listaProveedores", proveedorServicio.getProveedores());
			model.addAttribute("msgError", "Por favor corrija los errores antes de continuar.");
			return "views/producto/nuevo_producto";
		}

		try {
			productoServicio.saveProducto(producto);
		} catch (Exception e) {
			model.addAttribute("msgError", "Error al guardar el producto: " + e.getMessage());
			model.addAttribute("listaProveedores", proveedorServicio.getProveedores());
			return "views/producto/nuevo_producto";
		}

		return "redirect:/views/producto/";
	}

	@GetMapping("/listar/{codigo}")
	public String listarId(@PathVariable int codigo, Model model) {
		model.addAttribute("producto", productoServicio.listarId(codigo));
		List<Proveedor> listaProveedores = proveedorServicio.getProveedores();
		model.addAttribute("listaProveedores", listaProveedores);
		return "/views/producto/editar_producto";
	}

	// Eliminar
	@GetMapping("/delete/{codigo}")
	public String deleteProducto(@PathVariable int codigo) {
		productoServicio.delete(codigo);
		return "redirect:/views/producto/";
	}
}
