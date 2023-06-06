package org.laboratory.tarjeta;

import org.laboratory.Usuarios.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Debito extends Tarjeta{

    public static int cantidadTarjeta=0;
    private final int idTarjeta;


    
    String preFijoDeb="2222 ";
    private double saldo;

    Scanner sc=new Scanner(System.in);
    public static ArrayList<String> listaNumerosDebito=new ArrayList<>();
    public Debito(Cliente cliente){
        boolean validador=true;
        idTarjeta=cantidadTarjeta;
        cantidadTarjeta++;
        do {
            numTarjeta=randomizarNumero();
            if (listaNumerosDebito.size()!=0){
                for (int i=0 ; i<=listaNumerosDebito.size();) {
                    validador=numTarjeta.equals(listaNumerosDebito.get(i))?false:true;
                }
            }else{
                numTarjeta=preFijoDeb+numTarjeta;
                validador=false;
            }

            } while (validador);
        numTarjeta=preFijoDeb+numTarjeta;

    }

    public void consultarMonto() {
        System.out.println("El monto de su cuenta es:"+ saldo);
    }

    public void ingresarDinero(double ingreso) {
        saldo +=ingreso;
    }
    public void enviarDinero(Debito receptor){
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
