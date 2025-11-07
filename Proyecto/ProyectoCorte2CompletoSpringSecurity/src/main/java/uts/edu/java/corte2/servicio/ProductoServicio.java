package uts.edu.java.corte2.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uts.edu.java.corte2.modelo.Producto;
import uts.edu.java.corte2.repositorio.ProductoRepositorio;

@Service
@Transactional
public class ProductoServicio implements IProductoServicio{

	@Autowired
	ProductoRepositorio productoRepositorio;
	
	@Override
	public List<Producto> getProductos() {
		return productoRepositorio.findAll();
	}

	@Override
	public Producto listarId(int id) {
		return productoRepositorio.findById(id).get();
	}

	@Override
	public Producto saveProducto(Producto producto) {
		return productoRepositorio.save(producto);
	}

	@Override
	public void delete(int id) {
		productoRepositorio.deleteById(id);
	}
	
	

}
