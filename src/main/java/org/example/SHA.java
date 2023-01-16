package org.example;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class SHA {
    public static void main() throws IOException {
        File carp; // Iniciador
        String email;
        String pw;

        Scanner sc = new Scanner(System.in);
        System.out.println("Quieres verificar el usuario (V) o crear uno nuevo (C)?");
        String opcion = sc.nextLine();
        carp = new File("src/main/ficheros/cifrados/SHA");
        if (opcion.equals("C")) {


            System.out.print("Introduce el usuario: \n");
            email = sc.nextLine();
            System.out.print("Introduce la contraseña: \n");
            pw = sc.nextLine();

            System.out.print("El hash SHA-256 del email es: ");
            System.out.println(ObtenerHASHSHA(email));
            System.out.print("El hash SHA-256 de la contraseña es: ");
            System.out.println(ObtenerHASHSHA(pw));


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
            File fichero = new File("src/main/ficheros/cifrados/SHA/" + nombreFichero + ".txt");
            if (fichero.exists()) {
                System.out.println("El fichero ya existe");
                BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
                bw.write(ObtenerHASHSHA(email));
                bw.newLine();
                bw.write(ObtenerHASHSHA(pw));
                bw.close();
            } else {
                fichero.createNewFile();
                FileWriter fw = new FileWriter(fichero);
                fw.write(ObtenerHASHSHA(email));
                fw.append("\r\n");
                fw.write(ObtenerHASHSHA(pw));
                fw.close();
            }
        } else if (opcion.equals("V")) {
            System.out.println("Introduce el usuario:");
            email = sc.nextLine();
            System.out.println("Introduce la contraseña:");
            pw = sc.nextLine();
            System.out.println("Introduce el nombre del fichero: (sin la extension)");


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
            File fichero = new File("src/main/ficheros/cifrados/SHA/" + nombreFichero + ".txt");
            Scanner sc2 = new Scanner(fichero);
            String emailFichero = sc2.nextLine();
            String pwFichero = sc2.nextLine();
            if (ObtenerHASHSHA(email).equals(emailFichero) && ObtenerHASHSHA(pw).equals(pwFichero)){
                System.out.println("El usuario es correcto");
            } else {
                System.out.println("El usuario no es correcto");
            }
        } else {
            System.out.println("Opción no válida");
        }

    }

    private static String ObtenerHASHSHA(String textoEntrada) {
        if (textoEntrada.equals("")) {
            return "";
        } else {
            try {
                MessageDigest HashSha = MessageDigest.getInstance("SHA-256");
                byte[] mensajeMatriz = HashSha.digest(textoEntrada.getBytes());
                BigInteger numero = new BigInteger(1, mensajeMatriz);
                StringBuilder hashSHASalida = new StringBuilder(numero.toString(16));

                while (hashSHASalida.length() < 32) {
                    hashSHASalida.insert(0, "0");
                }
                return hashSHASalida.toString();
            } catch (NoSuchAlgorithmException e) {
                System.out.println("Error al obtener el hash: " + e.getMessage());
                return "";
            }
        }
    }
}
