package io;

import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Classe qui gere les sons du jeu
 *
 * @author Edwin Andino
 */
public class Son extends Thread {

    private String nom;
    private static AudioStream audioStream;
    private static InputStream inputStream;

    public Son() {
    }

    public Son(String extrait) {
        nom = extrait;
    }

    @Override
    public void run() {
        try {
            inputStream = getClass().
                    getResourceAsStream("/io/media/" + nom);
            audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setExtrait(String nouv){
        nom = nouv;
    }

    public void arret(){
        AudioPlayer.player.stop(audioStream);
    }    
}
