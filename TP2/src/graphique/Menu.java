package graphique;

import io.Model;
import actions.*;
import io.*;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 * Classe qui creer le menu du graphique
 * @author Edwin Andino
 */
public class Menu extends JPanel {

    private final Model m;
    private JMenuItem menuRedemarrer;
    private JMenuItem menuScore;
    private JMenuItem menuFermer;
    private JMenuItem instructions;
    private JMenuItem menuApropos;
    private JMenuItem niveau;
    private final JMenu menuFichier = new JMenu("Fichier");
    private final JMenu menuAide = new JMenu("Aide");
    private final JMenu menuNiveau = new JMenu("Niveau");
    private final JMenuBar laBarre = new JMenuBar();

    public Menu(Model model) {
        m = model;
        creer();
    }

    private void creer() {
        menuFermer = new JMenuItem(new ButtonFermer("Fermer"));
        menuApropos = new JMenuItem(new ButtonAPropos("A propos"));
        instructions = new JMenuItem(new ButtonInstruction("Instructions"));
        menuRedemarrer = new JMenuItem(new ButtonRedemarrer("Redemarrer", m));
        menuScore = new JMenuItem(new Scores("Scores eleves", m));
        menuFichier.add(menuRedemarrer);
        for (int i = 3; i < 11; i++) {
            niveau = new JMenuItem(new ButtonNiveau(i + " X " + i, m));
            menuNiveau.add(niveau);
        }
        menuFichier.add(menuNiveau);
        menuFichier.add(menuScore);
        menuFichier.add(menuFermer);
        menuAide.add(instructions);
        menuAide.add(menuApropos);
        laBarre.add(menuFichier);
        laBarre.add(menuAide);
        laBarre.add(new JSeparator(SwingConstants.VERTICAL));
        setLayout(new BorderLayout());
        add(laBarre, BorderLayout.NORTH);
    }
}
