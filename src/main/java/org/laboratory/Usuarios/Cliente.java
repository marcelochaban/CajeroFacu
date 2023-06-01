package org.laboratory.Usuarios;

import java.time.Period;

import static org.laboratory.Utilidades.Tiempo.setFecha;

public class Cliente extends Usuario {
    private final int idCliente;
    private double saldo;

    private static int cantidadCliente=0;

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
    }
    public Cliente(String nombre, String apellido, String dni, String direccion, String profesion) {
        super(nombre, apellido, dni, direccion, profesion);
        idCliente=cantidadCliente;
        cantidadCliente++;

    }


    public void consultarMonto() {
        System.out.println("El monto de su cuenta es:"+ saldo);
    }

    public void ingresarDinero(double ingreso){
        saldo +=ingreso;
    }
    public void enviarDinero(Cliente receptor){
        consultarMonto();
        System.out.println("ingrese el monto que quiere enviar");
        double envio=sc.nextDouble();
        if (envio>0 && envio<= saldo) {
            saldo -= envio;
            receptor.ingresarDinero(envio);
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

    public void retirarDinero(){
        consultarMonto();
        System.out.println("ingrese la cantidad que desea retirar");
        double retiro=sc.nextDouble();
        if (retiro>0 && retiro<= saldo) {
            saldo -= retiro;
            consultarMonto();
        }
    }
}
