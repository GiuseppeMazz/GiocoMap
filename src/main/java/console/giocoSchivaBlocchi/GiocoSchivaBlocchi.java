/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package console.giocoSchivaBlocchi;

import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import tempo.Cronometro;

/**
 *
 * spiegazione del funzionamento:
 * 
 * C'è un blocco (player chiamato incorrettamente quadrato) che può fare sopra e sotto,
 * si fa partire un thread di Spawn blocchi che crea e aggiunge una Barriera e la cala
 * in una delle due corsie (sopra, sotto) a seconda di un numero casuale,
 * arrivato all'altzza giusta parte il thread della rispettiva barriera facendolo
 * partire verso sinistra, tramite l'interfaccia UpdateDalThread che ha implementato i metodi in
 * spawnBlocchi, viene passata l'istanza di spawnblocchi in modo che ilBarriera potrà chiamare i metodi 
 * controllaCollisione e distruggiBarriera.
 * 
 * Nel mentre SpawnBlocchi reinizia la procedura (in quanto thread indipendente), nel mentre i
 * singoli thread delle barriere indipendentemente vanno verso sinistra finchè non entrano nella X
 * del lato destro del quadrato a quel punto chiama controllaCollisione (dell'interfaccia) in modo da vedere se il quadrato
 * si trova nella stessa corsia, altrimenti avanza, continua con questo controllo finchè non supera 
 * completamente il quadrato, a tal punto continua ad avanzare fino al limite sinistro del jframe,
 * toccato il bordo si chiama distruggiBarriera (dell'interfaccia) per eliminare il blocco dal jframe.
 * Se invece il controllaCollisione risulta che le corsie corrispondono si ferma tutto e si rimuovono
 * tutti gli elementi dal contentPaned del Jframe
 * 
 * inoltre è stato anche aggiunto un timer che grazie all'utilizzo dell'interfaccia funzionale onsumer passerà
 * i secondi come se fossero un punteggio a "PanelConsole"
 * 
 * @author Giuseppe
 */
public class GiocoSchivaBlocchi extends javax.swing.JPanel {
    
    private Thread spawn;
    private boolean inFunzione;
    private Cronometro timer;
    Consumer<Integer> tempoFinale;

    
    public GiocoSchivaBlocchi(Consumer<Integer> tempoFinale) {
        initComponents();
        this.tempoFinale = tempoFinale;
        inFunzione = false;
        timer = new Cronometro();
        posizioneTempo.add(timer);
        timer.setVisible(true);
        timer.setLocation(posizioneTempo.getLocation());
        
        quadrato.setLocation(quadrato.getX(), getHeight()/2);
        revalidate();
        repaint();
    }

    private class SpawnBlocchi implements Runnable, UpdateDalThread{
        final int FREQUENZA_DISCESA = 5;
        final int FREQUENZA_SPAWN = 200;
        final int VELOCITA_DISCESA = 3;
        final int TOLLERANZA_COLLISIONE = 10;
        boolean vitaThread;
        Random numeroCasuale = new Random();
        
        
        public SpawnBlocchi(){
            vitaThread = true;
        }
    
        
        @Override
        public void run() {
            try {
                int numero;
                while(vitaThread){
                    //fai spawnare la barriera
                    JPanel barriera = new Barriera(quadrato.getWidth(), quadrato.getHeight(),
                                (getWidth()/3) * 2, -quadrato.getHeight(),
                                quadrato.getX() + quadrato.getWidth(),
                                quadrato.getX(), this );
                    
                    add(barriera); 
                    numero = numeroCasuale.nextInt(100);
                    //decide da che lato piazzare la barriera
                    if(numero > 50){
                        //fa scendere il blocco nella corsia di sotto
                        while(barriera.getY() < getHeight()/2 - quadrato.getHeight()){
                            barriera.setLocation(barriera.getX(), barriera.getY() + VELOCITA_DISCESA);
                            sleep(FREQUENZA_DISCESA);
                        }
                    } else {
                        //fa scendere la barriera nella corsia di sotto
                        while(barriera.getY() < getHeight()/2 ){
                            barriera.setLocation(barriera.getX(), barriera.getY() + VELOCITA_DISCESA);
                            sleep(FREQUENZA_DISCESA);
                        }
                    }
                    
                    Thread barrieraThread = new Thread((Runnable) barriera);
                    
                    barrieraThread.start();
                    //blocchi.add(barriera);
                    sleep(FREQUENZA_SPAWN);
                }
            
            } catch (InterruptedException ex) {
                Logger.getLogger(GiocoSchivaBlocchi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
        
        @Override
        public boolean controllaCollisione(int y) {
            boolean eliminaThread = false;
            if(y < quadrato.getY() + TOLLERANZA_COLLISIONE && quadrato.getY() - TOLLERANZA_COLLISIONE < y){
                
                //r barriera.interrupt();
                eliminaThread = true;
                timer.ferma();

                vitaThread = false;
                inFunzione = false;
                
                tempoFinale.accept(timer.getSecondi());
                //removeAll();

            }
            
            return eliminaThread;
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
        @Override
        public void distruggiBarriera(JPanel barriera){
            remove(barriera);
            //repaint();
            
            
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        quadrato = new javax.swing.JPanel();
        posizioneTempo = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(590, 232));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        quadrato.setBackground(new java.awt.Color(100, 63, 65));
        quadrato.setMinimumSize(new java.awt.Dimension(0, 0));
        quadrato.setPreferredSize(new java.awt.Dimension(42, 85));

        javax.swing.GroupLayout quadratoLayout = new javax.swing.GroupLayout(quadrato);
        quadrato.setLayout(quadratoLayout);
        quadratoLayout.setHorizontalGroup(
            quadratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );
        quadratoLayout.setVerticalGroup(
            quadratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
        );

        posizioneTempo.setLayout(new javax.swing.OverlayLayout(posizioneTempo));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(quadrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(posizioneTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(493, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(posizioneTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(quadrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    //utilizzo key pressed solo per i comandi che ho bisogno siano i più responsivi possibili
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        
        if (evt.getKeyCode() == KeyEvent.VK_W || evt.getKeyCode() == KeyEvent.VK_UP) {
            if(controlloSopra(quadrato.getY())){
                quadrato.setLocation(quadrato.getX() , quadrato.getY() - quadrato.getHeight());
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_S || evt.getKeyCode() == KeyEvent.VK_DOWN){
            if(controlloBase(quadrato.getY())){
                quadrato.setLocation(quadrato.getX() , quadrato.getY() + quadrato.getHeight());
            }
            
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER && !inFunzione){
            inFunzione = true;
            timer.reset();
            repaint();
            
            
            spawn = new Thread(new SpawnBlocchi());
            
            add(quadrato);
            add(posizioneTempo);
            //posizioneTempo.add(timer);
            spawn.start();
            timer.parti();
            
        }
    }//GEN-LAST:event_formKeyPressed

    
    private boolean controlloBase(int y){
        boolean rispettaBordiJframe = true;
        if(getHeight() < (quadrato.getHeight()*2) + y) {
            rispettaBordiJframe = false;
        }
        return rispettaBordiJframe;
    }
    
    private boolean controlloSopra(int y){
        boolean rispettaBordiJframe = true;
        if((y - quadrato.getHeight()) < 0){
            rispettaBordiJframe = false;
        }
        return rispettaBordiJframe;
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel posizioneTempo;
    private javax.swing.JPanel quadrato;
    // End of variables declaration//GEN-END:variables
}
