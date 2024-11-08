/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tempo;

/**
 *Cronometro usato nelGiocoSchivaBlocchi, usa un Thread che incrementa nel tempo
 * @author Giuseppe
 */
public class Cronometro extends javax.swing.JPanel {

    private int secondi;
    private final int limite;
    private boolean counterAttivo;
    private Thread counter;
    
    public Cronometro() {
        initComponents();
        counter = new Thread(new Counter());
        secondi = 0;
        limite = 600;
        counterAttivo = false;
        cifre.setText("00:00");
        
        revalidate();
        repaint();
    }
    
    public Cronometro(int limite) {
        initComponents();
        secondi = 0;
        this.limite = limite;
        counterAttivo = false;
        cifre.setText("00:00");
        revalidate();
        repaint();
    }
    
    
    private class Counter implements Runnable {
        
        @Override
        public void run() {
            while(secondi < limite && counterAttivo){
                secondi++;
                cifre.setText(restituisciOrario());
                aggiornaSchermo();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("Thread counter gioco blocchi interrotto durante lo sleep");
                    //Logger.getLogger(TimerVecchio.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        
    }
    
    
    
    public void parti(){
        counter = new Thread(new Counter());
        counterAttivo = true;
        counter.start();
        
        
    }
    
    private void aggiornaSchermo(){
        repaint();
    }
    
    private String restituisciOrario(){
        int minuti;
        int secondiLocale;
        
        secondiLocale = this.secondi % 60;
        minuti = this.secondi / 60;
        
        return String.format("%02d : %02d",minuti,secondiLocale);
    }
    
    public void ferma(){
        counter.interrupt();
        counterAttivo = false;
    }
    
    public int getSecondi(){return secondi;}
    
    public void reset(){
        ferma();
        secondi = 0;
    }
    
    public void riprendi(){counterAttivo = true;}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cifre = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cifre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cifre.setForeground(new java.awt.Color(255, 36, 0));
        cifre.setDisabledTextColor(new java.awt.Color(187, 187, 187));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cifre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cifre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cifre;
    // End of variables declaration//GEN-END:variables
}
