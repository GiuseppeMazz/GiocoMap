/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package rompicapo;

import java.util.function.Consumer;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 * Rappresenta una cassaforte con 3 valori da 1 a 10 da scegliere tramite JSlider
 * 
 * @author Giuseppe
 */
public class CassaforteRompicapo extends javax.swing.JPanel {

    Consumer cassaforte;
    static boolean pannelloRisolto = false;

    /**
     * Creates new form Cassaforte
     * @param cassaforte viene passata un implementazione dell'inferfaccia Consumer in modo da 
     */
    public CassaforteRompicapo(Consumer cassaforte) {
        initComponents();
        this.cassaforte = cassaforte;
        inizializzaSlider(sliderNum1);
        inizializzaSlider(sliderNum2);
        inizializzaSlider(sliderNum3);
        numero1.setText("0");
        numero2.setText("0");
        numero3.setText("0");
        collegamentoSliderLabel(sliderNum1, numero1);
        collegamentoSliderLabel(sliderNum2, numero2);
        collegamentoSliderLabel(sliderNum3, numero3);
    }
    
    private void inizializzaSlider(JSlider slider){
        slider.setMaximum(10);
        slider.setValue(0);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        //il tool tip è un messaggio mostrato sotto il puntatore
        //usato solitamente per dare un consiglio sulla funzione dell'elemento
        slider.setToolTipText("Usare le freccette per una maggior precisione");
    }
            
    
    
    

    private void collegamentoSliderLabel(JSlider slider, JLabel label){
        //si da un implementazione al metodo mancante di Change Listener tramite una lambda Expression in modo
        //da aggiornare la label ogni volta che cambia lo stato dello slider
        slider.addChangeListener((ChangeEvent e) -> {
            label.setText(Integer.toString(slider.getValue()));
        });
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
        sliderNum2 = new javax.swing.JSlider();
        sliderNum1 = new javax.swing.JSlider();
        sliderNum3 = new javax.swing.JSlider();
        numero1 = new javax.swing.JLabel();
        numero2 = new javax.swing.JLabel();
        numero3 = new javax.swing.JLabel();
        conferma = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(483, 257));
        setLayout(new javax.swing.OverlayLayout(this));

        contenitore.setMaximumSize(new java.awt.Dimension(483, 257));

        numero1.setBackground(new java.awt.Color(153, 153, 153));

        numero2.setBackground(new java.awt.Color(153, 153, 153));

        numero3.setBackground(new java.awt.Color(153, 153, 153));

        conferma.setText("conferma");
        conferma.setToolTipText("");
        conferma.setOpaque(true);
        conferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenitoreLayout = new javax.swing.GroupLayout(contenitore);
        contenitore.setLayout(contenitoreLayout);
        contenitoreLayout.setHorizontalGroup(
            contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenitoreLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sliderNum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sliderNum3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sliderNum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numero2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numero3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numero1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenitoreLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(conferma)
                .addGap(194, 194, 194))
        );
        contenitoreLayout.setVerticalGroup(
            contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenitoreLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderNum1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenitoreLayout.createSequentialGroup()
                        .addComponent(numero1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderNum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numero2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contenitoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderNum3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numero3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(conferma)
                .addGap(23, 23, 23))
        );

        add(contenitore);
    }// </editor-fold>//GEN-END:initComponents
    //comandi da eseguire dopo aer premuto il bottone conferma
    private void confermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaActionPerformed
        if("2".equals(numero1.getText()) && "4".equals(numero2.getText()) && "8".equals(numero3.getText())){
            if(!pannelloRisolto){
                pannelloRisolto = true;
                cassaforte.accept(true);
            }
        }
    }//GEN-LAST:event_confermaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton conferma;
    private javax.swing.JPanel contenitore;
    private javax.swing.JLabel numero1;
    private javax.swing.JLabel numero2;
    private javax.swing.JLabel numero3;
    private javax.swing.JSlider sliderNum1;
    private javax.swing.JSlider sliderNum2;
    private javax.swing.JSlider sliderNum3;
    // End of variables declaration//GEN-END:variables
}
