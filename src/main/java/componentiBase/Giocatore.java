/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentiBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Classe adibita alla definizione del tipo Giocatore
 * contiene l'ambiente attuale e l'inventario di Oggetti(spostabili)
 * @author Giuseppe
 */
public class Giocatore implements Serializable{
    private Ambiente ambienteCorrente;
    private ArrayList<Oggetto> inventario;
    
    public Giocatore(Ambiente ambienteCorrente){
        this.ambienteCorrente = ambienteCorrente;
        inventario = new ArrayList<>();
    }
    
    public Giocatore(Ambiente ambienteCorrente, ArrayList<Oggetto> inventario){
        this.ambienteCorrente = ambienteCorrente;
        this.inventario = inventario;
    }
    
    public ArrayList<Oggetto> getInventario(){return inventario;}
    
    public void spostaGiocatore(Ambiente ambiente){
        ambienteCorrente = ambiente;
    }
    
    public Ambiente getAmbienteCorrente(){return ambienteCorrente;}
    
    public void prendiOggetto(Oggetto oggetto){
        inventario.add(oggetto);
    }
    
    public void lasciaOggetto(Oggetto oggetto){
        inventario.remove(oggetto);
    }
    
    public boolean cercaOggettoInventario(String nomeOggetto){
        Boolean flagTrovato = false;
        ListIterator<Oggetto> iteratoreInventario = inventario.listIterator();
        while(iteratoreInventario.hasNext() && flagTrovato ==false){
            if(iteratoreInventario.next().getNome().equals(nomeOggetto)){
                flagTrovato = true;
            }
        }
        
        return flagTrovato;
    }
    
}
