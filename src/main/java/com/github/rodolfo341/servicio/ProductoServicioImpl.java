package com.github.rodolfo341.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.rodolfo341.entidad.Producto;
import com.github.rodolfo341.repositorio.IProductoRepositorio;

@Service
public class ProductoServicioImpl implements IProductoServicio {

	@Autowired 
	private IProductoRepositorio repositorio;
	
	@Override
	public Page<Producto> encontrarTodos(Pageable pageable) {
		return repositorio.findAll(pageable);
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		return repositorio.save(producto);
	}

	@Override
	public Producto obtenerProductoPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		return repositorio.save(producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		repositorio.deleteById(id);
	}

}
