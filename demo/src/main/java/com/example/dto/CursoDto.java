package com.example.dto;

import java.util.Objects;

public class CursoDto {
   
   
    private int codigo;
    private String nombre;
    private int duracion;
    private int precio;
    

      
    public CursoDto(String nombre, int duracion, int precio) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}
    
    public CursoDto(int codigo, String nombre, int duracion, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }
    public CursoDto() {
    }
       
    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    @Override
	public int hashCode() {
		return Objects.hash(codigo, duracion, nombre, precio);
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CursoDto other = (CursoDto) obj;
        if (codigo != other.codigo)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (duracion != other.duracion)
            return false;
        if (precio != other.precio)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Curso [codigo=" + codigo + ", nombre=" + nombre + ", duracion=" + duracion + ", precio=" + precio + "]";
    }

   

    
}
