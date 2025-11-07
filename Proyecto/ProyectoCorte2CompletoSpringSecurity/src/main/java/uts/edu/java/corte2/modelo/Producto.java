package uts.edu.java.corte2.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "productos")
public class Producto {

	// Atributos
	@Id
	@Min(value = 1, message = "El código debe ser un número positivo.")
	private int codigo;

	@NotBlank(message = "El nombre no puede estar vacío.")
	private String nombre;

	@NotNull(message = "Debe seleccionar un proveedor.")
	@ManyToOne
	@JoinColumn(name = "nitproveedor")
	private Proveedor nitproveedor;

	@NotNull(message = "Debe ingresar el precio de compra.")
	@Min(value = 0, message = "El precio de compra no puede ser negativo.")
	private Double precio_compra;

	@NotNull(message = "Debe ingresar el IVA.")
	@Min(value = 0, message = "El IVA no puede ser negativo.")
	private Double iva;

	@NotNull(message = "Debe ingresar el precio de venta.")
	@Min(value = 0, message = "El precio de venta no puede ser negativo.")
	private Double precio_venta;

	// Constructores
	public Producto(int codigo, String nombre, Proveedor nitproveedor, Double precio_compra, Double iva,
			Double precio_venta) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.nitproveedor = nitproveedor;
		this.precio_compra = precio_compra;
		this.iva = iva;
		this.precio_venta = precio_venta;
	}

	public Producto() {
	}

	// Getters y Setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Proveedor getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(Proveedor nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public Double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(Double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(Double precio_venta) {
		this.precio_venta = precio_venta;
	}

}
