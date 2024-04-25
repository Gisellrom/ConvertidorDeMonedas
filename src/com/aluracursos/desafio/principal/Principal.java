package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.conversion.Conversion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcion = 0; //variable para salir del bucle

        while (opcion != 13) {
            System.out.println("************************************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda\n");
            System.out.println("1) Dolar = >> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar ==> Boliviano boliviano");
            System.out.println("4) Boliviano boliviano =>> Dólar");
            System.out.println("5) Dólar =>> Real brasileño");
            System.out.println("6) Real brasileño =>> Dólar");
            System.out.println("7) Dolar = >> Peso chileno");
            System.out.println("8) Peso chileno =>> Dólar");
            System.out.println("9) Dólar ==> Peso colombiano");
            System.out.println("10) Peso colombiano  =>> Dólar");
            System.out.println("11) Dólar =>> Peso mexicano");
            System.out.println("12) Peso mexicano =>> Dólar");
            System.out.println("13) Salir");
            System.out.println("Elige una opción válida: ");
            try {
                opcion = lectura.nextInt();
                lectura.nextLine(); // Clear buffer

                System.out.println("************************************************************************");

                switch (opcion) {
                    case 1:
                        convertirMoneda("USD", "ARS", lectura);
                        break;
                    case 2:
                        convertirMoneda("ARS", "USD", lectura);
                        break;
                    case 3:
                        convertirMoneda("BOB", "USD", lectura);
                        break;
                    case 4:
                        convertirMoneda("USD", "BOB", lectura);
                        break;
                    case 5:
                        convertirMoneda("BRL", "USD", lectura);
                        break;
                    case 6:
                        convertirMoneda("USD", "BRL", lectura);
                        break;
                    case 7:
                        convertirMoneda("CLP", "USD", lectura);
                        break;
                    case 8:
                        convertirMoneda("USD", "CLP", lectura);
                        break;
                    case 9:
                        convertirMoneda("COP", "USD", lectura);
                        break;
                    case 10:
                        convertirMoneda("USD", "COP", lectura);
                        break;
                    case 11:
                        convertirMoneda("USD", "MXN", lectura);
                        break;
                    case 12:
                        convertirMoneda("MXN", "USD", lectura);
                        break;
                    case 13:
                        System.out.println("Gracias por usar nuestro conversor de monedas... ¡Adios! ");
                        break;
                    default:
                        System.out.println("La opcion no existe, elige una opción del 1 al 13");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("¡ERROR! La opcion ingresada no coincide con el formato que se pide");
                lectura.nextLine(); // Clear buffer

            }catch (IllegalStateException e){
                System.out.println("¡Error! El lector de opcion no está habilitado");

            }catch (Exception e){
                System.out.println("¡Error! Hubo un error al ingresar la opcion");

            }
        }//fin del while
        lectura.close();
        System.out.println("************************************************************************");
    }//fin del main

    public static void convertirMoneda(String baseCode,String targetCode,Scanner scanner) {

        int ciclo= 0;
        System.out.println("Ingresa la cantidad que deseas convertir");

        try {
            double cantidad = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer

            Conversion conversion = new Conversion(baseCode, targetCode, cantidad);
            double result = conversion.convertidorDeMonedas();

            System.out.println("*********************************************************************");
            System.out.println(cantidad + " " + baseCode + " son " + result + " " + targetCode);
            System.out.println("LA CANTIDAD A SIDO CONVERTIDA CON ÉXITO!");
            System.out.println("********************************************************************");

        } catch (InputMismatchException e) {
            System.out.println("¡ERROR! La cantidad no coincide con el formato que se pide");
            scanner.nextLine(); // Clear buffer
        }catch (IllegalStateException e){
            System.out.println("¡Error! El lector de cantidad no está habilitado");
        }catch (Exception e){
            System.out.println("¡Error! Hubo un error al ingresar la cantidad");
        }
    }//fin de convertirMoneda

}//fin de la clase Principal
