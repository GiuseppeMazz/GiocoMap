/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impiantoElettrico;

import javax.swing.JToggleButton;

/**
 * Figlia di PortaLogica Nand fa l'Override del metodo senza implementazione fornendo la logica Nand
 * @author Giuseppe
 */
public class Nand extends PortaLogica{

    @Override
    public JToggleButton restituisciOutput() {
        
        boolean output = false;
        if (input1.isSelected() && input2.isSelected()){
            output = true;
        }
        
        output = !output;
        cambiaStato(output);
        return stato;    
    }
}
