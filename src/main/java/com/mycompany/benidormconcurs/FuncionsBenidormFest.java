package com.mycompany.benidormconcurs;

import java.util.ArrayList;
import static com.mycompany.benidormconcurs.Pantalla.*;

/**
 * @author Erik Egido Blanes
 */
public class FuncionsBenidormFest {

    /**
     *
     * @return La matriu d'enters amb el tamany de qJutges per qCantants
     */
    static int[][] creaTaulerDeVots() {
        int qjutges = Teclat.lligInt("Dis-me quants jutges hi han", 1);
        int qcantants = Teclat.lligInt("Dis-me quants cantants hi han", 8);
        System.out.println(" ");
        int[][] taulerdevots = new int[qjutges][qcantants];
        for (int i = 0; i < qjutges; i++) {
            for (int j = 0; j < qcantants; j++) {
                taulerdevots[i][j] = 0;
            }
        }
        return taulerdevots;
    }

    /**
     *
     * @param taulerdevots matriu d'enters (vots)
     */
    static void fesVotacions(int[][] taulerdevots) {
        for (int i = 0; i < taulerdevots.length; i++) {
            votaJutge(taulerdevots, i);
        }
    }

    /**
     *
     * @param taulerdevots matriu d'enters (vots)
     * @param nJutge núm del jutge
     */
    static void votaJutge(int[][] taulerdevots, int nJutge) {

        titol("Vota el jutge número " + (nJutge + 1));
        for (int n_ordre = 1; n_ordre <= 8; n_ordre++) {
            votaJutgeACantant(taulerdevots, nJutge, n_ordre);
        }

    }

    /**
     *
     * @param taulerdevots matriu d'enters (vots)
     * @param nJutge núm del jutge
     * @param n_ordre núm de votació
     */
    static void votaJutgeACantant(int[][] taulerdevots, int nJutge, int n_ordre) {

        int nCantant = Teclat.lligInt(puntsSegonsOrdre(n_ordre) + " punts per al cantant: ", 1, taulerdevots[0].length);
        nCantant--;
        while (taulerdevots[nJutge][nCantant] > 0) {
            System.out.println("\n ______________________________________________");
            System.out.println("|     EL CANTANT INDICAT JA HA SIGUT VALORAT   |");
            System.out.println("|              INDICA ALTRE CANTANT            |");
            System.out.println("|______________________________________________|\n");

            nCantant = Teclat.lligInt(puntsSegonsOrdre(n_ordre) + " punts per al cantant: ", 1, taulerdevots[0].length);
            nCantant--;
        }
        taulerdevots[nJutge][nCantant] = puntsSegonsOrdre(n_ordre);

    }

    /**
     *
     * @param n_ordre núm per a fer votacions
     * @return punts que vols ficar a un cantant
     */
    static int puntsSegonsOrdre(int n_ordre) {
        int punts = 0;

        switch (n_ordre) {
            case 1:
                punts = 2;
                break;
            case 2:
                punts = 4;
                break;
            case 3:
                punts = 5;
                break;
            case 4:
                punts = 6;
                break;
            case 5:
                punts = 7;
                break;
            case 6:
                punts = 8;
                break;
            case 7:
                punts = 10;
                break;
            case 8:
                punts = 12;
                break;
        }
        return punts;
    }

    /**
     *
     * @param taulerdevots matriu d'enters (vots)
     */
    static void mostraPuntuacions(int[][] taulerdevots, ArrayList<String> llistaC) {
        //primera linea
        System.out.println("                              " + " ______ ".repeat(taulerdevots.length));

        // segona linea e index dels jutges
        System.out.print("                              ");
        for (int i = 1; i <= taulerdevots.length; i++) {
            System.out.print("|  " + String.format("%02d", i) + "  |");
        }
        System.out.println("");

        System.out.println(" ______ ______________________"+ "|______|".repeat(taulerdevots.length));

        for (int i = 0; i < taulerdevots[0].length; i++) {
            puntsCantant(taulerdevots, i);
            System.out.print("|  " + String.format("%02d", (i + 1)) + "  | ");
            System.out.printf(" %-20s", (llistaC.get(i) + ("                    ")).substring(0, 20));
            for (int a = 0; a < taulerdevots.length; a++) {
                System.out.print("|  " + String.format("%02d", taulerdevots[a][i]) + "  |");
            }
            System.out.println(" ");
            System.out.println("|______|______________________" + "|______|".repeat(taulerdevots.length));
        }

    }

    /**
     *
     * @param taulerdevots matriu d'enters (vots)
     * @param cantant núm del cantant
     * @return punts totals d'un cantant
     */
    static int puntsCantant(int[][] taulerdevots, int cantant) {
        int punts = 0;
        for (int jutge = 0; jutge < taulerdevots.length; jutge++) {
            punts = punts + taulerdevots[jutge][cantant];
        }
        return punts;
    }

    /**
     *
     * @param taulerdevots matriu d'enters (vots)
     * @return núm de cantant amb més punts
     */
    static int guanyador(int[][] taulerdevots) {
        int puntsCantantGuanyador = 0;
        int nCantantGuanyador = 0;
        for (int i = 0; i < taulerdevots[0].length; i++) {
            int pcant = puntsCantant(taulerdevots, i);

            if (pcant > puntsCantantGuanyador) {
                puntsCantantGuanyador = pcant;
                nCantantGuanyador = i;
            }
        }

        return nCantantGuanyador;
    }

    /**
     *
     * @param n quantitat a repetir el caracter "*"
     */
    static void liniaPunts(int n) {
        if (n == 0) {
            System.out.println(" ");
        } else {
            if (n > 0) {
                System.out.print("*");
                liniaPunts(n - 1); // crida la funció recursivament amb n-1
            }
        }

    }

    /**
     *
     * @param taulerdevots matriu de
     * @return true o false indicant si hian participants no votat
     */
    static boolean hiHaNoVotats(int[][] taulerdevots) {
        boolean hiHaNoVotats = false;
        for (int i = 0; i < taulerdevots[0].length; i++) {
            if (puntsCantant(taulerdevots, i) <= 0) {
                hiHaNoVotats = true;
                break;
            }
        }
        return hiHaNoVotats;
    }

    /**
     *
     * @param taulerdevots matriu de vots
     * @param nCantant núm de cantant
     * @return tipus de cantant
     */
    static String tipusCantant(int[][] taulerdevots, int nCantant) {
        String tipus = " ";
        int pCantant = puntsCantant(taulerdevots, nCantant);

        if (pCantant >= 0 && pCantant < 11) {
            tipus = "roïn";
        } else {
            if (pCantant < 21) {
                tipus = "regular";
            } else {
                if (pCantant < 31) {
                    tipus = "bo";
                } else {
                    if (puntsCantant(taulerdevots, nCantant) > 30) {
                        tipus = "crack";
                    }
                }
            }
        }
        return tipus;
    }

    static ArrayList<String> nomsCançons(int qCançons) {
        ArrayList<String> nCanço = new ArrayList<String>();
        for (int i = 0; i < qCançons; i++) {
            String canço = Teclat.lligString("Dis-me el nom de la canço " + (i + 1) + " : ");
            nCanço.add(canço);
        }
        return nCanço;
    }

}
