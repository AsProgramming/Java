/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

/**
 * Classe qui contient le texte a mettre sur le graphique
 * @author Edwin Andino
 */
public class Affichage implements IES {

    private static final int DELAI = 100;
    private static final int DELAI2 = 2500;
    private static final String AFFICHE3 = "P   A   U   S   E";
    private static final String AFFICHE2 = "P  A  U  S  E";
    private static final String AFFICHE = "P A U S E";
    private static final String ARRET = "PAUSE";
    private static final String DEPART4 = "S   T   A   R   T";
    private static final String DEPART3 = "S  T  A  R  T";
    private static final String DEPART2 = "S T A R T";
    private static final String DEPART = "START";
    private static final String SCIE = "Zzz...";
    private static final String TPS = "Temps :: ";
    private static final String MVMT = "Deplacement :: ";    
    private static String TEMPS = "00:00";
    private static String COMPTEUR = "0";
    
    
    public Affichage(){}

    @Override
    public String getAffichage(int indice) {
        switch (indice) {           
            case -1:
                return SCIE;            
            case 1:
                return AFFICHE;
            case 2:
                return AFFICHE2;
            case 3:
                return AFFICHE3;
            case 4:
                return DEPART2;
            case 5:
                return DEPART3;
            case 6:
                return DEPART4;                
            case 7:
                return DEPART;   
            case 8:
                return TEMPS;
            case 9:
                return COMPTEUR;
            case 10:
                return TPS;
            case 11:
                return MVMT;                  
            default:
                return ARRET;
        }
    }

    @Override
    public int getDelai(int indice) {
        switch (indice) {
            case 2:
                return DELAI2;
            default:
                return DELAI;
        }
    }

}
