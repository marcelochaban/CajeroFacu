package org.laboratory.Utilidades;

import java.time.LocalDate;
import java.util.Scanner;

public class Tiempo {
    public static int year;
    public static int month;
    public static int day;
    public static int hour;
    public static int minute;
    public static int second;
    public static Scanner sc;

    public Tiempo() {
    }
    public static LocalDate setFecha() {
        return LocalDate.of(setYear(),setMonth(),setDay());
    }

    public static String setHorario() {
        return String.format("%02d:%02d:%02d ", setHour(), setMinute(), setSecond());
    }

    public static int setYear() {
        do {
            System.out.printf("Ingrese el año");
            year = sc.nextInt();
        } while(year < 1886 || year > 2024);

        return year;
    }

    public static int setMonth() {
        do {
            System.out.printf("Ingrese el mes");
            month = sc.nextInt();
        } while(month < 1 || month > 12);

        return month;
    }

    public static int setDay() {
        if (month == 1 && month == 3 && month == 5 && month == 7 && month == 8 && month == 10 && month == 12) {
            do {
                System.out.println("ingrese el dia");
                day = sc.nextInt();
                if (day < 1 || day > 31) {
                    System.out.println("ingrese un dia valido");
                }
            } while(day < 1 || day > 31);
        } else if (month == 4 && month == 6 && month == 9 && month == 11) {
            do {
                System.out.println("ingrese el dia ");
                day = sc.nextInt();
                if (day < 1 || day > 30) {
                    System.out.println("ingrese un dia valido");
                }
            } while(day < 1 || day > 30);
        } else {
            boolean valid = false;

            do {
                System.out.println("ingrese el dia");
                day = sc.nextInt();
                if (year % 4 == 0 && day == 29) {
                    valid = true;
                } else if (day > 0 && day < 29) {
                    valid = true;
                }

                if (!valid) {
                    System.out.printf("Ingrese un dia valido");
                }
            } while(!valid);
        }

        return day;
    }

    public static int setHour() {
        do {
            System.out.println("ingrese la hora");
            hour = sc.nextInt();
            if (hour < 1 || hour > 23) {
                System.out.println("Hora fuera de rango");
            }
        } while(hour < 1 || hour > 23);

        return hour;
    }

    public static int setMinute() {
        do {
            System.out.println("ingrese el minuto");
            minute = sc.nextInt();
            if (minute < 1 || minute > 59) {
                System.out.println("Minuto fuera de rango");
            }
        } while(minute < 1 || minute > 59);

        return minute;
    }

    public static int setSecond() {
        do {
            System.out.println("ingrese el segundo");
            second = sc.nextInt();
            if (second < 1 || second > 59) {
                System.out.println("Segundo fuera de rango");
            }
        } while(second < 1 || second > 59);

        return second;
    }

    static {
        sc = new Scanner(System.in);
    }
}
