package graphique;

import io.Model;
import io.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe qui affiche l'interface graphique au joueur
 * @author Edwin Andino
 */
public class Vue extends JFrame {

    private Model m;
    private Grille jeu;
    private Controlleur c;
    private Affichage es;
    private final JPanel panelMenu = new JPanel(new BorderLayout());
    private final JPanel panelTime = new JPanel();
    private final JPanel panelMain = new JPanel(new BorderLayout());
    private final JPanel panelMillieu = new JPanel(new GridLayout());
    private Arret pause;
    private JLabel labelTemp;
    private JLabel seconde;
    private JLabel labelDeplacement;
    private static int cptDeplacement = 0;
    private JLabel deplacement;
    private Son debut;

    public Vue() {
        creer();
    }

    /**
     * Methode qui initialise l'interface graphique
     */
    private void creer() {
        es = new Affichage();
        seconde = new JLabel(es.getAffichage(8));
        deplacement = new JLabel(es.getAffichage(9));
        m = new Model(this, es);
        c = new Controlleur(m);
        jeu = new Grille(this, c);
        m.setGrille(jeu);
        Menu laBarre = new Menu(m);

        pause = new Arret();
        pause.addMouseListener(c);
        panelTime.setLayout(null);
        labelTemp = new JLabel(es.getAffichage(10));
        labelTemp.setBounds(20, 4, 80, 15);
        panelTime.add(labelTemp);
        seconde.setBounds(100, 4, 80, 15);
        panelTime.add(seconde);
        labelDeplacement = new JLabel(es.getAffichage(11));
        panelTime.add(labelDeplacement);
        labelDeplacement.setBounds(180, 4, 100, 15);
        panelTime.add(deplacement);
        deplacement.setBounds(300, 4, 100, 15);
        panelMenu.add(laBarre, BorderLayout.WEST);
        panelMenu.add(panelTime);
        panelMain.add(panelMenu, BorderLayout.NORTH);
        panelMillieu.add(jeu);
        panelMain.add(panelMillieu, BorderLayout.CENTER);
        panelMain.add(pause, BorderLayout.SOUTH);
        add(panelMain);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(580, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        debut = new Son("intro.au");
        debut.start();
    }

    /**
     * Methode qui retourne le temps du jeu
     * @return le temps du jeu
     */
    public JLabel getTemps() {
        return seconde;
    }

    /**
     * Methode qui modifie le temps dans le graphique
     * @param modif la nouvelle valeur du temps
     */
    public void setLabelTemps(String modif) {
        seconde.setText(modif);
    }

    /**
     * Methode qui retourne le deplacement du joueur
     * @return la valeur du deplacement
     */
    public JLabel getDeplacement() {
        return deplacement;
    }

    /**
     * creer le jeu si on change de niveau ou redemarre
     * @param n la nouvelle grille de jeu
     */
    public void setJeu(Grille n) {
        panelMillieu.invalidate();
        panelMillieu.removeAll();
        panelMillieu.add(n);
        panelMillieu.revalidate();
        panelMain.add(panelMillieu, BorderLayout.CENTER);
    }

    /**
     * Methode qui retourne le boutton de pause
     * @return le button pause
     */
    public Arret getPause() {
        return pause;
    }

    /**
     * Methode qui met le bon texte sur le button pause
     * @param nouveau texte du button
     */
    public void setPause(String nouveau) {
        pause.setText(nouveau);
    }

    /**
     * Methode qui retourne le model 
     * @return Model
     */
    public Model getModel() {
        return m;
    }

    /**
     * Methode qui retourne le int de deplacement
     * @return compteur de deplacement
     */
    public int getCompteur() {
        return cptDeplacement;
    }

    /**
     * Methode qui met le nombre de deplacement
     * @param nouv nouveau nb de deplacement
     */
    public void setCompteur(int nouv) {
        this.cptDeplacement = nouv;
    }

    /** 
     * Methode qui met le label de deplacement
     * @param nouv nouveau texte
     */
    public void setCompteurLabel(String nouv) {
        deplacement.setText(nouv);
    }

    /**
     * Methode qui retourne le son demander
     * @return le son 
     */
    public Son getSon() {
        return debut;
    }

}
