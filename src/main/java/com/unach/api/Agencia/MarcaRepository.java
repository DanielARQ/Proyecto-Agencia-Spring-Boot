package com.unach.api.Agencia;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

	  // Buscar una marca por nombre
    @Query("SELECT m FROM Marca m WHERE m.nombre = :nombre")
    Optional<Marca> buscarPorNombre(@Param("nombre") String nombre);
}
