package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.api.ConsultaAPI;
import com.aluracursos.desafio.conversion.Conversion;
import com.aluracursos.desafio.conversion.Moneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaAPI consulta = new ConsultaAPI();
        Scanner lectura = new Scanner(System.in);
        double cantidad; //cantidad a convertir
        int opcion = 0; //variable para salir del bucle

        while (opcion != 7) {
            System.out.println("************************************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda\n");
            System.out.println("1) Dolar = >> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar ==> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elige una opción válida: ");
            try {
                opcion = lectura.nextInt();
                System.out.println("************************************************************************");

                switch (opcion) {
                    case 1:
                        convertirMoneda("USD", "ARS", lectura);
                        break;
                    case 2:
                        convertirMoneda("ARS", "USD", lectura);
                        break;
                    case 3:
                        convertirMoneda("USD", "BRL", lectura);
                        break;
                    case 4:
                        convertirMoneda("BRL", "USD", lectura);
                        break;
                    case 5:
                        convertirMoneda("USD", "COP", lectura);
                        break;
                    case 6:
                        convertirMoneda("COP", "USD", lectura);
                        break;
                    case 7:
                        System.out.println("Gracias por usar nuestro conversor de monedas... ¡Adios! ");
                        break;
                    default:
                        System.out.println("La opcion no es válida, elige una opción válida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("¡ERROR! Lo que ingresaste no es una opción válida");
            }
        }//fin del while
        lectura.close();
        System.out.println("************************************************************************");
    }//fin del main

    public static void convertirMoneda(String baseCode,String targetCode,Scanner scanner) {
        double cantidad;
        System.out.println("Ingresa el valor que deseas convertir");
        try {
            cantidad = scanner.nextDouble();

            Conversion conversion = new Conversion(baseCode, targetCode, cantidad);
            double result = conversion.convertidorDeMonedas();

            System.out.println("*********************************************************************");
            System.out.println(cantidad + " " + baseCode + " son " + result + " " + targetCode);
            System.out.println("LA CANTIDAD A SIDO CONVERTIDA CON ÉXITO!");
            System.out.println("********************************************************************");

        } catch (Exception e) {
            System.out.println("¡ERROR! Hubo un error al ingresar la cantidad: " + e.getMessage());
        }
    }//fin de convertirMoneda

}//fin de la clase Principal
