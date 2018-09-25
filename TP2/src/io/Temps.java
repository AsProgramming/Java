package io;

/**
 * Classe qui gere les secondes du jeu
 *
 * @author Edwin Andino
 */
public class Temps extends Thread {

    private Model m;
    private boolean continuer;
    private int secondes = 0;
    private int minutes = 0;

    public Temps() {
    }

    public Temps(Model model) {
        m = model;
    }

    @Override
    public void run() {
        try {
            while (continuer) {
                if (secondes <= 58) {
                    secondes++;
                    m.setTemps(secondes, minutes);
                } else if (secondes == 59 && minutes <= 59) {
                    secondes = 0;
                    minutes++;
                    m.setTemps(secondes, minutes);
                }
                Thread.sleep(1000);
            }

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void setContinuer(boolean arret){
        continuer = arret;
    }

    void mettreAZero() {
        secondes = 0;
        minutes = 0;
    }

}
