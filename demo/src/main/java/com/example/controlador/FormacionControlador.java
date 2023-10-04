package com.example.controlador;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.Formacion;
import com.example.servicio.FormacionServicio;


@RestController
public class FormacionControlador {

    /**
     * Inyectamos nuestra interfaz del servicio
     */
    @Autowired
    FormacionServicio service;

   
    @GetMapping(value = "formacion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Formacion>> listarCursosActual() {
        List<Formacion> formaciones = service.listarCursosActual();

        if (formaciones.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(formaciones);
    }

    /**
     * @param formacion
     * @return List<Formacion>
     */
    @PostMapping(value = "formacion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Formacion>> alta(@RequestBody Formacion formacion) {
        try {
            List<Formacion> formaciones = service.alta(formacion);
            return ResponseEntity.ok(formaciones);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonList(new Formacion("No valido (null)", 0, 0)));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
