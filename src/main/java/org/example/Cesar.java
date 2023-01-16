package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Cesar {
    public static void main() throws IOException {
        String continuar = "s";
        File carp; // Iniciador
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Quieres cifrar(C) o descifrar(D)?");
            String opcion = sc.nextLine();
            if (opcion.equals("C")) {
                carp = new File("src/main/ficheros/cifrados/Cesar");
                System.out.println("Introduce el texto a cifrar");
                String texto = sc.nextLine();
                System.out.println(texto);
                System.out.println("Introduce el desplazamiento");
                int aleatorio = sc.nextInt();
                sc.nextLine();
                cifradoCesar(texto, aleatorio);
                System.out.println("Texto cifrado: " + cifradoCesar(texto, aleatorio));
                System.out.println("Donde deseas guardar el resultado? Escriba el nombre del fichero sin extensión");
                String[] contenido = carp.list();
                for (String nombre : contenido) {
                    File f = new File(carp.getPath(), nombre);
                    if (f.isDirectory()) {
                        System.out.println(nombre + ", " + " carpeta");
                    } else {
                        System.out.println(nombre + ", " + " fichero");
                    }
                }
                String nombreFichero = sc.nextLine();
                File fichero = new File("src/main/ficheros/cifrados/Cesar/" + nombreFichero + ".txt");
                if (fichero.exists()){
                    System.out.println("El fichero ya existe");
                    BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
                    bw.write(cifradoCesar(texto, aleatorio));
                    bw.close();
                } else {
                    fichero.createNewFile();
                    FileWriter fw = new FileWriter(fichero);
                    fw.write(cifradoCesar(texto, aleatorio));
                    fw.close();
                }

            } else if (opcion.equals("D")) {
                carp = new File("src/main/ficheros/descifrados/Cesar");
                System.out.println("Introduce el texto a descifrar");
                String texto = sc.nextLine();
                System.out.println(texto);
                System.out.println("Introduce el desplazamiento");
                int aleatorio = sc.nextInt();
                sc.nextLine();
                descifradoCesar(texto, aleatorio);
                System.out.println("Texto descifrado: " + descifradoCesar(texto, aleatorio));

                System.out.println("Donde deseas guardar el resultado? Escriba el nombre del fichero sin extensión");
                String[] contenido = carp.list();
                for (String nombre : contenido) {
                    File f = new File(carp.getPath(), nombre);
                    if (f.isDirectory()) {
                        System.out.println(nombre + ", " + " carpeta");
                    } else {
                        System.out.println(nombre + ", " + " fichero");
                    }
                }
                String nombreFichero = sc.nextLine();
                File fichero = new File("src/main/ficheros/descifrados/Cesar/" + nombreFichero + ".txt");
                if (fichero.exists()){
                    System.out.println("El fichero ya existe");
                    BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
                    bw.write(descifradoCesar(texto, aleatorio));
                    bw.close();
                } else {
                    fichero.createNewFile();
                    FileWriter fw = new FileWriter(fichero);
                    fw.write(descifradoCesar(texto, aleatorio));
                    fw.close();
                }

            } else {
                System.out.println("Opción no válida");
            }
            System.out.println("Quieres continuar(S/N)?");
            continuar = sc.nextLine();
        } while (continuar.equals("S") || continuar.equals("s"));


    }
    public static String cifradoCesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }

    public static String descifradoCesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) - codigo) < 'a') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) - codigo) < 'A') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            }
        }
        return cifrado.toString();
    }
}
