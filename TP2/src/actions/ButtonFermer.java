package actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * Classe qui gere le menu quitter
 * @author Edwin Andino
 */
public class ButtonFermer extends AbstractAction {

    public ButtonFermer(String texte) {
        super(texte);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }

}
