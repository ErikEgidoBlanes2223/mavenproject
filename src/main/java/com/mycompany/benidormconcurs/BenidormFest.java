package com.mycompany.benidormconcurs;

import static com.mycompany.benidormconcurs.FuncionsBenidormFest.*;
import static com.mycompany.benidormconcurs.Pantalla.*;
import java.util.ArrayList;

/**
 *
 * @author Erik Egido Blanes
 */
public class BenidormFest {

    public static void main(String[] args) {
        int[][] taulerdevots;
        System.out.println(" _________________________________ ");
        System.out.println("|                                 |");
        System.out.println("|          BENIDORM FEST          |");
        System.out.println("|                                 |");
        System.out.println("|    ACTIVITAT REALITZADA PER     |");
        System.out.println("|       ERIK EGIDO BLANES         |");
        System.out.println("|_________________________________|");
        
        taulerdevots = creaTaulerDeVots();
        int qCantants = taulerdevots[0].length;
        ArrayList<String> llistaCançons;
        llistaCançons = nomsCançons(qCantants);

        fesVotacions(taulerdevots);
        mostraPuntuacions(taulerdevots, llistaCançons);
        int nGuanyador = guanyador(taulerdevots);
        int pGuanyador = puntsCantant(taulerdevots, nGuanyador);

        titol(" El guanyador ha sigut el cantant " + (nGuanyador + 1) + " amb la canço "+llistaCançons.get(nGuanyador) +" amb "+ pGuanyador + " punts ");

        liniaPunts(pGuanyador);

        titol(" Tipus de cantants");
        for (int i = 0; i < taulerdevots[0].length; i++) {
            System.out.println("- El cantant " + (i + 1) + " és " + tipusCantant(taulerdevots, i));
        }
        System.out.println(" ");

        if (hiHaNoVotats(taulerdevots) == true) {
            titol("Algun cantant no ha tingut vots");
        } else {
            titol("Tots els cantants han tingut vots");
        }

    }
}
