/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaccia;

import java.awt.Color;
import java.util.Random;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementa Runnnable per poter far partire unThread che cambia losfondo della "SchermataPrincipale"
 * 
 * Il Thread ha 2 fasi, nella prima sceglie uno tra i colori prdefiniti casualmente,
 * nella seconda, decrementa o incrementa i valori RGB dello sfondo attuale scegliendo
 * sempre casualmente se incrementare R o G o B finchè tutti e 3 non raggiungono un intorno
 * del colore prestabilito come obbiettivo
 * 
 * per fare ciò utilizza un interfaccia funzionale Consumer che ormette di cambiare lo sfondo
 * 
 * @author Giuseppe
 */
public class ColoreSfondo implements Runnable{

        private final Color VERDE_ACQUA = new Color(163, 231, 214);
        private final Color ARANCIONE = new Color(230, 212, 162);
        private final Color BLU_COBALTO = new Color(30, 33, 61);
        
        private Color coloreAttuale;
        
        Consumer background;
        
        
        Random numeroCasuale = new Random();
        
        public ColoreSfondo(int rOg, int gOg, int bOg, Consumer<Color> background){
            
            coloreAttuale = new Color(rOg, gOg, bOg);
            this.background = background;
        }
        
        
        @Override
        public void run() {
            
            Color coloreScelto = null;
            boolean raggiuntoR;
            boolean raggiuntoG;
            boolean raggiuntoB;
            
            boolean running = true;
            
            while(running){
                
                raggiuntoR = false;
                raggiuntoG = false;
                raggiuntoB = false;
                
                switch (numeroCasuale.nextInt(3)) {
                case 0 -> coloreScelto = VERDE_ACQUA;
                case 1 -> coloreScelto = ARANCIONE;
                case 2 -> coloreScelto = BLU_COBALTO;
                default -> {
                    }
                }
                
                while (!raggiuntoR || !raggiuntoG || !raggiuntoB) {
                
                    int num = numeroCasuale.nextInt(3);
                    if (num == 0 && !raggiuntoR) {
                        if(coloreScelto.getRed() > coloreAttuale.getRed()){
                            coloreAttuale = new Color(coloreAttuale.getRed() + 3,coloreAttuale.getGreen(), coloreAttuale.getBlue());
                            background.accept(coloreAttuale);
                            sleepThread();
                        }else {
                            coloreAttuale = new Color(coloreAttuale.getRed() - 3,coloreAttuale.getGreen(), coloreAttuale.getBlue());
                            background.accept(coloreAttuale);
                            sleepThread();
                        }
                        raggiuntoR = controlloValoreRaggiunto(coloreScelto.getRed(),
                            coloreAttuale.getRed());
                        
                    } else if (num == 1 && !raggiuntoG){
                        if(coloreScelto.getGreen() > coloreAttuale.getGreen()){
                            coloreAttuale = new Color(coloreAttuale.getRed(),coloreAttuale.getGreen() + 3, coloreAttuale.getBlue());
                            background.accept(coloreAttuale);
                            sleepThread();
                        }else {
                            coloreAttuale = new Color(coloreAttuale.getRed(),coloreAttuale.getGreen() - 3, coloreAttuale.getBlue());
                            background.accept(coloreAttuale);
                            sleepThread();
                        }
                        raggiuntoG = controlloValoreRaggiunto(coloreScelto.getGreen(),
                            coloreAttuale.getGreen());
                    } else if (num == 2 && !raggiuntoB){
                        if(coloreScelto.getBlue() > coloreAttuale.getBlue()){
                            coloreAttuale = new Color(coloreAttuale.getRed(),coloreAttuale.getGreen(), coloreAttuale.getBlue() + 3);
                            background.accept(coloreAttuale);
                            sleepThread();
                        }else {
                            coloreAttuale = new Color(coloreAttuale.getRed(),coloreAttuale.getGreen(), coloreAttuale.getBlue() - 3);
                            background.accept(coloreAttuale);
                            sleepThread();
                        }
                        raggiuntoB = controlloValoreRaggiunto(coloreScelto.getBlue(),
                            coloreAttuale.getBlue());
                    }
                }
            }
        }
        
        
        private void sleepThread(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ColoreSfondo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        private boolean controlloValoreRaggiunto ( int valoreObbiettivo, int valoreAttuale){
            boolean raggiunto = false;
            //controlliamo il valore attuale rispetto ad un intprno del calore Obbiettivo
            if(valoreObbiettivo - 6 < valoreAttuale && valoreAttuale < valoreObbiettivo + 6){
                raggiunto = true;
            }
            return raggiunto;
        }
}
