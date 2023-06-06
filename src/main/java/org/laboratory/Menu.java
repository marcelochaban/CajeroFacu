package org.laboratory;

import org.laboratory.Usuarios.Cliente;
import org.laboratory.tarjeta.Debito;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static ArrayList<Cliente> listaClientes=new ArrayList<>();
    boolean validador=true;
    boolean validadorEnvio=true;
    int op;
    int moneda;
    int clienteSeleccionado;
    String clienteEnviar;
    double aux;
    Scanner sc=new Scanner(System.in);

    public void iniciarMenu(){
        while (validador) {
            System.out.println("""
                    Selecciones unas de las siguientes opciones:
                    1.Crear Cliente
                    2.Ingresar a Cliente
                    3.Salir
                    """);
            op=sc.nextInt();
            switch (op) {
                case 1 -> {
                    listaClientes.add(new Cliente());
                    Cliente.listaDebito.add(new Debito(listaClientes.get(Cliente.getCantidadCliente()-1)));
                    if (listaClientes.get(listaClientes.size()-1).getEdad()<18){
                        listaClientes.remove(listaClientes.size()-1);
                        System.out.println("el cliente ingresado era menor de edad");
                        Cliente.clienteEliminado();
                    }else {
                        System.out.println("se creo el cliente correctamente en la posicion N°"+(Cliente.getCantidadCliente()-1));
                    }
                }
                case 2 ->{
                    verLista();
                    System.out.println("Ingrese el cliente al que desea entrar");
                    clienteSeleccionado=sc.nextInt();
                    if (clienteSeleccionado>=0 && clienteSeleccionado<=listaClientes.size()){
                        for (Cliente clientes:listaClientes) {
                            if (clientes.getIdCliente()==clienteSeleccionado){
                                menuCliente(listaClientes.get(clienteSeleccionado));
                            }
                        }
                        validador=true;
                    }else{
                        System.out.println("No existe el cliente ingresado");
                    }
                }
                case 3 -> {
                    System.out.println("El programa se cerrara");
                    validador = false;
                }
                default -> System.out.println("No se ingreso una opcion valida");
            }

        }

    }

    public void verLista(){
        if (Cliente.getCantidadCliente()!=0){
            for (Cliente clientes:listaClientes) {
                System.out.println("El id del cliente " +clientes.getNombreCompleto()+
                        " es: "+clientes.getIdCliente());
            }
        }else{
            System.out.println("No hay clientes registrados");
        }
    }

    public void menuCliente(Cliente cliente){
        while (validador){
            System.out.println("""
                    ingrese la moneda con la que desea operar:
                    0.Pesos 
                    1:Dolares""");
            moneda=sc.nextInt();
            System.out.println("""
                    Selecciones unas de las siguientes opciones:
                    1.Consultar Saldo
                    2.Ingresar Dinero
                    3.Enviar Dinero
                    4.Retirar Dinero
                    5.Salir""");
            op=sc.nextInt();
            switch (op) {
                case 1 -> cliente.getDebito().consultarMonto();
                case 2 -> {
                    System.out.println("Cuanto dinero desea ingresar?");
                    aux = sc.nextDouble();
                    cliente.getDebito().ingresarDinero(aux,moneda);
                }
                case 3 -> {

                    System.out.println("ingrese el CBU o alias del cliente al que le desea enviar dinero");
                    clienteEnviar = sc.next();
                    while (validadorEnvio){
                        for (String alias : Cliente.listaAlias){
                            if (clienteEnviar.equals(alias)){
                                cliente.getDebito().enviarDinero(listaClientes.get(Cliente.listaAlias.indexOf(clienteEnviar)).getDebito(),moneda);
                                validadorEnvio=false;
                            }
                        }
                        for (String cbu : Cliente.listaCBU){
                            if (clienteEnviar.equals(cbu)){
                                cliente.getDebito().enviarDinero(listaClientes.get(Cliente.listaAlias.indexOf(clienteEnviar)).getDebito(),moneda);
                                validadorEnvio=false;
                            }
                        }
                        if (validadorEnvio){
                            System.out.println("No se encontro un cliente asociado a los datos ingresados");
                        }
                        break;
                    }
                }
                case 4 -> cliente.getDebito().retirarDinero(moneda);
                case 5 -> validador = false;
                default -> System.out.println("no ingreso una opcion valida");
            }
            System.out.println("desea seguir operando" +
                    "\n1.Si" +
                    "\n2.No");
            op=sc.nextInt();
            if (op == 2){
                validador=false;
            }
        }

    }
}
