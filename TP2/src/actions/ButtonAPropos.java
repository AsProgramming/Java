package actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe qui dit a l'utilisateur qui a creer le jeu
 * @author Edwin Andino
 */
public class ButtonAPropos extends AbstractAction {

    private static final String CHEMIN = "/io/media/logo.jpg";
    private static final String TITRE = "A propos";
    private static final String CLASSE = "  Programmation Oriente Objet";
    private static final int LARGEUR = 450;
    private static final int HAUTEUR = 200;
    private JFrame f;
    private JPanel panel;
    private JPanel panelHaut;
    private JLabel label;
    private JLabel labelTitre;
    private JLabel nom;
    private ImageIcon logo;

    public ButtonAPropos(String texte) {
        super(texte);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        creer();
    }
    
    /**
     * Methode qui creer le graphique pour montrer les info du programme
     */
    private void creer() {
        f = new JFrame(TITRE);
        panel = new JPanel(new BorderLayout());
        label = new JLabel();
        nom = new JLabel(creerTexte());
        nom.setForeground(Color.BLACK);
        labelTitre = new JLabel(CLASSE);
        labelTitre.setForeground(Color.BLACK);
        panelHaut = new JPanel();
        panelHaut.setBackground(Color.LIGHT_GRAY);
        panelHaut.add(labelTitre);
        f.setSize(LARGEUR, HAUTEUR);
        logo = new ImageIcon(getClass().
                getResource(CHEMIN));
        label.setIcon(logo);
        panel.add(label, BorderLayout.WEST);
        panel.add(panelHaut, BorderLayout.NORTH);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(nom);
        f.add(panel);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }
    /**
     * Creation du texte du jframe
     * @return les info du createur
     */
    private String creerTexte() {
        String info = "<html> Programmeur: Edwin Andino"
                + "<br>College Bois-de-Boulogne</br>"+
                "<br> Session III</>";
        return info;
    }

}
