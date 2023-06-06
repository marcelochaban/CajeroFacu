package org.laboratory.Usuarios;

import org.laboratory.tarjeta.Debito;
import org.laboratory.tarjeta.Tarjeta;

import java.time.Period;
import java.util.ArrayList;

import static org.laboratory.Menu.listaClientes;
import static org.laboratory.Utilidades.Tiempo.setFecha;

public class Cliente extends Usuario {
    private final int idCliente;
    public static ArrayList<Debito> listaDebito=new ArrayList<>();
    public static ArrayList<String> listaCBU=new ArrayList<>();
    public static ArrayList<String> listaAlias=new ArrayList<>();
    private static int cantidadCliente=0;

    private String auxString;

    public Debito getDebito() {
        return listaDebito.get(idCliente);
    }

    public int getIdCliente() {
        return idCliente;
    }
    boolean validador=true;

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
        do {
            auxString= Tarjeta.randomizarNumero();
            if (listaCBU.size()!=0){
                for (int i=0 ; i<listaCBU.size();i++) {
                    auxString= Tarjeta.randomizarNumero();
                    System.out.println(auxString);
                    validador=(auxString==listaCBU.get(i))?true:false;
                    System.out.println(i);
                    System.out.println(validador);
                    System.out.println("no se buge");
                }
            }else{
                validador=false;
            }

        } while (validador);
        listaCBU.add(auxString);
        listaAlias.add(""+getNombreCompleto()+getIdCliente());
        listaAlias.get(idCliente).replace(" ",".");
    }
    public Cliente(String nombre, String apellido, String dni, String direccion, String profesion) {
        super(nombre, apellido, dni, direccion, profesion);
        idCliente=cantidadCliente;
        cantidadCliente++;
        do {
            auxString= Tarjeta.randomizarNumero();
            if (listaCBU.size()!=0){
                for (int i=0 ; i<listaCBU.size();i++) {
                    auxString= Tarjeta.randomizarNumero();
                    validador=(auxString==listaCBU.get(i))?true:false;
                }
            }else{
                validador=false;
            }

        } while (validador);
        listaCBU.add(auxString);
        listaAlias.add(""+getNombreCompleto()+getIdCliente());
        listaAlias.get(idCliente).replace(" ",".");
    }
}
