package classes;

/**
 * Classe qui gere le type de forme du pinceau
 * @author As'
 */
public enum ListeFormes {
  CARRE(0, "Carre"), 
  CERCLE(1, "Cercle"), 
  TRIANGLE(2, "Triangle");
  
  private int numero;
  private String nom;
  private int x[] = {20,22,4};
  private int y[] = {20,32,20};
  
    private ListeFormes(int numero, String nom) {
        this.numero = numero;
        this.nom = nom;
    }

    public void setX(int courant, int largeur) {
        this.x[0] = courant - largeur;
        this.x[1] = courant + largeur;
        this.x[2] = courant;
    }

    public void setY(int courant, int largeur) {
        this.y[0] = courant + largeur;
        this.y[1] = courant + largeur;
        this.y[2] = courant - largeur;
    }

    public int[] getY() {
        return y;
    }

    public int[] getX() {
        return x;
    }
}
