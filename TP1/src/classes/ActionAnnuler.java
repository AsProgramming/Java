package classes;

import java.awt.Color;
import javax.swing.undo.AbstractUndoableEdit;

/**
 * Classe qui s'occupe du Annuler/Refaire mais pas arriver a completer
 * @author As'
 */
public class ActionAnnuler extends AbstractUndoableEdit {
    
    private int currentX, currentY, oldX, oldY, largeur, hauteur;
    private Color couleur;
    private float pression;
    private ListeFormes forme;
    
    public ActionAnnuler(Point p, int nombre){
        if(nombre==1){
            oldX = p.getOldX();
            oldY = p.getOldY();
        }else{
            currentY = p.getCurrentY();
            currentX = p.getCurrentX();
        }
        couleur = p.getCouleur();
        pression = p.getDonnees();
        forme = p.getForme();
    }
    
    public void annuler(){
        super.undo();
        //remove p;
    }
    
    public void refaire(){
        super.redo();
    }
}
