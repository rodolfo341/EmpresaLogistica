package com.github.rodolfo341.controlador;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.rodolfo341.entidad.Producto;
import com.github.rodolfo341.servicio.IProductoServicio;

@Controller
public class ProductoControlador {

	@Autowired
	private IProductoServicio servicio;
	
	@GetMapping({"/","/productos"})
	public String encontrarTodos(@RequestParam Map<String, Object> params, Model modelo) {
		int page = params.get("page") != null ? Integer.valueOf(params.get("page").toString()) - 1  : 0 ;
		PageRequest pr =PageRequest.of(page, 7);
		
		Page<Producto> pageProducto = servicio.encontrarTodos(pr);
		
		int totalPage = pageProducto.getTotalPages();
		
		if( totalPage > 2 ) {
			List<Integer>pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			modelo.addAttribute("pages", pages);
		}
		
		modelo.addAttribute("listaDeProductos", pageProducto.getContent());
		modelo.addAttribute("paginaActual", page + 1 );
		modelo.addAttribute("paginaSiguiente", page + 2 );
		modelo.addAttribute("paginaAnterior", page);
		modelo.addAttribute("ultimaPagina", totalPage);
		
		return "/productos";
	}
	
	@GetMapping("/productos/nuevo")
	public String mostrarFormularioDeRegistroProductos(Model modelo) {
		Producto producto = new Producto();
		modelo.addAttribute("producto", producto);
		return "crear_producto";
	}
	
	@PostMapping("/productos")
	public String guardarProducto(@ModelAttribute("producto") Producto producto) {
		servicio.guardarProducto(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/productos/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("producto", servicio.obtenerProductoPorId(id));
		return "editar_producto";
	}
	
	@PostMapping("/productos/{id}")
	public String actualizarProducto(@PathVariable Long id, @ModelAttribute("producto") Producto producto, Model modelo) {
		Producto productoExistente = servicio.obtenerProductoPorId(id);
		productoExistente.setId(id);
		productoExistente.setNombre(producto.getNombre());
		productoExistente.setPrecio(producto.getPrecio());
		productoExistente.setStock(producto.getStock());
		servicio.actualizarProducto(productoExistente);		
		return "redirect:/productos";
	}
	
	@GetMapping("/productos/{id}")
	public String eliminarProducto(@PathVariable Long id) {
		servicio.eliminarProducto(id);
		return "redirect:/productos";
	}	
	
}
