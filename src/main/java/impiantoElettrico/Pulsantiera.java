/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package impiantoElettrico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.function.Consumer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * Pannello che simula un semplice circuito elettronico,
 * le porte logiche hanno all'interno degli JToggleButton nascosti (graficamente)
 * che servono come input per le altre porte logiche
 * 
 * @author Giuseppe
 */
public class Pulsantiera extends javax.swing.JPanel {

    And and1;
    And and2;
    
    Or or1;
    Or or2;
    Or or3;
    
    Xor xor1;
    
    Not not1;
    Not not2;
    Not not3;
    Consumer pulsantiera;
    
    
    public Pulsantiera(Consumer pulsantiera) {
        initComponents();
        this.pulsantiera = pulsantiera;
        segnaleOpen.setBackground(Color.red);
        initPorteLogiche();
        
        contenitore.revalidate();
        contenitore.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenitore = new javax.swing.JPanel();
        inputA = new javax.swing.JToggleButton();
        inputB = new javax.swing.JToggleButton();
        inputC = new javax.swing.JToggleButton();
        inputD = new javax.swing.JToggleButton();
        inputE = new javax.swing.JToggleButton();
        inputF = new javax.swing.JToggleButton();
        contenitoreOr1 = new javax.swing.JPanel();
        contenitoreNot1 = new javax.swing.JPanel();
        contenitoreNot2 = new javax.swing.JPanel();
        contenitoreAnd1 = new javax.swing.JPanel();
        contenitoreAnd2 = new javax.swing.JPanel();
        contenitoreXor1 = new javax.swing.JPanel();
        contenitoreOr2 = new javax.swing.JPanel();
        contenitoreOr3 = new javax.swing.JPanel();
        contenitoreNot3 = new javax.swing.JPanel();
        segnaleOpen = new javax.swing.JTextField();
        sfondoPulsantiera = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(500, 315));
        setLayout(new javax.swing.OverlayLayout(this));

        contenitore.setMaximumSize(new java.awt.Dimension(500, 315));
        contenitore.setOpaque(false);

