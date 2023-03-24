package com.mycompany.benidormconcurs;

import java.util.Scanner;
class Funcionetes {
    static Scanner teclat = new Scanner(System.in);
    // ----------------------------------------------------------------------------------------
    public static int lligInt(String pregunta) {
        int numero;
        do {
            try {
                System.out.println(pregunta);
                numero = teclat.nextInt();
                teclat.nextLine();
                return numero;
            } catch (java.lang.NumberFormatException e) {
                    System.out.println("");
                    System.out.println(" ________________________________________");
                    System.out.println("|        HA DE SER UN NUMERO ENTER       |");
                    System.out.println("|________________________________________|");
                    System.out.println("");
                teclat.nextLine();
            }
        } while (true); // Bucle infinit fins que retornem el número correcte.
    }
    // ----------------------------------------------------------------------------------------
    public static float lligFloat(String pregunta) {
        float numero;
        do {
            try {
                System.out.println(pregunta);
                numero = teclat.nextFloat();
                teclat.nextLine();
                return numero;
            } catch (java.lang.NumberFormatException e) {
                    System.out.println("");
                    System.out.println(" ________________________________________");
                    System.out.println("|        HA DE SER UN NUMERO ENTER       |");
                    System.out.println("|________________________________________|");
                    System.out.println("");
                teclat.nextLine();
            }
        } while (true); // Bucle infinit fins que retornem el número correcte.
    }
    // ----------------------------------------------------------------------------------------
    public static char lligchar(String pregunta) {
        char lletra;
        System.out.println(pregunta);
        lletra = teclat.nextLine().charAt(0);
        teclat.nextLine();
        return lletra;
    }
    // ----------------------------------------------------------------------------------------
    public static String lligstring(String pregunta) {
        System.out.println(pregunta);
        return teclat.nextLine();
    }
}