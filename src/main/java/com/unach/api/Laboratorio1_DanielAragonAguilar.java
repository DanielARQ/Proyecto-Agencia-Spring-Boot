package com.unach.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.unach.api.Agencia.Auto;
import com.unach.api.Agencia.AutoRepository;
import com.unach.api.Agencia.Marca;
import com.unach.api.Agencia.MarcaRepository;

@SpringBootApplication
public class Laboratorio1_DanielAragonAguilar {

    public static void main(String[] args) {
        SpringApplication.run(Laboratorio1_DanielAragonAguilar.class, args);
    }

    @Bean
    CommandLineRunner initData(MarcaRepository marcaRepo, AutoRepository autoRepo) {
        return args -> {

            //  Actividad 1: Registrar 2 marcas
            Marca honda = marcaRepo.save(new Marca("HONDA", "Japon"));
            Marca toyota = marcaRepo.save(new Marca("TOYOTA","Japon"));

            //  Actividad 2: Registrar 4 autos por marca
            autoRepo.save(new Auto("BRV", 2022, 270000, honda));
            autoRepo.save(new Auto("CIVIC", 2025, 590000, honda));
            autoRepo.save(new Auto("CITY", 2020, 310000, honda));

            autoRepo.save(new Auto("COROLLA", 2021, 340000, toyota));
            autoRepo.save(new Auto("CAMRY", 2024, 580000, toyota));
            autoRepo.save(new Auto("YARIS", 2018, 250000, toyota));
            autoRepo.save(new Auto("RAV4", 2023, 610000, toyota));

            // Actividad 3: Consultar autos de una marca (Honda)
            System.out.println("\n=== Autos de la marca HONDA ===");
            autoRepo.buscarPorMarca("HONDA").forEach(a ->
                    System.out.println(a.getVersion() + " | " + a.getModelo() + " | " + a.getPrecio()));

            // Actividad 4: Autos Honda con precio > 350,000
            System.out.println("\n=== Autos Honda con precio > 350,000 ===");
            autoRepo.buscarPorMarcaYPrecioMayor("HONDA", 350000)
                    .forEach(a -> System.out.println(a.getVersion() + " - $" + a.getPrecio()));

            // Actividad 5: Eliminar autos con modelo menor a 2020
            int eliminados = autoRepo.eliminarPorModeloMenorA(2020);
            System.out.println("\nAutos eliminados (modelo < 2020): " + eliminados);

            // Ver autos restantes
            System.out.println("\n=== Autos después de eliminar modelos < 2020 ===");
            autoRepo.findAll().forEach(a ->
                    System.out.println(a.getVersion() + " | " + a.getModelo() + " | " + a.getMarca().getNombre()));
        };
    }
}
