package tp1;

import graphique.Fenetre;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Programme de paint (Il y a eu un probleme en generant la Javadoc
 * @author As'
 */
public class TP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Fenetre tp1 = new Fenetre();

        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | UnsupportedLookAndFeelException ex) {
        Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
