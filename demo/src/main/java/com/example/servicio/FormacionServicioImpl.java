package com.example.servicio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.CursoDto;
import com.example.modelo.Formacion;

@Service
public class FormacionServicioImpl implements FormacionServicio {
    @Autowired
    RestTemplate template;
    private String URL_MICROSERVICIO_CURSOS = "http://localhost:9998/curso";

    @Override
    public List<Formacion> listarCursosActual() {
     
        List<CursoDto>ListaCursosDto = Arrays.asList(template.getForObject(URL_MICROSERVICIO_CURSOS, CursoDto[].class));
        
         // Mapeo
        List<Formacion> listaFormacion = ListaCursosDto.stream().map(CursoDto -> {
            Formacion formacion = new Formacion();
            formacion.setCurso(CursoDto.getNombre());
            formacion.setAsignaturas(calcular(CursoDto.getDuracion()));
            formacion.setPrecio(CursoDto.getPrecio());
            return formacion;
        }).collect(Collectors.toList());

        return listaFormacion;
    }

    @Override
    public List<Formacion> alta(Formacion formacion) {
         if (!isValidFormacion(formacion)) {
            throw new IllegalArgumentException("la formacion que has introducido no es valida");
        }
        int duracion = calcularDuracion(formacion.getAsignaturas());

        CursoDto curso = new CursoDto(formacion.getCurso(), duracion, formacion.getPrecio());

        template.postForLocation(URL_MICROSERVICIO_CURSOS, curso);

        return listarCursosActual();
    }

    /**
     * Metodo para calcular el numero de asignaturas
     *
     * @param duracion
     * @return int
     */
    private int calcular(int duracion) {
        return (duracion >= 50) ? 10 : 5;
    }

    /**
     * Metodo para calcular la duracion del curso
     *
     * @param asignaturas
     * @return asiganturas
     */
    private int calcularDuracion(int asignaturas) {
        return asignaturas * 10;
    }

    private boolean isValidFormacion(Formacion formacion) {
        if (formacion == null) {
            return false;
        }

        if (StringUtils.isBlank(formacion.getCurso())) {
            return false;
        }

        if (formacion.getAsignaturas() <= 0) {
            return false;
        }

        if (formacion.getPrecio() <= 0) {
            return false;
        }

        return true;
    }
}
