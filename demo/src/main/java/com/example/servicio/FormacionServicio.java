package com.example.servicio;

import java.util.List;


import com.example.modelo.Formacion;

public interface FormacionServicio {

	/**
	 * acciones que quiero que realice , la implementacion se realizará en
	 * FormacionServicioImpl.java
	 * 
	 * @return
	 */

	List<Formacion> listarCursosActual();

	List<Formacion> alta(Formacion formacion);

}
