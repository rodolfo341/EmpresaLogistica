package com.github.rodolfo341;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.rodolfo341.entidad.Producto;
import com.github.rodolfo341.repositorio.IProductoRepositorio;

@SpringBootApplication
public class EmpresaLogisticaApplication   implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaLogisticaApplication.class, args);
	}
	
	@Autowired
	private IProductoRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {
		Producto producto1 = new Producto("martillo",2500, 10);
		repositorio.save(producto1);
		
		Producto producto2 = new Producto("alicate",3250, 12);
		repositorio.save(producto2);
	}

}
