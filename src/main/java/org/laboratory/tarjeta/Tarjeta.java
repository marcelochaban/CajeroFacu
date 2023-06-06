package org.laboratory.tarjeta;

public abstract class Tarjeta {

    String numTarjeta;



    public static String randomizarNumero(){
        String num="";
        for (int i=0; i<=11;i++){
            int valorEntero = (int) (Math.floor(Math.random()*(9-0+1)+0));
            num=num+valorEntero;
            if (i%4==0){
                num=num+" ";
            }
        }
        return num;
    }

}
