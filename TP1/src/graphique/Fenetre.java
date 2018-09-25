package graphique;

import classes.FeuilleDessin;
import classes.Point;
import javax.swing.JFrame;

/**
 *
 * @author As'
 */
public class Fenetre extends JFrame {
    private static final int LARGEUR = 800;
    private static final int HAUTEUR = 600;
    
    public Fenetre(){
        Point p = new Point();
        Palette choix = new Palette();
        FeuilleDessin dessin = new FeuilleDessin(p,400,400);
        Contenu fen = new Contenu(p, choix);

        fen.setSize(LARGEUR, HAUTEUR);
        fen.setTitle("Painenator");
        fen.setSize(800, 600);
        fen.setVisible(true);
        fen.setResizable(false);
        fen.setLocationRelativeTo(null);
    }


}
