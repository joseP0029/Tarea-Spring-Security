package uts.edu.java.corte2.servicio;

import java.util.List;

import uts.edu.java.corte2.modelo.Producto;

public interface IProductoServicio {
	
	// Cabecera de los métodos deseados
	
	// Listar todos los datos
	public List<Producto> getProductos();
	
	// Buscar Producto por id
	public Producto listarId(int id);
	
	// Crear o salvar un producto
	public Producto saveProducto(Producto producto);
	
	// Eliminar
	public void delete(int id);
}
