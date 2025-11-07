package uts.edu.java.corte2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uts.edu.java.corte2.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
	
}
