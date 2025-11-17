package com.unach.api.controller;
import java.util.List;                       
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unach.api.Agencia.Marca;
import com.unach.api.Agencia.MarcaRepository;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {
    private final MarcaRepository marcaRepo;
    
    public MarcaController(MarcaRepository marcaRepo) {
        this.marcaRepo = marcaRepo;
    }
    
    @GetMapping
    public List<Marca> listarMarcas() {
        return marcaRepo.findAll();
    }
  
}
