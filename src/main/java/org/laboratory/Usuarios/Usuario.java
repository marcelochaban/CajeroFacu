package org.laboratory.Usuarios;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import static org.laboratory.Utilidades.Tiempo.setFecha;

public abstract class Usuario {
    String nombre;
    String apellido;
    String dni;
    String direccion;
    String profesion ;
    LocalDate fechaNacimiento;
    LocalDate ahora= LocalDate.now();
    int edad;
    Period diferenciaTiempo;
    Scanner sc=new Scanner(System.in);

    public Usuario(){}

    public int getEdad() {
        return edad;
    }

    public String getNombreCompleto() {
        return nombre+" "+apellido;
    }

    public Usuario(String nombre, String apellido, String dni, String direccion, String profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.profesion = profesion;
        fechaNacimiento = setFecha();
        diferenciaTiempo = Period.between(fechaNacimiento,ahora);
        edad = diferenciaTiempo.getYears();
    }
}
