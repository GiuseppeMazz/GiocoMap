/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parser;

import componentiBase.Oggetto;
import componentiBase.Comando;
import java.util.List;
import java.util.Arrays;
import java.util.ListIterator;

/**
 * Si occupa prima della tokenizazione del essaggio inviato dall'utente e poi restituisce un parser Output
 * modellato apposta per il comando ddell'utente a seconda dei comandi e oggetti inseriti
 * 
 * @author Giuseppe
 */
public class Parser {
    
    
    
    private final List<Comando> comandi;
    private final List<Oggetto> oggetti;
    private final List<String> stopWords;
    
    public Parser(List<Comando> listaComandi, List<Oggetto> listaOggetti, List<String> stopWords){
        comandi = listaComandi;
        oggetti = listaOggetti;
        this.stopWords = stopWords;
    }
    
    
    
    private Comando cercaComando(String comando){
        Comando comandoAppoggio = null;
        Comando comandoCorretto = null;
        ListIterator<Comando> iteratoreComandi = comandi.listIterator();

        while (iteratoreComandi.hasNext() && comandoCorretto == null){
            comandoAppoggio = iteratoreComandi.next();

            if(comandoAppoggio.controllaComando(comando) == true){
                comandoCorretto = comandoAppoggio;
            }
            
        }
        return comandoCorretto;
    }
    
    
    private Oggetto cercaOggetto (String oggetto) {
        //boolean flagEsisteOggetto = false;
        Oggetto oggettoAppoggio = null;
        Oggetto oggettoCorretto = null;
        ListIterator<Oggetto> iteratoreOggetti = oggetti.listIterator();
        
        while (iteratoreOggetti.hasNext() && oggettoCorretto == null){
            
            oggettoAppoggio = iteratoreOggetti.next();
            if (oggettoAppoggio.controllaOggetto(oggetto) == true){
                oggettoCorretto = oggettoAppoggio;
            }
        }
        
        return oggettoCorretto;
    }
    
    
    private List tokenizzatore(String testo){

        //dovrebbe rimuovare gli spazzi dall'inizio e dalla fine della stringa in modo da non confondere lo splitter sugli spazi
        testo = testo.trim();
        String[] tokens = testo.split("\\s+"); //dovrebbe funzionare come semplicissiom splitter su spazi
        
        List<String> listaToken = Arrays.asList(tokens);
        listaToken.removeAll(stopWords);
         
       return listaToken;
    }
    
    
   
    public ParserOutput processa (String messaggio){

        List<String> istruzione = tokenizzatore(messaggio);
            
        if (!istruzione.isEmpty() && cercaComando(istruzione.get(0)) != null){
            if(istruzione.size()>1 && cercaOggetto(istruzione.get(1)) != null){
                if(istruzione.size()>2 && cercaOggetto(istruzione.get(2)) != null){
                    //gestione dei comandi che hanno 2 oggetti come parametri
                    
                    return new ParserOutput(cercaComando(istruzione.get(0)),
                            cercaOggetto(istruzione.get(1)),cercaOggetto(istruzione.get(2)));
                }
                //gestione dei comandi con un oggetto come parametro
                return new ParserOutput(cercaComando(istruzione.get(0)), cercaOggetto(istruzione.get(1)));
            }
            //gestione dei comandi senza oggetti
            return new ParserOutput(cercaComando(istruzione.get(0)));
        }
        return null;
    }
}
