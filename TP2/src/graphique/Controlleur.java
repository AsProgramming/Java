package graphique;

import io.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Classe qui gere les actions du programme
 * @author Edwin Andino
 */
public class Controlleur extends MouseAdapter implements  ActionListener {

    private final Model mod;
    private static String TEXTE;

    public Controlleur(Model model) {
        mod = model;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        TEXTE = mod.getTexteButton();
        if (TEXTE.equals(mod.getAffichage(0))
                || TEXTE.equals(mod.getAffichage(1))
                || TEXTE.equals(mod.getAffichage(2))
                || TEXTE.equals(mod.getAffichage(3))) {
            mod.verifierTemps(1);
            mod.enPause();
            mod.setTexte(false);
        } else {
            mod.verifierTemps(2);
            mod.finPause();
            mod.setTexte(true);
            mod.remettreJeu();
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        mod.enAnimation();
    }

    @Override
    public void mouseExited(MouseEvent me) {
        TEXTE = mod.getTexteButton();
        if (TEXTE.equals(mod.getAffichage(0))
                || TEXTE.equals(mod.getAffichage(1))
                || TEXTE.equals(mod.getAffichage(2))
                || TEXTE.equals(mod.getAffichage(3))) {
            mod.setTexte(true);
        } else {
            mod.setTexte(false);
        }
        mod.finAnimation();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(mod.getVue().getTemps().getText().equals("00:00")){
                    mod.verifierTemps(0);
        }
        mod.getJeu(ae.getActionCommand());
        mod.getGrille().verifierJeu();
        if(mod.terminer()){
            mod.verifierTemps(3);
        }
    }

}
