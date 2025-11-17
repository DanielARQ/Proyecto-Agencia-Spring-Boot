package com.unach.api.Agencia;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

	  // Buscar una marca por nombre
    @Query("SELECT m FROM Marca m WHERE m.nombre = :nombre")
    Optional<Marca> buscarPorNombre(@Param("nombre") String nombre);
    
    @Query("SELECT m FROM Marca m WHERE m.nombre = :nombre AND m.pais = :pais")
    Optional<Marca> buscarPorNombreAndPais(@Param("nombre") String nombre, @Param("pais") String pais); //agregado nuevo
    
    List<Marca> findAllDistinct(); //agreaado nuevo


}
