package graphique;

import io.Model;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe qui gere les scores du joueur
 * @author Edwin Andino
 */
public class Scores extends AbstractAction {

    private static final int LARGEUR = 300;
    private static final int HAUTEUR = 100;
    private JFrame f;
    private JPanel pan;
    private JLabel texte;
    private Model m;

    public Scores(String texte, Model model) {
        super(texte);
        m = model;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        creer();
    }

    /**
     * Creation du texte du jframe
     *
     * @return les scores du joueur
     */
    private String creerTexte() {
        String info = "<html> Scores: vous n'avez pas gagnez de jeu encore</>";
        return info;
    }

    /**
     * Methode qui creer le graphique pour montrer les scores
     */
    private void creer() {
            f = new JFrame("Scores");
        pan = new JPanel();
        texte = new JLabel(creerTexte());
        pan.add(texte);
        f.add(pan);
        f.setSize(LARGEUR, HAUTEUR);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }

}
