package graphique;

import io.Son;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Classe qui contient la grille du jeu
 *
 * @author Edwin Andino
 */
public class Grille extends JPanel {

    private JButton[][] tab;
    private ArrayList<String> sauver;
    private ArrayList<Integer> dist;
    private Random r;
    private JButton b;
    private Vue v;
    private Son choix;
    private Controlleur c;
    private boolean gagner = false;
    private static int nbCases = 3;
    private static int total;
    private static int alea;

    /**
     * Contructeur vide
     */
    public Grille() {
        creer();
    }

    /**
     * Constructeur prenant la vue et controlleur en parametre
     *
     * @param laVue le graphique du jeu
     * @param cont le controlleur du jeu
     */
    public Grille(Vue laVue, Controlleur cont) {
        v = laVue;
        c = cont;
        creer();
    }

    /**
     * Methode qui creer la grille du jeu avec les buttons vide
     */
    private void creer() {
        setLayout(new GridLayout(nbCases, nbCases));
        total = (nbCases * nbCases) + 1;
        tab = new JButton[nbCases][nbCases];
        r = new Random();
        alea = r.nextInt(total - 1) + 1;
        int nb = 0;
        for (int i = 0; i < nbCases; i++) {
            for (int j = 0; j < nbCases; j++) {
                b = new JButton();
                b.addActionListener(c);
                b.setFocusPainted(false);
                nb++;
                if (nb == alea) {
                    b.setEnabled(false);
                    b.setText(" ");
                }
                tab[i][j] = b;
                add(b);
            }
        }
        remplir();
    }

    /**
     * Methode qui recree la grille de jeu
     *
     * @return la grille de jeu
     */
    public Grille recreer() {
        this.removeAll();
        creer();
        return this;
    }

    /**
     * Methode qui retourne le nombre de case la grille contient
     *
     * @return nombre de case du jeu
     */
    public int getNbCases() {
        return nbCases;
    }

    /**
     * Methode qui modifie le nombre de case dans la grille de jeu
     *
     * @param nouvNb le nouveau nombre de cases
     */
    public void setNbCases(int nouvNb) {
        this.nbCases = nouvNb;
    }

    /**
     * Methode qui met la grille de jeu en pause
     */
    public void enPause() {
        sauvegarder();
        for (int i = 0; i < nbCases; i++) {
            for (int j = 0; j < nbCases; j++) {
                tab[i][j].setText(v.getModel().getAffichage(-1));
                tab[i][j].setEnabled(false);
            }
        }
    }

    /**
     * Methode qui remplit la grille de jeu avec les chiffre
     */
    public void remplir() {
        aleatoire();
        int nb = 0;
        for (int i = 0; i < nbCases; i++) {
            for (int j = 0; j < nbCases; j++) {
                if (tab[i][j].isEnabled()) {
                    tab[i][j].setText(sauver.get(nb));
                    nb++;
                }
            }
        }
        sauver.clear();
        dist.clear();
    }

    public JButton[][] getTab() {
        return tab;
    }

    /**
     * Methode qui permet de chercher la position de button cliquer et de le
     * bouger s'il y a lieu
     *
     * @param s le nombre rechercher dans la grille
     */
    public void rechercher(String s) {
        boolean pasTrouver = true;
        for (int i = 0; i < nbCases && pasTrouver; i++) {
            for (int j = 0; j < nbCases && pasTrouver; j++) {
                if (i < nbCases - 1 && tab[i][j].getText().equals(s)
                        && tab[i + 1][j].getText().equals(" ")) {
                    tab[i + 1][j].setText(tab[i][j].getText());
                    tab[i + 1][j].setEnabled(true);
                    tab[i][j].setEnabled(false);
                    tab[i][j].setText(" ");
                    v.getModel().mettreCourant(v.getCompteur());
                    pasTrouver = false;

                } else if (i > 0 && tab[i][j].getText().equals(s)
                        && tab[i - 1][j].getText().equals(" ")) {
                    tab[i - 1][j].setText(tab[i][j].getText());
                    tab[i - 1][j].setEnabled(true);
                    tab[i][j].setEnabled(false);
                    tab[i][j].setText(" ");
                    v.getModel().mettreCourant(v.getCompteur());
                    pasTrouver = false;
                } else if (j < nbCases - 1 && tab[i][j].getText().equals(s)
                        && tab[i][j + 1].getText().equals(" ")) {
                    tab[i][j + 1].setText(tab[i][j].getText());
                    tab[i][j + 1].setEnabled(true);
                    tab[i][j].setEnabled(false);
                    tab[i][j].setText(" ");
                    v.getModel().mettreCourant(v.getCompteur());
                    pasTrouver = false;
                } else if (j > 0 && tab[i][j].getText().equals(s)
                        && tab[i][j - 1].getText().equals(" ")) {
                    tab[i][j - 1].setText(tab[i][j].getText());
                    tab[i][j - 1].setEnabled(true);
                    tab[i][j].setEnabled(false);
                    tab[i][j].setText(" ");
                    v.getModel().mettreCourant(v.getCompteur());
                    pasTrouver = false;
                } else if (pasTrouver && i == nbCases - 1 && j == nbCases - 1) {
                    choix = new Son("bong.au");
                    choix.start();
                }
            }
        }
    }

    /**
     * Methode qui sauvegarde la position des button dans la grille
     */
    public void sauvegarder() {
        sauver = new ArrayList<>();
        for (int i = 0; i < nbCases; i++) {
            for (int j = 0; j < nbCases; j++) {
                sauver.add(tab[i][j].getText());
            }
        }
    }

    /**
     * Methode qui remet les buttons a la bonne place avec les bons chiffres
     */
    public void finPause() {
        int indice = 0;
        for (int i = 0; i < nbCases; i++) {
            for (int j = 0; j < nbCases; j++) {
                tab[i][j].setText(sauver.get(indice));
                if (!sauver.get(indice).equals(" ")) {
                    tab[i][j].setEnabled(true);
                }
                indice++;
            }
        }
    }

    public void verifierJeu() {
        int indice = 1;
        for (int i = 0; i < nbCases; i++) {
            for (int j = 0; j < nbCases; j++) {
                if (indice != total - 1) {
                    String nombre = Integer.toString(indice);
                    if (tab[i][j].getText().equals(nombre)) {
                        Integer.parseInt(nombre);
                        indice++;
                    }
                } else if (indice == total - 1
                        && tab[i][j].getText().equals(" ")) {
                    gagner = true;
                    choix = new Son("tada.au");
                    choix.start();
                }
            }
        }
    }

    public boolean getGagnant() {
        return gagner;
    }

    public void setGagnant(boolean reset) {
        gagner = reset;
    }

    private void aleatoire() {
        dist = new ArrayList<>();
        r = new Random();
        while (dist.size() < total - 2) {
            int verifier = r.nextInt(total - 2) + 1;
            if (dist.isEmpty()) {
                dist.add(verifier);
            } else if (!dist.contains(verifier)) {
                dist.add(verifier);
            }
        }
        sauver = new ArrayList<>();
        for (int i = 0; i < dist.size(); i++) {
            sauver.add(Integer.toString(dist.get(i)));
        }
    }
}
