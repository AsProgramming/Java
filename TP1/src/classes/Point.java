package classes;

import java.awt.Color;

/**
 * Classe qui gere les coordonnees, la couleur, l'epaisseur du pinceau 
 * @author As'
 */
public class Point {
    
    private int currentX, currentY, oldX, oldY;
    private Color couleur;
    private int largeur = 20, hauteur = 20;
    private int donnees = 255;
    private float pression = 1f;
    private ListeFormes selection = ListeFormes.CARRE;

    public Point() {
    }

    public int getOldX() {
        return oldX;
    }

    public int getOldY() {
        return oldY;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public void setOldY(int oldY) {
        this.oldY = oldY;
    } 
    
    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public void setDonnees(int nb) {
        this.donnees = nb;
    }
    
    public void setLargeur(int nb) {
        this.largeur = nb;
    }

    public void setHauteur(int nb) {
        this.hauteur = nb;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public float getDonnees() {
        if(donnees >= 200){
            pression = 1f;
        }else if(donnees < 200 && donnees > 180){
            pression = 0.5f;
        }else if(donnees <= 150 && donnees > 100){
            pression = 0.3f;
        }else if(donnees <= 100 && donnees > 50){
            pression = 0.1f;
        }else if(donnees <= 50 && donnees > 10){
            pression = 0.05f;
        }else if(donnees <= 10){
            pression = 0.01f;
        }
        return pression;
    }

    public ListeFormes getForme() {
        return selection;
    }

    public void setForme(ListeFormes selection) {
        this.selection = selection;
    }
    
}
