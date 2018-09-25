package actions;

import io.Model;

/**
 * Classe qui gere l'expansion du button pause
 * @author Edwin  Andino
 */
public class Animation implements Runnable {

    private static Model m;
    private static String texte;

    public Animation(Model md) {
        m = md;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(m.getDelai(2));
            for (int i = 0; i < m.getDelai(0); i++) {
                texte = m.getTexteButton();
                if (texte.equals(m.getAffichage(0))) {
                    m.setAnimation(m.getAffichage(3));
                    Thread.sleep(m.getDelai(0));
                    m.setAnimation(m.getAffichage(2));
                    Thread.sleep(m.getDelai(0));
                    m.setAnimation(m.getAffichage(1));
                    Thread.sleep(m.getDelai(0));
                    m.setTexte(true);
                } else {
                    m.setAnimation(m.getAffichage(4));
                    Thread.sleep(m.getDelai(0));
                    m.setAnimation(m.getAffichage(5));
                    Thread.sleep(m.getDelai(0));
                    m.setAnimation(m.getAffichage(6));
                    Thread.sleep(m.getDelai(0));
                    m.setTexte(false);
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