        inputA.setText("InA");
        inputA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAActionPerformed(evt);
            }
        });

        inputB.setText("InB");
        inputB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputBActionPerformed(evt);
            }
        });

        inputC.setText("InC");
        inputC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCActionPerformed(evt);
            }
        });

        inputD.setText("InD");
        inputD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDActionPerformed(evt);
            }
        });

        inputE.setText("InE");
        inputE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEActionPerformed(evt);
            }
        });

        inputF.setText("InF");
        inputF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFActionPerformed(evt);
            }
        });

        contenitoreOr1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenitoreOr1.setOpaque(false);
        contenitoreOr1.setLayout(new javax.swing.OverlayLayout(contenitoreOr1));

        contenitoreNot1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenitoreNot1.setOpaque(false);
        contenitoreNot1.setLayout(new javax.swing.OverlayLayout(contenitoreNot1));

        contenitoreNot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenitoreNot2.setOpaque(false);
        contenitoreNot2.setLayout(new javax.swing.OverlayLayout(contenitoreNot2));

        contenitoreAnd1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenitoreAnd1.setOpaque(false);
        contenitoreAnd1.setLayout(new javax.swing.OverlayLayout(contenitoreAnd1));

        contenitoreAnd2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenitoreAnd2.setOpaque(false);
        contenitoreAnd2.setLayout(new javax.swing.OverlayLayout(contenitoreAnd2));

        contenitoreXor1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenitoreXor1.setOpaque(false);
        contenitoreXor1.setLayout(new javax.swing.OverlayLayout(contenitoreXor1));

        contenitoreOr2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenitoreOr2.setOpaque(false);
        contenitoreOr2.setLayout(new javax.swing.OverlayLayout(contenitoreOr2));

        contenitoreOr3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenitoreOr3.setOpaque(false);
        contenitoreOr3.setLayout(new javax.swing.OverlayLayout(contenitoreOr3));

        contenitoreNot3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contenitoreNot3.setOpaque(false);
        contenitoreNot3.setLayout(new javax.swing.OverlayLayout(contenitoreNot3));

        segnaleOpen.setText("     OPEN");

        javax.swing.GroupLayout contenitoreLayout = new javax.swing.GroupLayout(contenitore);
        contenitore.setLayout(contenitoreLayout);
        contenitoreLayout.setHorizontalGroup(
            contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenitoreLayout.createSequentialGroup()
                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenitoreLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputA)
                            .addGroup(contenitoreLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(inputB))
                            .addComponent(inputC)
                            .addComponent(inputE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenitoreLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputF)
                            .addComponent(inputD))
                        .addGap(18, 18, 18)))
                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(contenitoreOr1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(contenitoreNot2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contenitoreAnd1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenitoreLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(contenitoreAnd2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contenitoreLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(contenitoreNot1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(contenitoreXor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(contenitoreOr3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contenitoreOr2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenitoreLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(contenitoreNot3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenitoreLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(segnaleOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        contenitoreLayout.setVerticalGroup(
            contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenitoreLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenitoreLayout.createSequentialGroup()
                        .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenitoreLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(contenitoreAnd2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                    .addComponent(contenitoreAnd1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(contenitoreLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(segnaleOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contenitoreNot3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contenitoreOr3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(contenitoreLayout.createSequentialGroup()
                        .addComponent(inputA)
                        .addGap(18, 18, 18)
                        .addComponent(inputB)
                        .addGap(18, 18, 18)
                        .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenitoreLayout.createSequentialGroup()
                                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(contenitoreOr1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                    .addComponent(contenitoreNot1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenitoreLayout.createSequentialGroup()
                                        .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(contenitoreOr2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                            .addComponent(contenitoreXor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(11, 11, 11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenitoreLayout.createSequentialGroup()
                                        .addComponent(contenitoreNot2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32))))
                            .addGroup(contenitoreLayout.createSequentialGroup()
                                .addComponent(inputC)
                                .addGap(18, 18, 18)
                                .addComponent(inputD)
                                .addGap(18, 18, 18)
                                .addComponent(inputE)
                                .addGap(18, 18, 18)
                                .addComponent(inputF)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        add(contenitore);

        javax.swing.GroupLayout sfondoPulsantieraLayout = new javax.swing.GroupLayout(sfondoPulsantiera);
        sfondoPulsantiera.setLayout(sfondoPulsantieraLayout);
        sfondoPulsantieraLayout.setHorizontalGroup(
            sfondoPulsantieraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        sfondoPulsantieraLayout.setVerticalGroup(
            sfondoPulsantieraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        add(sfondoPulsantiera);
    }// </editor-fold>//GEN-END:initComponents

    private void inputAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAActionPerformed
        valutaPorteLogiche();        // TODO add your handling code here:
    }//GEN-LAST:event_inputAActionPerformed

    private void inputBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBActionPerformed
        valutaPorteLogiche();        // TODO add your handling code here:
    }//GEN-LAST:event_inputBActionPerformed

    private void inputCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCActionPerformed
        valutaPorteLogiche();        // TODO add your handling code here:
    }//GEN-LAST:event_inputCActionPerformed

    private void inputDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDActionPerformed
        valutaPorteLogiche();        // TODO add your handling code here:
    }//GEN-LAST:event_inputDActionPerformed

    private void inputEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEActionPerformed
        valutaPorteLogiche();        // TODO add your handling code here:
    }//GEN-LAST:event_inputEActionPerformed

    private void inputFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFActionPerformed
        valutaPorteLogiche();        // TODO add your handling code here:
    }//GEN-LAST:event_inputFActionPerformed

    private void initPorteLogiche(){
        and1 = new And();
        contenitoreAnd1.add(and1);
        and1.setLocation(contenitoreAnd1.getLocation());
        and1.aggiungiPrimoInput(inputA);
        and1.aggiungiSecondoInput(inputB);
        
        or1 = new Or();
        contenitoreOr1.add(or1);
        or1.setLocation(contenitoreOr1.getLocation());
        or1.aggiungiPrimoInput(inputC);
        or1.aggiungiSecondoInput(inputD);
        
        not1 = new Not();
        contenitoreNot1.add(not1);
        not1.setLocation(contenitoreNot1.getLocation());
        not1.aggiungiInput(or1.restituisciOutput());
        
        not2 = new Not();
        contenitoreNot2.add(not2);
        not2.setLocation(contenitoreNot2.getLocation());
        not2.aggiungiInput(inputE);
        
        xor1 = new Xor();
        contenitoreXor1.add(xor1);
        xor1.setLocation(contenitoreXor1.getLocation());
        xor1.aggiungiPrimoInput(inputF);
        xor1.aggiungiSecondoInput(not2.restituisciOutput());
        
        or2 = new Or();
        contenitoreOr2.add(or2);
        or2.setLocation(contenitoreOr2.getLocation());
        or2.aggiungiPrimoInput(or1.restituisciOutput());
        or2.aggiungiSecondoInput(xor1.restituisciOutput());
        
        and2 = new And();
        contenitoreAnd2.add(and2);
        and2.setLocation(contenitoreAnd2.getLocation());
        and2.aggiungiPrimoInput(and1.restituisciOutput());
        and2.aggiungiSecondoInput(not1.restituisciOutput());
        
        or3 = new Or();
        contenitoreOr3.add(or3);
        or3.setLocation(contenitoreOr3.getLocation());
        or3.aggiungiPrimoInput(or2.restituisciOutput());
        or3.aggiungiSecondoInput(and2.restituisciOutput());
        
        not3 = new Not();
        contenitoreNot3.add(not3);
        not3.setLocation(contenitoreNot3.getLocation());
        not3.aggiungiInput(or3.restituisciOutput());
        not3.restituisciOutput();
        
        caricaImmagini();

        and1.setVisible(true);
        and2.setVisible(true);
    
        or1.setVisible(true);
        or2.setVisible(true);
    
        xor1.setVisible(true);
        or3.setVisible(true);
    
        not1.setVisible(true);
        not2.setVisible(true);
        not3.setVisible(true);
        
        repaint();
    }
     
    
    
    private void valutaPorteLogiche(){
        and1.restituisciOutput();
        or1.restituisciOutput();
        not1.restituisciOutput();
        not2.restituisciOutput();
        xor1.restituisciOutput();
        or2.restituisciOutput();
        and2.restituisciOutput();
        or3.restituisciOutput();
        not3.restituisciOutput();
        
        
        if(not3.restituisciOutput().isSelected()){
            segnaleOpen.setBackground(Color.green);
            pulsantiera.accept(true);
            
        } else{
            segnaleOpen.setBackground(Color.red);
        }
        
        contenitore.revalidate();
        contenitore.repaint();
        
    }

    
    private void caricaImmagini(){

            //immagineInPannello("./img/mensola.png", sfondo );
            immagineInPannello("./img/circuito/portaAnd.png", and1 );
            immagineInPannello("./img/circuito/portaAnd.png", and2 );
            immagineInPannello("./img/circuito/portaOr.png", or1 );
            immagineInPannello("./img/circuito/portaOr.png", or2);
            immagineInPannello("./img/circuito/portaOr.png", or3);
            immagineInPannello("./img/circuito/portaNot.png", not1 );
            immagineInPannello("./img/circuito/portaNot.png", not2 );
            immagineInPannello("./img/circuito/portaNot.png", not3 );
            immagineInPannello("./img/circuito/portaXor.png", xor1 );
            immagineInPannello("./img/circuito/sfondoPulsantiera.png",sfondoPulsantiera);




    }   
    
    private void immagineInPannello(String percorsoImmagine, JPanel pannello){
        ImageIcon icona = new ImageIcon(percorsoImmagine);
        JLabel label = new JLabel( icona);
        pannello.setLayout(new BorderLayout());
        pannello.add(label);
        label.setOpaque(false);
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenitore;
    private javax.swing.JPanel contenitoreAnd1;
    private javax.swing.JPanel contenitoreAnd2;
    private javax.swing.JPanel contenitoreNot1;
    private javax.swing.JPanel contenitoreNot2;
    private javax.swing.JPanel contenitoreNot3;
    private javax.swing.JPanel contenitoreOr1;
    private javax.swing.JPanel contenitoreOr2;
    private javax.swing.JPanel contenitoreOr3;
    private javax.swing.JPanel contenitoreXor1;
    private javax.swing.JToggleButton inputA;
    private javax.swing.JToggleButton inputB;
    private javax.swing.JToggleButton inputC;
    private javax.swing.JToggleButton inputD;
    private javax.swing.JToggleButton inputE;
    private javax.swing.JToggleButton inputF;
    private javax.swing.JTextField segnaleOpen;
    private javax.swing.JPanel sfondoPulsantiera;
    // End of variables declaration//GEN-END:variables
}
