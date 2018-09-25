package classes;

import graphique.Palette;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoManager;

/**
 * Classe qui gere les actions sur le carre de dessin
 * @author As'
 */
public class FeuilleDessin extends JComponent {

    private Image image;
    private int largFeuille = 400;
    private int hautFeuille = 400;
    private Point p1;
    private Palette selection;
    private BufferedImage arrierePlan;
    private Color couleur;
    private ListeFormes pinceau;
    private Graphics2D g2;
    private Palette couleurPalette;
    private UndoManager annuler = new UndoManager();
    
    public FeuilleDessin(Point p, int lrgFeuille, int hautFeuille){
        p1 = p;
        
        this.setBounds(200, 80, lrgFeuille, hautFeuille);
            addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                p1.setOldX(e.getX());
                p1.setOldY(e.getY());
                annuler.undoableEditHappened(new UndoableEditEvent(g2,
                        new ActionAnnuler(p1,1)));
                Graphics2D g2d = (Graphics2D) g2 ;
                pinceau = p1.getForme();
                    float alpha = p1.getDonnees();
                    g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
                    switch(pinceau){
                        case CERCLE:
                            g2d.setColor(p1.getCouleur());
                            g2d.fillOval(p1.getOldX(), p1.getOldY(), 
                            p1.getHauteur(), p1.getLargeur());
                            
                            break;
                        case TRIANGLE:
                            pinceau.setX(p1.getOldX(), p1.getLargeur());
                            pinceau.setY(p1.getOldY(), p1.getHauteur());
                            g2d.setColor(p1.getCouleur());
                            g2d.fillPolygon(pinceau.getX(),pinceau.getY(),3);
                            break;
                        default:
                            g2d.setColor(p1.getCouleur());
                            g2d.fillRect(p1.getOldX(), p1.getOldY(), 
                            p1.getHauteur(), p1.getLargeur());    
                    }
        repaint();
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                annuler.undoableEditHappened(new UndoableEditEvent(g2,
                        new ActionAnnuler(p1,2)));
            }
            
        });
            addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent e) {
                p1.setCurrentX(e.getX());
                p1.setCurrentY(e.getY());
                if(g2 !=null){
                    Graphics2D g2d = (Graphics2D) g2;
                    pinceau = p1.getForme();
                    float alpha = p1.getDonnees();
                    g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
                    switch(pinceau){
                        case CERCLE:
                            g2d.setColor(p1.getCouleur());
                            g2d.fillOval(p1.getCurrentX(), p1.getCurrentY(), 
                            p1.getHauteur(), p1.getLargeur());
                            
                            break;
                        case TRIANGLE:
                            pinceau.setX(p1.getCurrentX(), p1.getLargeur());
                            pinceau.setY(p1.getCurrentY(), p1.getHauteur());
                            g2d.setColor(p1.getCouleur());
                            g2d.fillPolygon(pinceau.getX(),pinceau.getY(),3);
                            break;
                        default:
                            g2d.setColor(p1.getCouleur());
                            g2d.fillRect(p1.getCurrentX(), p1.getCurrentY(), 
                            p1.getHauteur(), p1.getLargeur());    
                    }
                    repaint();
                    p1.setOldX(p1.getCurrentX());
                    p1.setOldY(p1.getCurrentY());
                }
            }
            
        
        });  
            
            
            
    }

        @Override
    protected void paintComponent(Graphics g) {
        if (arrierePlan == null){
            try {
                arrierePlan = ImageIO.read(getClass().getResource("/classes/"
                        + "images/damier.png"));
                
            } catch (IOException ex) {

            }
            g2 = (Graphics2D) arrierePlan.createGraphics();
                clear();
                
        }
 
        g.drawImage(arrierePlan, 0, 0, this);
        
    }
    
    public void clear(){
            try {
            arrierePlan = 
            ImageIO.read(getClass().getResource("/classes/images/damier.png"));
                
            } catch (IOException ex) {
            }
        g2 = (Graphics2D) arrierePlan.createGraphics();
        g2.setPaint(Color.black);
        repaint();
    }
    
    public void remplir(Color couleurArriere){
        couleur = couleurArriere;
        g2.setPaint(couleurArriere);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        repaint();
        g2.setPaint(p1.getCouleur());
    }
    
    public void selection(Point p){
        g2.setPaint(p.getCouleur());
    }
    
    public void couleurChoisie(){       
        couleur = selection.getCouleur();
        remplir(couleur);  
    }
    
    public void choisirCouleur(int panneau) {
        selection = new Palette(this, p1, panneau);
        selection.setVisible(true);
        selection.setLocationRelativeTo(null);
    }
    
    public Graphics2D getG2(){
        return this.g2;
    }
    
    public void setG2(Graphics2D nouveau){
        this.g2 = nouveau;
    }

    public void setHautFeuille(int hautFeuille) {
        this.hautFeuille = hautFeuille;
    }

    public void setlargFeuille(int lrgFeuille) {
        this.largFeuille = lrgFeuille;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    
    
}
