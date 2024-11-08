/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentiBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Classe adibita alla definizione del tipo OggettoContenitore
 * è una sottoclasse di Oggetto fatta per gli oggetti con un loro vero  proprio inventario
 * o che comunque possono conservare degli oggetti
 * @author Giuseppe
 */
public class OggettoContenitore extends Oggetto implements Serializable{
    private ArrayList<Oggetto> inventario;
    
    public OggettoContenitore(String nome, boolean spostabile, String descrizione) {
        super(nome, spostabile, descrizione);
        inventario = new ArrayList<>();
    }
    
    public void inserisciContenitore(Oggetto oggetto){
        inventario.add(oggetto);
    }
    
    public void rimouviContenitore(Oggetto oggetto){
        inventario.remove(oggetto);
    }
    
    public boolean controllaOggettoInContenitore(Oggetto oggetto){
        return inventario.contains(oggetto);  
    }
    
    public boolean controllaOggettoInContenitore(String nome){
        boolean flagOggettoTrovato = false;
        ListIterator<Oggetto> iteratoreInventario = inventario.listIterator();
        
        while (iteratoreInventario.hasNext() && flagOggettoTrovato == false){
            
            if(iteratoreInventario.next().getNome().equals(nome)){
                flagOggettoTrovato = true;
            }
        }
        return flagOggettoTrovato;
    }
    
}
