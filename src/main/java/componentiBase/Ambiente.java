/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentiBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Classe adibita alla definizione del tipo Ambiente
 * @author Giuseppe
 */
public class Ambiente implements Serializable{
    private final String descrizioneBreve;
    private final String descrizioneApprofondita;
    private final String nome;
    //indica se una stanza è chiusa o no
    private boolean chiuso;
    private final ArrayList<Oggetto> inventario;
    
    
    public Ambiente( String nome, String descrizioneBreve,
            String descrizioneApprofondita, boolean chiuso) {
        
        this.nome = nome;
        this.descrizioneBreve = descrizioneBreve;
        this.descrizioneApprofondita = descrizioneApprofondita;
        this.inventario  = new ArrayList<>();
        this.chiuso = chiuso;
    }
    
    
    public Ambiente( String nome, String descrizioneBreve,
            String descrizioneApprofondita, ArrayList inventario, boolean chiuso) {
        this.nome = nome;
        this.descrizioneBreve = descrizioneBreve;
        this.descrizioneApprofondita = descrizioneApprofondita;
        this.inventario  = inventario;
        this.chiuso = chiuso;
    }
    
    
    
    public String getDescrizioneBreve() {return descrizioneBreve;}
    public String getDescrizioneApprofondita() {return descrizioneApprofondita;}
    
    public String getNome(){return nome;}
    public Boolean getChiuso(){return chiuso;}
    
    public void apriAmbiente(){chiuso = false;}
    public void chiudiAmbiente(){chiuso = true;}
    
    public void mettiOggettoAmbiente(Oggetto oggetto){
        inventario.add(oggetto);
    }
    
    public void togliOggettoAmbiente(Oggetto oggetto){
        inventario.remove(oggetto);
    }
    
    public String getListaInventario(){
        String lista = "";
        
        if(!inventario.isEmpty()){
            lista = "\nOggetti stanza: " + "\n";
            ListIterator<Oggetto> iteratoreInventario = inventario.listIterator();
            
            while(iteratoreInventario.hasNext()){
                lista = lista.concat("\t"+iteratoreInventario.next().getNome() + "\n");
            }
        }
        return lista;
    }
    
    public boolean controllaOggettoInStanza(Oggetto oggetto){
        return inventario.contains(oggetto);
    }
    
}


