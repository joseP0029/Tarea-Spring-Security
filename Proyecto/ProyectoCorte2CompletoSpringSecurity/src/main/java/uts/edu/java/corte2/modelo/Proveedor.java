package uts.edu.java.corte2.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = Proveedor.TABLE_NAME)
public class Proveedor {
	// Atributos Constante con nombre de la tabla
	private static final String TABLE_NAME = "proveedor";

	// Campos de la BD
	@Id
	@NotNull(message = "El NIT es obligatorio")
	private Integer nit;

	@NotBlank(message = "El nombre es obligatorio")
	@Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
	private String nombre;

	@NotBlank(message = "La ciudad es obligatoria")
	private String ciudad;

	@NotBlank(message = "La dirección es obligatoria")
	private String direccion;

	@NotBlank(message = "El teléfono es obligatorio")
	@Pattern(regexp = "\\d{7,10}", message = "El teléfono debe tener entre 7 y 10 dígitos")
	private String telefono;

	// Constructores
	public Proveedor(Integer nit, String ciudad, String direccion, String nombre, String telefono) {
		this.nit = nit;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Proveedor() {
	}

	// Getters y Setters

	public Integer getNit() {
		return nit;
	}

	public void setNit(Integer nit) {
		this.nit = nit;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
