package com.unach.api.Agencia;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID de la marca", example = "1 o 2")

    private Long id;
    @Schema(description = "Nombre de la marca", example = "HONDA")
    private String nombre;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    @JsonIgnore
    @Schema(description = "Lista de autos de la marca")
    private List<Auto> autos;
    @Schema(description = "País de origen de la marca", example = "Japón")
    private String pais;

    
    
    public Marca(Long id, String nombre, List<Auto> autos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autos = autos;
	}

	public Marca() {}

    public Marca(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
    
    

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Auto> getAutos() {
		return autos;
	}

	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}

    
}