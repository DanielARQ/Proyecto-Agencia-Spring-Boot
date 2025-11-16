package com.unach.api.Agencia;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AutoRepository extends JpaRepository<Auto, Long> {

    @Query("SELECT a FROM Auto a WHERE a.marca.nombre = :nombre")
    List<Auto> buscarPorMarca(@Param("nombre") String nombre);

    @Query("SELECT a FROM Auto a WHERE a.marca.nombre = :nombre AND a.precio > :precio")
    List<Auto> buscarPorMarcaYPrecioMayor(@Param("nombre") String nombre, @Param("precio") double precio);

    @Query("SELECT a FROM Auto a WHERE a.precio = (SELECT MIN(a2.precio) FROM Auto a2 WHERE a2.marca.nombre = :nombre)")
    Optional<Auto> buscarMasBaratoPorMarca(@Param("nombre") String nombre);
    
    @Query("SELECT a FROM Auto a WHERE a.precio > :precio")
    List<Auto> buscarPorPrecioMayor(@Param("precio") double precio);


    @Transactional
    @Modifying
    @Query("DELETE FROM Auto a WHERE a.modelo < :anio")
    int eliminarPorModeloMenorA(@Param("anio") int anio);
}