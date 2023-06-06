package org.laboratory.tarjeta;

import org.laboratory.Usuarios.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Debito extends Tarjeta{

    public static int cantidadTarjeta=0;
    private final int idTarjeta;
    String preFijoDeb="2222 ";
    private double saldoPesos;
    private double saldoUsd;
    Scanner sc=new Scanner(System.in);
    Cliente cliente;
    public static ArrayList<String> listaNumerosDebito=new ArrayList<>();
    public Debito(Cliente cliente){
        this.cliente=cliente;
        boolean validador=true;
        idTarjeta=cantidadTarjeta;
        cantidadTarjeta++;
        System.out.println("ingreso al id tarjeta");
        do {
            System.out.println("antes del random");
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
        System.out.println("El monto de pesos de su cuenta es:"+ saldoPesos);
        System.out.println("El monto de dolares de su cuenta es:"+ saldoUsd);
    }

    public void ingresarDinero(double ingreso,int moneda) {
        switch (moneda){
            case 0:
                saldoPesos +=ingreso;
            case 1:
                saldoUsd +=ingreso;
            default:
                System.out.println("no ingreso una moneda valida");
        }

    }
    public void enviarDinero(Debito receptor,int moneda){
        consultarMonto();
        System.out.println("ingrese el monto que quiere enviar");
        double envio=sc.nextDouble();
        switch (moneda){
            case 0:
                if (envio>0 && envio<= saldoPesos) {
                    saldoPesos -= envio;
                    receptor.ingresarDinero(envio,0);
                }else{
                    System.out.println("Saldo insuficiente");
                }
            case 1:
                if (envio>0 && envio<= saldoUsd) {
                    saldoUsd -= envio;
                    receptor.ingresarDinero(envio,1);
                }else{
                    System.out.println("Saldo insuficiente");
                }
            default:
                System.out.println("no ingreso una moneda valida");
        }

    }


    public void retirarDinero(int moneda){
        consultarMonto();
        System.out.println("ingrese la cantidad que desea retirar");
        double retiro=sc.nextDouble();
        switch (moneda){
            case 0:
                if (retiro>0 && retiro<= saldoPesos) {
                    saldoPesos -= retiro;
                    consultarMonto();
                }
            case 1:
                if (retiro>0 && retiro<= saldoUsd) {
                    saldoUsd -= retiro;
                    consultarMonto();
                }
            default:
                System.out.println("No ingreso una moneda valida");
        }

    }
}
