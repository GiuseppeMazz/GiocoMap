/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package parser;

import componentiBase.Giocatore;
import java.util.List;
import componentiBase.Oggetto;
import componentiBase.OggettoContenitore;
import componentiBase.Comando;
import mappa.Mappa;

/**
 *
 * 
 *  Questa classe rappresenta il gioco attuale,
 *  contiene la "GestioneDeiComandi", classe adibita alla manipolazione dello "StatoGioco"
 *  e il "Parser"
 * 
 *  con questa classe si vuole far in modo che dalla schermata principale l'input utente viene passato e
 *  processato dal "parser", che darà poi una lista di token comprensibili alla classe "GestioneDeiComandi"
 *  che andrà effettivamente a modificare lo "StatoGioco" e darà in output un "FeedbackOutpu" da restituire alla
 *  schermata principale
 * 
 *  @author Giuseppe
 */
public class Gioco{
    private final GestioneComandiGioco gestioneComandi;
    private final Parser parser;
    private final int TESTO_NORMALE = 1;
    
    
    public Gioco(List<Comando> comandi, List<Oggetto> oggetti, List<String> stopWords, Mappa mappa, Giocatore giocatore){
        parser = new Parser(comandi, oggetti, stopWords);
        gestioneComandi = new GestioneComandiGioco(mappa, giocatore, comandi, oggetti,stopWords);
    }
    
    public FeedbackOutput processaInput(String testoUtente){
        FeedbackOutput feedback = new FeedbackOutput();
        ParserOutput testoProcessato = parser.processa(testoUtente);
        
        if(testoProcessato != null){
            boolean esistenzaComando = testoProcessato.getComando() != null;
            boolean esistenzaPrimoOggetto = testoProcessato.getPrimoOggetto() != null;
            boolean esistenzaSecondoOggetto = testoProcessato.getSecondoOggetto() != null;
            boolean contenitoreSecondoOggetto = testoProcessato.getSecondoOggetto() instanceof OggettoContenitore;
            boolean contenitorePrimoOggetto = testoProcessato.getPrimoOggetto() instanceof OggettoContenitore;
            

            if(esistenzaComando && !esistenzaPrimoOggetto && !esistenzaSecondoOggetto){
                feedback = gestioneComandi.gestioneComandiSenzaOggetti(testoProcessato.getComando());
                
            } else if (esistenzaComando && esistenzaPrimoOggetto && !esistenzaSecondoOggetto && !contenitoreSecondoOggetto){
                feedback = gestioneComandi.gestioneComandiUnOggetto(testoProcessato.getComando(),
                        testoProcessato.getPrimoOggetto());
               
                
                //gli else if successivi sono uguali ma servono per gestire i comandi sia
                //con contenitore come primo oggetto che come secondo (non può essere  in entrambi)
            } else if (esistenzaComando && esistenzaPrimoOggetto && esistenzaSecondoOggetto
                    && contenitoreSecondoOggetto && !contenitorePrimoOggetto){
                feedback = gestioneComandi.gestioneComandiOggettoContenitore(testoProcessato.getComando(),
                        testoProcessato.getPrimoOggetto(), (OggettoContenitore) testoProcessato.getSecondoOggetto());
                
            } else if (esistenzaComando && esistenzaPrimoOggetto && esistenzaSecondoOggetto
                    && contenitorePrimoOggetto && !contenitoreSecondoOggetto){
                feedback = gestioneComandi.gestioneComandiOggettoContenitore(testoProcessato.getComando(),
                         testoProcessato.getSecondoOggetto(), (OggettoContenitore) testoProcessato.getPrimoOggetto());
            }
        }else{ 
            feedback.aggiungiTesto("Comando non riconosciuto", TESTO_NORMALE);
        }
        return feedback;
    }
    
    
}
