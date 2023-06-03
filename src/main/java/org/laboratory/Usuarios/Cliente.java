package org.laboratory.Usuarios;

import org.laboratory.tarjeta.Debito;

import java.time.Period;
import java.util.ArrayList;

import static org.laboratory.Menu.listaClientes;
import static org.laboratory.Utilidades.Tiempo.setFecha;

public class Cliente extends Usuario {
    private final int idCliente;
    public static ArrayList<Debito> listaDebito=new ArrayList<>();
    private static int cantidadCliente=0;

    public Debito getDebito() {
        return listaDebito.get(idCliente);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public static int getCantidadCliente() {
        return cantidadCliente;
    }

    public static void clienteEliminado() {
        cantidadCliente-=1;
    }
    public Cliente(){
        System.out.println("Ingrese el nombre del Cliente");
        nombre=sc.next();
        System.out.println("Ingrese el Apellido del Cliente");
        apellido=sc.next();
        System.out.println("Ingrese el DNI del Cliente");
        dni=sc.next();
        System.out.println("Ingrese la direccion del Cliente");
        direccion=sc.next();
        System.out.println("Ingrese la profesion del Cliente");
        profesion=sc.next();
        System.out.println("A continuacion ingresara la fecha de nacimiento del cliente");
        fechaNacimiento = setFecha();
        diferenciaTiempo = Period.between(fechaNacimiento,ahora);
        edad = diferenciaTiempo.getYears();
        idCliente=cantidadCliente;
        cantidadCliente++;
        listaDebito.add(new Debito(listaClientes.get(idCliente)));
    }
    public Cliente(String nombre, String apellido, String dni, String direccion, String profesion) {
        super(nombre, apellido, dni, direccion, profesion);
        idCliente=cantidadCliente;
        cantidadCliente++;

    }
}
