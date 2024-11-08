/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package rompicapo;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe che permette di visualizzare i fogli trovati dall'utente
 * 
 * (nello schema iniziale del gioco erano molteplici, si sono ridotti a uno)
 * @author Giuseppe
 */
public class FoglioSoluzioni extends javax.swing.JPanel {

    /**
     * Creates new form FoglioCombinazioni
     * @param nome si intende che venfa passato "foglioCassaforte" per il foglio della cassaforte o
     *  di un altro foglio da mostrare
     */
    public FoglioSoluzioni(String nome) {
        initComponents();
        caricaImmagini(nome);
    }
    
    
    private void caricaImmagini(String nome){
        if("foglioCassaforte".equals(nome)){
            immagineInPannello("./img/fogli/foglioCassaforte.png", visualizzaFogli);
        }
    }

    private void immagineInPannello(String percorsoImmagine, JPanel pannello){
        ImageIcon icona = new ImageIcon(percorsoImmagine);
        JLabel label = new JLabel( icona);
        pannello.setLayout(new BorderLayout());
        pannello.add(label);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        visualizzaFogli = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(400, 300));
        setOpaque(false);
        setLayout(new javax.swing.OverlayLayout(this));

        visualizzaFogli.setOpaque(false);

        javax.swing.GroupLayout visualizzaFogliLayout = new javax.swing.GroupLayout(visualizzaFogli);
        visualizzaFogli.setLayout(visualizzaFogliLayout);
        visualizzaFogliLayout.setHorizontalGroup(
            visualizzaFogliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        visualizzaFogliLayout.setVerticalGroup(
            visualizzaFogliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(visualizzaFogli);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel visualizzaFogli;
    // End of variables declaration//GEN-END:variables
}
