/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package console.schermo;

import console.giocoSchivaBlocchi.GiocoSchivaBlocchi;
import console.giocoPassword.GiocoPassword;
import javax.swing.JPanel;

/**
 *
 * Rappresenta all'interno del gioco una console che fa da tramite per giocare giocoPAssword e GiocoSchivaBlocchi
 * Inoltre per il Gioco Schiva Blocchi ad ogni partita persa mostra i secondi di vita e da la possibilità di riprovare
 * 
 * @author Giuseppe
 */


public class PanelConsole extends javax.swing.JPanel {

    
    //pannello che sarà inserito e rimosso per i minigiochi
    JPanel pannelloEsterno;
    public PanelConsole() {
        initComponents();
        setComponentZOrder(menuGiochi,0);
        setComponentZOrder(risultatiGiocoSchivaBlocchi,1);
        riprovaSchivaBlocchi.setEnabled(false);
        risultato.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuGiochi = new javax.swing.JPanel();
        bottoneSchivaBlocchi = new javax.swing.JButton();
        bottonePassword = new javax.swing.JButton();
        jTextArea1 = new javax.swing.JTextArea();
        risultatiGiocoSchivaBlocchi = new javax.swing.JPanel();
        riprovaSchivaBlocchi = new javax.swing.JButton();
        risultato = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(655, 300));
        setMinimumSize(new java.awt.Dimension(655, 300));
        setLayout(new javax.swing.OverlayLayout(this));

        menuGiochi.setMaximumSize(new java.awt.Dimension(655, 300));
        menuGiochi.setMinimumSize(new java.awt.Dimension(655, 300));

        bottoneSchivaBlocchi.setText("gioco schiva blocchi");
        bottoneSchivaBlocchi.setToolTipText("");
        bottoneSchivaBlocchi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                premutoBottoneGiocoSchivaBlocchi(evt);
            }
        });

        bottonePassword.setText("gioco password");
        bottonePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                premutoBottoneGiocoPassword(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("ISTRUZIONI gioco schiva bloccchi:\n-usa le frecce su, giu per spostrsi\n    o \"w\" e \"d\"\n-premere invio per partire dopo\n\t ");

        javax.swing.GroupLayout menuGiochiLayout = new javax.swing.GroupLayout(menuGiochi);
        menuGiochi.setLayout(menuGiochiLayout);
        menuGiochiLayout.setHorizontalGroup(
            menuGiochiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuGiochiLayout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addGroup(menuGiochiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottonePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneSchivaBlocchi, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(236, 236, 236))
        );
        menuGiochiLayout.setVerticalGroup(
            menuGiochiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuGiochiLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(bottonePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bottoneSchivaBlocchi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        add(menuGiochi);

        riprovaSchivaBlocchi.setText("riprova");
        riprovaSchivaBlocchi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                riprovaSchivaBlocchiActionPerformed(evt);
            }
        });

        risultato.setEditable(false);

        javax.swing.GroupLayout risultatiGiocoSchivaBlocchiLayout = new javax.swing.GroupLayout(risultatiGiocoSchivaBlocchi);
        risultatiGiocoSchivaBlocchi.setLayout(risultatiGiocoSchivaBlocchiLayout);
        risultatiGiocoSchivaBlocchiLayout.setHorizontalGroup(
            risultatiGiocoSchivaBlocchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(risultatiGiocoSchivaBlocchiLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(riprovaSchivaBlocchi)
                .addContainerGap(303, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, risultatiGiocoSchivaBlocchiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(risultato, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        risultatiGiocoSchivaBlocchiLayout.setVerticalGroup(
            risultatiGiocoSchivaBlocchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(risultatiGiocoSchivaBlocchiLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(riprovaSchivaBlocchi)
                .addGap(44, 44, 44)
                .addComponent(risultato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        add(risultatiGiocoSchivaBlocchi);
    }// </editor-fold>//GEN-END:initComponents

    private void premutoBottoneGiocoPassword(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_premutoBottoneGiocoPassword
        // TODO add your handling code here:
        setOpaque(false);
        menuGiochi.setOpaque(false);
        gestionePannello(new GiocoPassword());
    }//GEN-LAST:event_premutoBottoneGiocoPassword

    private void premutoBottoneGiocoSchivaBlocchi(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_premutoBottoneGiocoSchivaBlocchi
        // TODO add your handling code here:
        gestionePannello(new GiocoSchivaBlocchi(
                (Integer tempoFinale) -> {
                    riprovaSchivaBlocchi.setEnabled(true);
                    risultato.setEnabled(true);
                    risultato.setText("Punteggio: " + tempoFinale);
                    setComponentZOrder(risultatiGiocoSchivaBlocchi,0);
                    remove(pannelloEsterno);
        }));
    }//GEN-LAST:event_premutoBottoneGiocoSchivaBlocchi

    private void riprovaSchivaBlocchiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_riprovaSchivaBlocchiActionPerformed
        // TODO add your handling code here:
        
        bottoneSchivaBlocchi.doClick();
        riprovaSchivaBlocchi.setEnabled(false);
    }//GEN-LAST:event_riprovaSchivaBlocchiActionPerformed

    private void gestionePannello(JPanel pannello){
        pannelloEsterno = pannello;
        add(pannelloEsterno,1);
        pannelloEsterno.requestFocus();
        setComponentZOrder(pannelloEsterno, 0);
        setComponentZOrder(menuGiochi,1);
        revalidate();
        repaint();
        menuGiochi.setVisible(false);
        revalidate();
        repaint();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottonePassword;
    private javax.swing.JButton bottoneSchivaBlocchi;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel menuGiochi;
    private javax.swing.JButton riprovaSchivaBlocchi;
    private javax.swing.JPanel risultatiGiocoSchivaBlocchi;
    private javax.swing.JTextField risultato;
    // End of variables declaration//GEN-END:variables
}
