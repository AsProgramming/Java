package actions;

import io.Model;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * Classe qui gere les niveau du jeu
 * @author Edwin Andino
 */
public class ButtonNiveau extends AbstractAction {

    private String ajuster;
    private Model m;
    
    
    public ButtonNiveau(String texte, Model model) {
        super(texte);
        m = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ajuster = e.getActionCommand();
        switch(ajuster){
            case "4 X 4":
                m.setCases(4);
                break;
            case "5 X 5":
                m.setCases(5);;
                break;
            case "6 X 6":
                m.setCases(6);
                break;              
            case "7 X 7":
                m.setCases(7);
                break;
            case "8 X 8":
                m.setCases(8);
                break;
            case "9 X 9":
                m.setCases(9);
                break;
            case "10 X 10":
                m.setCases(10);
                break;                
            default:
                m.setCases(3);
                break;    
        }
    }
    
}
