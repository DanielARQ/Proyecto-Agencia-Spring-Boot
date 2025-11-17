package com.unach.api.controller;
import java.util.List;                         // ← IMPORT NECESARIO
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unach.api.Agencia.Auto;
import com.unach.api.Agencia.AutoRepository;
import com.unach.api.Agencia.Marca;
import com.unach.api.Agencia.MarcaRepository;

@RestController
@RequestMapping("/api/autos")
public class AutoController {

    private final AutoRepository autoRepo;
    private final MarcaRepository marcaRepo;

    public AutoController(AutoRepository autoRepo, MarcaRepository marcaRepo) {
        this.autoRepo = autoRepo;
        this.marcaRepo = marcaRepo;
    }

    
    /*public AutoController(AutoRepository autoRepo) {
        this.autoRepo = autoRepo;
    }*/

    @PostMapping
    public Auto registrarAuto(@RequestBody Auto auto) {

        // Normalizamos nombre y país para evitar duplicados
        String nombre = auto.getMarca().getNombre().toUpperCase();
        String pais   = auto.getMarca().getPais().toUpperCase();

        Marca marcaExistente = marcaRepo.buscarPorNombreAndPais(nombre, pais)
                                         .orElse(auto.getMarca());

        auto.setMarca(marcaExistente);
        return autoRepo.save(auto);
    }

    
    
    //Eliminar Auto Por ID
    @GetMapping
    public List<Auto> listarTodos() {
        return autoRepo.findAll();
    }


    @GetMapping("/{noSerie}")
    public Auto buscarPorId(@PathVariable Long noSerie) {
        return autoRepo.findById(noSerie)
                .orElse(null);
    }
    
    // Eliminar Auto
    @DeleteMapping("/{noSerie}")
    public String eliminarAuto(@PathVariable Long noSerie) {
        autoRepo.deleteById(noSerie);
        return "Auto eliminado correctamente";
    }
    
    /*//Registrar Auto
    @PostMapping
    public Auto registrarAuto(@RequestBody Auto auto) {
        return autoRepo.save(auto);
    }*/
    
    //Buscar Autos por Marca
    @GetMapping("/marca/{nombre}")
    public List<Auto> autosPorMarca(@PathVariable String nombre) {
        return autoRepo.buscarPorMarca(nombre);
    }
    
    
    // Autos con precio mayor a X
    @GetMapping("/precio/{varprecio}")
    public List<Auto> autosPorPrecio(@PathVariable("varprecio") double precio) {
        return autoRepo.buscarPorPrecioMayor(precio);
    }

   
    
    
}
