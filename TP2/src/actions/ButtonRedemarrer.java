package actions;

import io.Model;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * Classe qui gere l'action du menu redemarrer
 * @author Edwin Andino
 */
public class ButtonRedemarrer extends AbstractAction {

    private final Model m;
    
    public ButtonRedemarrer(String texte, Model model) {
        super(texte);
        m = model;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        m.getGrille().setGagnant(false);
        m.redemarrer();
    }
    
}
