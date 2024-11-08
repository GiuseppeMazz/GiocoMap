/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stato;

import componentiBase.Giocatore;
import componentiBase.Oggetto;
import componentiBase.Comando;
import java.io.Serializable;
import java.util.List;
import mappa.Mappa;

/**
 * Classe che tiene conto dello stato del gioco, serve sia per avere un punto di riferimento con
 * le informazioni del mondo di gioco ma anche per permettere di fare IO sui file
 *
 * @author Giuseppe
 */
public class StatoGioco implements Serializable, Cloneable{
    private  Giocatore giocatore; 
    private Mappa mappa;
    private final List<Comando> comandi;
    private List<Oggetto> oggetti;
    private final List<String> stopWords;
    
    /**
     *
     * @param mappa del gioco, contiene tutti gli ambienti e i rispettivi inventari
     * @param giocatore contiene tutte le informazioni quali ambiente attuale e inventario
     * @param comandi lista dei comandi
     * @param oggetti lista degli oggetti
     * @param stopWords lista di stringhe da rimuovere durante il parsing della stringa
     */
    
    public StatoGioco (Mappa mappa, Giocatore giocatore, List<Comando> comandi, List<Oggetto> oggetti, List<String> stopWords){
        this.mappa = mappa;
        this.giocatore = giocatore;
        this.comandi = comandi;
        this.oggetti = oggetti;
        this.stopWords = stopWords;
    }
    
    public Giocatore getGiocatore (){return giocatore;}
    public Mappa getMappa(){return mappa;}
    public List<Comando> getComandi(){return comandi;}
    public List<Oggetto> getOggetti(){return oggetti;}
    public List<String> getStopWords(){return stopWords;}
    
    protected void cambiaStato(StatoGioco nuovoStato){
        giocatore = nuovoStato.getGiocatore();
        mappa = nuovoStato.getMappa();
        oggetti = nuovoStato.getOggetti();
    }
    
    protected StatoGioco copia(){
        return this;
    }

    
}
