package DeMar.src;

import javax.swing.*;
import java.awt.*;

public class resaltarCampo extends Thread {
    
    //Atributos
    private JComponent componente;
    private Color resaltado;
    private int repeticiones;

    //Constructores
    public resaltarCampo(JComponent componente, Color resaltado, int repeticiones){
        this.componente = componente;
        this.resaltado = resaltado;
        this.repeticiones = repeticiones;
    }

    //Encapsulamiento
    public void setComponente(JComponent componente){
        this.componente = componente;
    }
    public void setResaltado(Color resaltado){
        this.resaltado = resaltado;
    }
    public void setRepeticiones(int repeticiones){
        this.repeticiones = repeticiones;
    }

    @Override //Ejecución del hilo
    public void run(){
        try {
            Color colorActual = componente.getBackground();

            for(int j=0; j<repeticiones; j++){
                componente.setBackground(resaltado);
                sleep(200);
                componente.setBackground(colorActual);
                sleep(200);
            }
        } catch (InterruptedException ex) {
            System.out.println("El hilo acaba de ser interrumpido por otro ( •_•)>⌐■-■");
        } catch (Exception e){
            //Excepción general.
        }
    }
}
