package graphique;

import javax.swing.JButton;

/**
 * Objet creer pour le button pause 
 * @author Edwin Andino
 */
public class Arret extends JButton  {

    public Arret() {
        creer();
    }

    private void creer() {
        setText("PAUSE");
        setFocusPainted(false);
        setVisible(true);
    }

    public void setArret(String mot){
        this.setText(mot);
    }
}
