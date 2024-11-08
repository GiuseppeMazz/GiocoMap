/*, 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentiBase;

import java.io.Serializable;

/**
 * Classe adibita alla definizione del tipo Oggetto
 * spostabile indica se l'oggetto è prendibile dall'utente o no
 * @author Giuseppe
 */
public class Oggetto implements Serializable{
    private final String nome;
    private final String descrizione;
    private final boolean spostabile;
    
    
    public Oggetto(String nome, boolean spostabile, String descrizione){
        this.nome = nome;
        this.spostabile = spostabile;
        this.descrizione = descrizione;
    }
    
    public boolean controllaOggetto(String nomeOggetto){
        return nome.equals(nomeOggetto);
    }
    
    public String getNome(){return nome;}
    public boolean getSpostabile(){return spostabile;}
    public String getDescrizione(){return descrizione;}
    
    
}
