package io;

import actions.Animation;
import graphique.Grille;
import graphique.Vue;

/**
 * Classe qui gere l'interaction entre la vue et les donnees du programme
 *
 * @author Edwin Andino
 */
public class Model implements IES {

    private Vue v;
    private Grille j;
    private Animation gif;
    private Thread t;
    private Son son;
    private Affichage es;
    private Temps s;

    public Model() {
    }

    public Model(Vue laVue, Affichage aff) {
        es = aff;
        v = laVue;
    }

    public Model(Vue laVue, Grille jeu, Affichage aff) {
        es = aff;
        v = laVue;
        j = jeu;
    }

    public void setGrille(Grille jeu) {
        this.j = jeu;
    }

    public void setCases(int nb) {
        j.setNbCases(nb);
        mettreCourant(-1);
        j.recreer();
        v.setJeu(j);
    }

    public void redemarrer() {
        if (v.getCompteur() != 0) {
            mettreCourant(-1);
            verifierTemps(3);
            v.setLabelTemps(es.getAffichage(8));
        } else if (!v.getTemps().getText().equals(es.getAffichage(8))) {
            verifierTemps(3);
            v.setLabelTemps(es.getAffichage(8));
        }
        setCases(j.getNbCases());
    }

    public void enPause() {
        j.enPause();
        son = new Son("enpause.au");
        son.start();
        v.setJeu(j);
    }

    public void enAnimation() {
        gif = new Animation(this);
        t = new Thread(gif);
        t.start();
    }

    public void finAnimation() {
        t.stop();
    }

    public void setTexte(boolean choix) {
        if (choix) {
            v.getPause().setArret(es.getAffichage(0));
        } else {
            v.getPause().setArret(es.getAffichage(7));
        }
    }

    public void finPause() {
        son.arret();
    }

    public void setAnimation(String img) {
        v.getPause().setArret(img);
    }

    public String getTexteButton() {
        return v.getPause().getText();
    }

    public Vue getVue() {
        return v;
    }

    @Override
    public String getAffichage(int indice) {
        return es.getAffichage(indice);
    }

    @Override
    public int getDelai(int indice) {
        return es.getDelai(indice);
    }

    public void getJeu(String s) {
        j.rechercher(s);
    }
    
    public Grille getGrille(){
        return j;
    }

    public void remettreJeu() {
        j.finPause();
    }

    public void mettreCourant(int nb) {
        nb++;
        v.setCompteur(nb);
        String tmp = Integer.toString(nb);
        v.setCompteurLabel(tmp);
    }

    /**
     * Methode qui modifie le temps sur le graphique
     * @param sec secondes 
     * @param mins minutes
     */
    public void setTemps(int sec, int mins) {
        String nouvSec = Integer.toString(sec);
        String nouvMin = Integer.toString(mins);
        if (sec < 10 && mins < 10) {
            nouvSec = "0" + mins + ":0" + nouvSec;
            v.setLabelTemps(nouvSec);
        } else if (sec > 10 && mins < 10) {
            nouvSec = "0" + mins + ":" + nouvSec;
            v.setLabelTemps(nouvSec);
        } else if (sec > 10 && mins >= 10) {
            nouvSec = mins + ":" + nouvSec;
            v.setLabelTemps(nouvSec);
        } else if (sec < 10 && mins > 10) {
            nouvSec = mins + ":0" + nouvSec;
            v.setLabelTemps(nouvSec);
        }
    }

    /**
     * Methode qui met le bon label sur le graphique
     * @param indice 
     */
    public void verifierTemps(int indice) {
        if (indice == 0) {
            s = new Temps(this);
            s.setContinuer(true);
            s.start();
        } else if (indice == 1) {
            s.suspend();
            //s.setContinuer(false);
        } else if (indice == 2) {
            s.resume();
            //  s.setContinuer(true);
        } else {
            s.stop();
            s.mettreAZero();
        }
    }
    
    /**
     * Methode qui verifie si le joueur a gagner
     * @return 
     */
    public boolean terminer(){
        return j.getGagnant();
    }

}
