package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String opcion;
        do {
            System.out.println("Bienvenido al programa de cifrados");
            System.out.println("¿Que cifrado eliges?");
            System.out.println("1. Cesar");
            System.out.println("2. MD5");
            System.out.println("3. SHA");
            System.out.println("4. Salir");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    Cesar.main();
                    break;
                case "2":
                    MD5.main();
                    break;
                case "3":
                    SHA.main();
                    break;
                case "4":
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion.equals("4"));


    }
}
