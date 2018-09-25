package actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe qui instruit l'utilisateur au regle du jeu
 * @author Edwin Andino
 */
public class ButtonInstruction extends AbstractAction {

    private static final int LARGEUR = 300;
    private static final int HAUTEUR = 100;
    private JFrame f;
    private JPanel pan;
    private JLabel texte;

    public ButtonInstruction(String texte) {
        super(texte);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        creer();
    }

    /**
     * Creation du texte du jframe
     * @return les regles du jeu
     */
    private String creerTexte() {
        String info = "<html> Instructions: Le but du jeu est de placer"
                + "<br>les cases de chiffre en ordre croissant</br>"
                + "<br> 1, 2, 3, 4, 5...alors vous avez gagne!</>";
        return info;
    }

    /**
     * Methode qui creer le graphique pour montrer les instructions
     */
    private void creer() {
        f = new JFrame("Instructions");
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
