package uts.edu.java.corte2.servicio;

import java.util.List;

import uts.edu.java.corte2.modelo.Proveedor;

public interface IProveedorServicio {

	// Métodos a implementar en la clase servicio
	
	// Listar todos los datos
	List<Proveedor> getProveedores();
	
	// Crear o Salvar proveedor
	Proveedor nuevoProveedor(Proveedor proveedor);
	
	// Buscar por llave
	Proveedor buscarProveedor(int id);
	
	// Eliminar un Proveedor
	void borrarProveedor(int id);
}
