package com.github.rodolfo341.servicio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.github.rodolfo341.entidad.Producto;

public interface IProductoServicio {

	public Page<Producto> encontrarTodos(Pageable pageable);
	
	public Producto guardarProducto(Producto producto);
	
	public Producto obtenerProductoPorId(Long id);
	
	public Producto actualizarProducto(Producto producto);
	
	public void eliminarProducto(Long id);
	
}
