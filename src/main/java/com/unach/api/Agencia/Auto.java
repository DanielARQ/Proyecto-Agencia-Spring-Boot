package com.unach.api.Agencia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity

public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long noSerie;
    private String version;
    private int modelo;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    @JsonIgnoreProperties(value = {"nombre", "pais", "autos"})
    private Marca marca;

    public Auto() {}

    public Auto(String version, int modelo, double precio, Marca marca) {
        this.version = version;
        this.modelo = modelo;
        this.precio = precio;
        this.marca = marca;
    }

    public Long getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(Long noSerie) {
        this.noSerie = noSerie;
    }

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
    
    
  
}
