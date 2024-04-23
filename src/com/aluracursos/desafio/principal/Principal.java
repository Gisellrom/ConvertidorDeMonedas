package com.aluracursos.desafio.principal;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int valor = 0; //variable para recuperar el valor que se va a convertir
        int salir = 1; //variable para salir del bucle

        while(salir != 7) {
            System.out.println("************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda");
            System.out.println("1) Dolar = >> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar ==> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elige una opción válida: ");
            System.out.println("************************************");
            int opcion = lectura.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Ingresa el valor que deseas convertir");
                    valor = lectura.nextInt();
                    break;
                case 2:
                    System.out.println("Ingresa el valor que deseas convertir");
                    valor = lectura.nextInt();
                    break;
                case 3:
                    System.out.println("Ingresa el valor que deseas convertir");
                    valor = lectura.nextInt();
                    break;
                case 4:
                    System.out.println("Ingresa el valor que deseas convertir");
                    valor = lectura.nextInt();
                    break;
                case 5:
                    System.out.println("Ingresa el valor que deseas convertir");
                    valor = lectura.nextInt();
                    break;
                case 6:
                    System.out.println("Ingresa el valor que deseas convertir");
                    valor = lectura.nextInt();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Error, elige una opción válida");
                    break;
            }
        }
        System.out.println("***********************");
    }
}
