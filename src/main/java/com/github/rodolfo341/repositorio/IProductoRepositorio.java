package com.github.rodolfo341.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.rodolfo341.entidad.Producto;

@Repository
public interface IProductoRepositorio extends JpaRepository<Producto, Long> {

}
