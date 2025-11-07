package uts.edu.java.corte2.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uts.edu.java.corte2.modelo.Proveedor;
import uts.edu.java.corte2.repositorio.ProveedorRepositorio;

@Service
@Transactional
public class ProveedorServicio implements IProveedorServicio{

	// Atributo(Objeto) de ripo Repository
	@Autowired
	ProveedorRepositorio proveedorRepositorio;
	
	@Override
	public List<Proveedor> getProveedores() {
		return proveedorRepositorio.findAll();
	}

	@Override
	public Proveedor nuevoProveedor(Proveedor proveedor) {
		return proveedorRepositorio.save(proveedor);
	}

	@Override
	public Proveedor buscarProveedor(int id) {
		return proveedorRepositorio.findById(id).orElse(null);
	}

	@Override
	public void borrarProveedor(int id) {
		proveedorRepositorio.deleteById(id);
	}
	
}
