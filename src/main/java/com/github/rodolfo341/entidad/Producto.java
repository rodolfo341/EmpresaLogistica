package com.github.rodolfo341.entidad;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "precio", nullable = false, precision = 10)
	private double precio;
	
	@Column(name = "stock", nullable = false, precision = 10)
	private double stock;
	
	public Producto() {	}

	public Producto(String nombre, double precio, double stock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	
	public Producto(long id, String nombre, double precio, double stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	public String getNombre() {	return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public double getPrecio() {	return precio; }
	public void setPrecio(double precio) { this.precio = precio; }
	public double getStock() { return stock; }
	public void setStock(double stock) { this.stock = stock; }	
	
}
