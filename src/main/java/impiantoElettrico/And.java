/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impiantoElettrico;

import javax.swing.JToggleButton;

/**
 * Figlia di PortaLogica And fa l'Override del metodo senza implementazione fornendo la logica And
 * @author Giuseppe
 */
public class And extends PortaLogica{
    @Override
    public JToggleButton restituisciOutput() {
        boolean output = false;
        if(input1.isSelected() && input2.isSelected()){
            output = true;
        }
        cambiaStato(output);
        return stato;
    }
}
