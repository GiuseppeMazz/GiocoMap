/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parser;

import componentiBase.Ambiente;
import componentiBase.Giocatore;
import componentiBase.Oggetto;
import componentiBase.Comando;
import IOSalvataggioGioco.IOFileStato;
import componentiBase.OggettoContenitore;
import rompicapo.StatuaRompicapo;
import console.schermo.PanelConsole;
import impiantoElettrico.Pulsantiera;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mappa.Mappa;
import rompicapo.CassaforteRompicapo;
import rompicapo.FoglioSoluzioni;
import rompicapo.LibreriaRompicapo;
import stato.StatoGioco;

/**
 * La logica di questa classe è che essendo figlia dello "StatoGioco" nel senso che implementa
 * le funzionalità ed è l'unica che controlla il gioco nella sua interezza, come interagiscono
 * i vari elementi ecc..
 * 
 * per fare ciò utilizza sia funzioni per gestire i comandi in generale, ormai divisi in token, ma prepara
 * i pannelli per la schermata principale, passando spesso le implementazioni dlelle interfacceFunzionali necessarie
 * a collegare i minigame esterni alla logica del gioco
 * 
 * @author Giuseppe
 * 
 * 
 * 
 */
public class GestioneComandiGioco extends StatoGioco{
    private final int TESTO_NORMALE = 1;
    private final int TESTO_EVIDENZIATO = 2;
    private final int TESTO_CORSIVO = 3;
    
    public GestioneComandiGioco(Mappa mappa, Giocatore giocatore, List<Comando> comandi, List<Oggetto> oggetti, List<String> stopWords){
        super(mappa, giocatore, comandi, oggetti,stopWords);
    }
    
    public FeedbackOutput gestioneComandiSenzaOggetti(Comando comando){
        FeedbackOutput feedback = new FeedbackOutput();
        switch (comando.getNome()) {
            case "nord" ->                 {
                    
                    Ambiente stanza = getGiocatore().getAmbienteCorrente();
                    if(getMappa().verificaAmbienteNord(stanza) == true){
                        if(getMappa().getAmbienteNord(stanza).getChiuso()){
                            //feedback = ambienteChiusoNord(stanza);
                            feedback.aggiungiTesto(ambienteChiusoNord(stanza), TESTO_NORMALE);
                        }else {
                            getGiocatore().spostaGiocatore(getMappa().getAmbienteNord(stanza));
                            feedback.aggiungiTesto("Spostato in: " + getGiocatore().getAmbienteCorrente().getNome(), TESTO_NORMALE);
                            feedback.aggiungiTesto("\n"+getGiocatore().getAmbienteCorrente().getDescrizioneBreve(), TESTO_NORMALE);
                            feedback.aggiungiTesto(getGiocatore().getAmbienteCorrente().getListaInventario(), TESTO_NORMALE);
                        }
                        
                    } else{
                        feedback.aggiungiTesto("Non c'è nussuna stanza a nord", TESTO_NORMALE);
                    }                      }
            case "est" ->                 {
                    Ambiente stanza = getGiocatore().getAmbienteCorrente();
                    if(getMappa().verificaAmbienteEst(stanza) == true){
                        if(getMappa().getAmbienteEst(stanza).getChiuso()){
                            feedback.aggiungiTesto(ambienteChiusoEst(stanza), TESTO_NORMALE);
                        }else{
                            getGiocatore().spostaGiocatore(getMappa().getAmbienteEst(stanza));
                            feedback.aggiungiTesto("Spostato in: " + getGiocatore().getAmbienteCorrente().getNome(), TESTO_NORMALE);
                            feedback.aggiungiTesto("\n"+getGiocatore().getAmbienteCorrente().getDescrizioneBreve(), TESTO_NORMALE);
                            feedback.aggiungiTesto(getGiocatore().getAmbienteCorrente().getListaInventario(), TESTO_NORMALE);
                        }
                    } else{
                        feedback.aggiungiTesto("Non c'è nussuna stanza ad est", TESTO_NORMALE);
                    }                      }
            case "sud" ->                 {
                    Ambiente stanza = getGiocatore().getAmbienteCorrente();
                    if(getMappa().verificaAmbienteSud(stanza) == true){
                        getGiocatore().spostaGiocatore(getMappa().getAmbienteSud(stanza));
                        feedback.aggiungiTesto("Spostato in: " + getGiocatore().getAmbienteCorrente().getNome(), TESTO_NORMALE);
                        feedback.aggiungiTesto("\n"+getGiocatore().getAmbienteCorrente().getDescrizioneBreve(), TESTO_NORMALE);
                        feedback.aggiungiTesto(getGiocatore().getAmbienteCorrente().getListaInventario(), TESTO_NORMALE);
                    } else{
                        feedback.aggiungiTesto("Non c'è nussuna stanza a sud", TESTO_NORMALE);
                    }                      }
            case "ovest" ->                 {
                    Ambiente stanza = getGiocatore().getAmbienteCorrente();
                    if(getMappa().verificaAmbienteOvest(stanza) == true){
                        getGiocatore().spostaGiocatore(getMappa().getAmbienteOvest(stanza));
                        feedback.aggiungiTesto("Spostato in: " + getGiocatore().getAmbienteCorrente().getNome(), TESTO_NORMALE);
                        feedback.aggiungiTesto("\n"+getGiocatore().getAmbienteCorrente().getDescrizioneBreve(), TESTO_NORMALE);
                        feedback.aggiungiTesto(getGiocatore().getAmbienteCorrente().getListaInventario(), TESTO_NORMALE);
                    } else{
                        feedback.aggiungiTesto("Non c'è nussuna stanza ad ovest", TESTO_NORMALE);
                    }                      }
            case "inventario" -> {
                //inserire comando per stampare l'inventario
                ArrayList<Oggetto> inventario = getGiocatore().getInventario();
                ListIterator<Oggetto> iteratore = inventario.listIterator();
                feedback.aggiungiTesto("""
                                                       inventario:
                                                       """, TESTO_NORMALE);
                while(iteratore.hasNext()){
                    feedback.aggiungiTesto(iteratore.next().getNome() + "\n", TESTO_NORMALE);
                }
            }
            case "aiuto" ->
                //stampare istruzioni di aiuto
                feedback.aggiungiTesto("""
                                                   comandi singoli: nord, est, sud, ovest, inventario, ispeziona/info, salva, salvaSlot1, salvaSlot2
                                                                            carica, caricaSlot1, caricaSlot2, exit, aiuto, aiutoApprofondito;
                                                                    comandi con oggetto: usa <>, prendi <>, ispeziona <>, lascia <>, leggi <>
                                                                    comandi con due oggetti: combina <> <>
                                                                    inserire "aiutoApprofondito" (o AA) per avere una spiegazione più approfondita sui comandi
                                                   topografia e soluzioni dei minigames
                                                                    """, TESTO_NORMALE);
            case "aiutoApprofondito" ->     {feedback.aggiungiPannello(new PannelloAiuto());
                feedback.aggiungiTesto("Spero sia abbastanza", TESTO_NORMALE);
            }
            case "ispeziona" -> {
                Ambiente ambienteCorrente = getGiocatore().getAmbienteCorrente();
                //aggiungi nome stanza
                feedback.aggiungiTesto(ambienteCorrente.getNome() + "\n", TESTO_NORMALE);
                //agiungi elenco stanze adiacenti
                feedback.aggiungiTesto(ambientiCircostanti(ambienteCorrente), TESTO_NORMALE);
                //aggiungi descrizione e inventario stanza
                feedback.aggiungiTesto(ambienteCorrente.getDescrizioneApprofondita() + "\n" +
                        ambienteCorrente.getListaInventario(), TESTO_NORMALE);
                
            }
            case "exit" -> System.exit(0); //chiudi programma
            case "salva" -> {
                //mostra i file presenti e informa l'utente sui modi per salvare
                Iterator iteratoreFileSalvataggi;
                iteratoreFileSalvataggi = IOFileStato.listaSalvataggi().iterator();
                String nomeFileSalvati = "";
                
                while(iteratoreFileSalvataggi.hasNext()){
                    Object oggettoPerControllare =  iteratoreFileSalvataggi.next();
                    if(oggettoPerControllare instanceof File file){
                        nomeFileSalvati = nomeFileSalvati + "   ~"+file.getName()+"\n";
                    }
                    
                }
                //nei file non è possibile insereire : ma per l'utente l'orario è meglio che abbbia i : al posto di -
                nomeFileSalvati = nomeFileSalvati.replace("-", ":");
                feedback.aggiungiTesto(" i file salvati sono: \n\n", TESTO_NORMALE);
                feedback.aggiungiTesto(nomeFileSalvati, TESTO_NORMALE);
                feedback.aggiungiTesto(" Inserire salvaSlot1(oppure ss1) per salvare nello slot1,"
                        + " rispettivamente salvaSlot2 (oppure ss2), nota che eventuali file già presenti nello slot scelto saranno eliminati", TESTO_NORMALE);
                
            }
            case "salvaSlot1" -> {
                try {
                    IOFileStato.inserisciFileStatoAttuale(super.copia(), 1);
                } catch (IOException ex) {
                    Logger.getLogger(GestioneComandiGioco.class.getName()).log(Level.SEVERE, null, ex);
                }   feedback.aggiungiTesto("il salvataggio è stato aggiunto nello slot 1", TESTO_NORMALE);
            }
            case "salvaSlot2" -> {
                try {
                    IOFileStato.inserisciFileStatoAttuale(super.copia(), 2);
                } catch (IOException ex) {
                    Logger.getLogger(GestioneComandiGioco.class.getName()).log(Level.SEVERE, null, ex);
                }   feedback.aggiungiTesto("il salvataggio è stato aggiunto nello slot 2", TESTO_NORMALE);
            }
            case "carica" -> {
                Iterator iteratoreFileSalvataggi;
                iteratoreFileSalvataggi = IOFileStato.listaSalvataggi().iterator();
                String nomeFileSalvati = "";                
                while(iteratoreFileSalvataggi.hasNext()){
                    Object oggettoPerControllare =  iteratoreFileSalvataggi.next();
                    if(oggettoPerControllare instanceof File file){
                        nomeFileSalvati = nomeFileSalvati + "   ~"+file.getName()+"\n";
                    }
                    
                }
                //nei file non è possibile insereire : ma per l'utente l'orario è meglio che abbbia i : al posto di -
                nomeFileSalvati = nomeFileSalvati.replace("-", ":");
                feedback.aggiungiTesto(" i file salvati sono: \n\n", TESTO_NORMALE);
                feedback.aggiungiTesto(nomeFileSalvati, TESTO_NORMALE);
                feedback.aggiungiTesto(" Inserire caricaSlot1(oppure cs1) per salvare nello slot1,"
                        + " rispettivamente caricaSlot2 (oppure cs2), not ail file attuale sarà eliminato se non precedentemente salvato in uno slot", TESTO_NORMALE);
            }
            case "caricaSlot1" -> {
                StatoGioco statoAppoggio;
                statoAppoggio = IOFileStato.caricaStato(1);
                if(statoAppoggio != null){
                    cambiaStato(statoAppoggio);
                    feedback.aggiungiTesto("Il salvataggio è stato caricato con successo", TESTO_NORMALE);
                } else { feedback.aggiungiTesto("Ci sono stati problemi nel caricamento dello stato", TESTO_NORMALE);}
            }
            case"caricaSlot2" -> {
                StatoGioco statoAppoggio;
                statoAppoggio = IOFileStato.caricaStato(2);
                if(statoAppoggio != null){
                    cambiaStato(statoAppoggio);
                    feedback.aggiungiTesto("Il salvataggio è stato caricato con successo", TESTO_NORMALE);
                } else { feedback.aggiungiTesto("Ci sono stati problemi nel caricamento dello stato", TESTO_NORMALE);}
            }
            default -> //messaggio di errore/non comprensione del mssaggio
                feedback.aggiungiTesto("Il comando non esiste o è stato scritto male", TESTO_NORMALE);
        }
        return feedback;
    }
    
    
    
    public FeedbackOutput gestioneComandiUnOggetto(Comando comando, Oggetto oggetto){
        FeedbackOutput feedback = new FeedbackOutput();
        
       
        switch (comando.getNome()) {
            case "usa" -> {
                if(getGiocatore().getAmbienteCorrente().controllaOggettoInStanza(oggetto) ||
                        getGiocatore().getInventario().contains(oggetto)){
                    switch (oggetto.getNome()) {
                        case "libreria" -> {
                            feedback.aggiungiTesto("Ti avvicini alla libreria", TESTO_NORMALE);
                            feedback.aggiungiPannello(new LibreriaRompicapo(
                                    libreria -> {
                                        libreriaOrdinata(feedback.getJPanel());
                                    }));
                        }
                        case "telecomando" -> {
                            // dovuto usare il casting per usare la funzione di OggettoContenitore,
                            // con il controllo di instanceof non ci dovrebbero essere problemi
                            if(oggetto instanceof OggettoContenitore telecomandoFittizio){
                                if(telecomandoFittizio.controllaOggettoInContenitore("pila")){
                                    if("Salotto".equals(getGiocatore().getAmbienteCorrente().getNome())){
                                        feedback.aggiungiTesto("Televisore acceso \n", TESTO_NORMALE);
                                        feedback.aggiungiTesto("""
                                                                                                           Benvenuto nella mia villa, vedo che sei riuscito almeno a usare un<s telecomando,
                                                                                                       da come forse ormai hai capito i """,TESTO_CORSIVO);
                                        feedback.aggiungiTesto(" 2 ", TESTO_EVIDENZIATO);
                                        feedback.aggiungiTesto("""
                                                                                                       pacchi erano solo un motivo per portare qualcuno nella casa.
                                                                                                       La villa è suddivisa in """, TESTO_CORSIVO);
                                        feedback.aggiungiTesto(" 4 ", TESTO_EVIDENZIATO);
                                        feedback.aggiungiTesto("""
                                                                                                       aree: esterno, primo piano, secondo piano e la cantina;
                                                                                                       la città più vicina dista""", TESTO_CORSIVO);
                                        feedback.aggiungiTesto(" 8 ", TESTO_EVIDENZIATO);
                                        feedback.aggiungiTesto("""
                                                                                                       km da qui, rimarrai intrappolato finchè non riuscirai
                                                                                                       a risolvere gli enigmi e a trovare una via d'uscita, buona fortuna".
                                                                                                       """, TESTO_CORSIVO);
                                        
                                    } else {
                                        feedback.aggiungiTesto("Senti il rumore del televisore dal salotto, forse dovresti tornarci"
                                                + "per capire cosa sta venendo trasmesso", TESTO_NORMALE);
                                    }
                                    
                                } else {
                                    feedback.aggiungiTesto("Questo telecomando non sembra avere pile", TESTO_NORMALE);
                                }
                            }
                        }
                        case "statua" -> {
                            feedback.aggiungiTesto("Ti avvicini alla statua", TESTO_NORMALE);
                            feedback.aggiungiPannello(new StatuaRompicapo(
                                    statuaRisolta -> {
                                        statuaRisolta(feedback.getJPanel());
                                    }));
                        }
                        case "quadro" -> {
                            feedback.aggiungiTesto("Ti avvicini al quadro elettrico", TESTO_NORMALE);
                            feedback.aggiungiPannello(new Pulsantiera(
                                    pulsantieraRisolta -> {
                                        pulsantieraRisolta(feedback.getJPanel(), getGiocatore().getAmbienteCorrente());
                                    }));
                        }
                        case "console" -> {
                            feedback.aggiungiTesto("nota che questo cabinato è totalmente irrilevante alla 'storia'",
                                    TESTO_EVIDENZIATO);
                            feedback.aggiungiPannello(new PanelConsole());
                        }
                        case "cassaforte" -> {
                            feedback.aggiungiTesto("Ti avvicini alla cassaforte", TESTO_NORMALE);
                            feedback.aggiungiPannello(new CassaforteRompicapo(
                                    cassaforte -> {
                                        cassaforteRisolta(feedback.getJPanel());
                                    }));
                        }
                        default -> {
                            feedback.aggiungiTesto("Per qualche motivo l'oggeto non è usabile ma è qui", TESTO_NORMALE);
                        }
                    }
                } else {
                    feedback.aggiungiTesto("Per qualche motivo l'oggeto non è usabile o non è qui", TESTO_NORMALE);
                }
            }
            case "prendi" ->                 {
                if(getGiocatore().getAmbienteCorrente().controllaOggettoInStanza(oggetto)){
                    if(oggetto.getSpostabile()){
                        Ambiente ambienteCorrente = getGiocatore().getAmbienteCorrente();
                        Ambiente ambienteAggiornato = ambienteCorrente;
                        ambienteAggiornato.togliOggettoAmbiente(oggetto);
                        getGiocatore().prendiOggetto(oggetto);
                        getMappa().aggiornaStanza(ambienteCorrente, ambienteAggiornato);
                        feedback.aggiungiTesto(oggetto.getNome() + " aggiunto all'inventario", TESTO_NORMALE);
                    } else {feedback.aggiungiTesto("Questo oggetto non è prendibile", TESTO_NORMALE);}
                    
                } else {feedback.aggiungiTesto("Questo oggetto non è presente nella stanza", TESTO_NORMALE);}
            }
            case "ispeziona" -> 
                feedback.aggiungiTesto(oggetto.getDescrizione(), TESTO_NORMALE);
            case "lascia" ->                 {
                if(getGiocatore().cercaOggettoInventario(oggetto.getNome())){
                    Ambiente ambienteCorrente = getGiocatore().getAmbienteCorrente();
                    Ambiente ambienteAggiornato = ambienteCorrente;
                    ambienteAggiornato.mettiOggettoAmbiente(oggetto);
                    getGiocatore().lasciaOggetto(oggetto);
                    getMappa().aggiornaStanza(ambienteCorrente, ambienteAggiornato);
                    feedback.aggiungiTesto(oggetto.getNome() + " rimosso dall'inventario", TESTO_NORMALE);
                } else {feedback.aggiungiTesto("L'oggtto non è presente nell'inventario", TESTO_NORMALE);}
            }
            case "leggi" ->                   {
                if(oggetto.getNome().matches("foglio.*") && getGiocatore().cercaOggettoInventario(oggetto.getNome())){
                    feedback.aggiungiTesto("Leggi il foglietto", TESTO_NORMALE);
                    feedback.aggiungiPannello(new FoglioSoluzioni(oggetto.getNome()));
                } else {feedback.aggiungiTesto("L'oggetto non è disponibile o non è un foglio", TESTO_NORMALE);}
                
            }
                    
            default ->
                feedback.aggiungiTesto("Il comando non esiste o è stato scritto male", TESTO_NORMALE);
        }
        
        return feedback;
    }
    
    
    public FeedbackOutput gestioneComandiOggettoContenitore(Comando comando, Oggetto oggetto, OggettoContenitore oggettoContenitore){
        FeedbackOutput feedback = new FeedbackOutput();
        
        if(comando.getNome().equals("combina")){
            if(oggetto.getNome().equals("pila") &&  oggettoContenitore.getNome().equals("telecomando")){
                oggettoContenitore.inserisciContenitore(oggetto);
                feedback.aggiungiTesto("La pila è stata inserita nel telecomando", TESTO_NORMALE);
            }
        }
        
        return feedback;
    }
    
    private void cassaforteRisolta(JPanel pannello){
        JOptionPane.showMessageDialog(pannello, """
                                                aggiunto all'inventario foglioCassaforte!
                                                usa -leggi foglioCassaforte- per leggere
                                                  (clicca 'torna al terminale' dopo l'ok)""", "Cassaforte aperta!",
                JOptionPane.PLAIN_MESSAGE);
        getGiocatore().prendiOggetto(trovaOggetto("foglioCassaforte"));
    }
    
    private void libreriaOrdinata(JPanel pannello){
        JOptionPane.showMessageDialog(pannello, """
                                                aggiunta all'inventario chiaveC!
                                                  (clicca 'torna al terminale' dopo l'ok)""", "Libreria ordinata!",
                JOptionPane.PLAIN_MESSAGE);
 
        
        getGiocatore().prendiOggetto(trovaOggetto("chiaveC"));
    }
    
    private void statuaRisolta(JPanel pannello){
        JOptionPane.showMessageDialog(pannello, """
                                                aggiunta all'inventario cartaMagnetica!
                                                  (clicca 'torna al terminale' dopo l'ok)""", "Libreria ordinata!",
                JOptionPane.PLAIN_MESSAGE);
        getGiocatore().prendiOggetto(trovaOggetto("cartaMagnetica"));
    }
    
    private Oggetto trovaOggetto(String nome){
        boolean oggettoTrovato = false;
        Oggetto oggettoDiAppoggio = null;
        
        Iterator<Oggetto> iteratoreOggetti = getOggetti().iterator();
        while(iteratoreOggetti.hasNext() && oggettoTrovato == false){
            oggettoDiAppoggio = iteratoreOggetti.next();
            if(oggettoDiAppoggio.controllaOggetto(nome)){
                oggettoTrovato = true;
                
            }   
        }
        return oggettoDiAppoggio;
    }
    
    
    
    
    private void pulsantieraRisolta(JPanel pannello, Ambiente stanza){
        JOptionPane.showMessageDialog(pannello, """
                                                Hai aperto la porta della stanza misteriosa!
                                                  (clicca 'torna al terminale' dopo l'ok)""", "Pulsantiera risolta!",
                JOptionPane.PLAIN_MESSAGE);
        getMappa().getAmbienteEst(stanza).apriAmbiente();
    }
    
    private String ambienteChiusoEst(Ambiente stanza){
        String feedback = "";
        if(getMappa().getAmbienteEst(stanza).getNome().equals("Cantina")){
            if(getGiocatore().cercaOggettoInventario("chiaveC")){
                feedback = "Usi la chiave targata c, ora la porta è aperta";
                getMappa().getAmbienteEst(stanza).apriAmbiente();
            } else {
                feedback = "La porta, targata C(chiaveC), è momentaneamente chiusa, forse dovresti -trovare- un oggetto per aprirla ";
            }
            
        }if(getMappa().getAmbienteEst(stanza).getNome().equals("Stanza misteriosa")){
            
            feedback = "La porta sembra chiusta ma c'è un -quadro- elettrico su di essa prova a scrivere -usa quadro-";
            
            
        }
        
        return feedback;
    }
    
    private String ambienteChiusoNord(Ambiente stanza){
        String feedback = "";
        if(getMappa().getAmbienteNord(stanza).getNome().equals("Studio")){
            if(getGiocatore().cercaOggettoInventario("chiaveS")){
                feedback = "Usi la chiave targata s per aprire la porta allo studio, ora puoi entrare";
                getMappa().getAmbienteNord(stanza).apriAmbiente();
                
            } else {
                feedback = "La porta è momentaneamente chiusa, forse dovresti -trovare- un oggetto per aprirla ";
            }
        } else if(getMappa().getAmbienteNord(stanza).getNome().equals("Uscita")){
            if(getGiocatore().cercaOggettoInventario("cartaMagnetica")){
                feedback = """
                           Strisci la carta megnetica sul lettore, si apre la porta e vedi un enorme scalinata,
                           porta fuori dalla villa, è tutto finito puoi andare via.
                           (inserire exit o esci per chiudere da comando, altrimenti premere la x, non c'è altro da fare )
                             """;
                getMappa().getAmbienteNord(stanza).apriAmbiente();

            } else {
                feedback = "La porta è momentaneamente chiusa, forse dovresti ottenere una carta per aprirla";
            }
        }
        
        return feedback;
    }
    
    
    private String ambientiCircostanti(Ambiente stanzaCorrente){
        String ambientiAttorno;
        ambientiAttorno = "     nord: " + stampaAmbiente(getMappa().getAmbienteNord(stanzaCorrente)) + "\n"
                        + "     est: " + stampaAmbiente(getMappa().getAmbienteEst(stanzaCorrente)) + "\n"
                        + "     sud: " + stampaAmbiente(getMappa().getAmbienteSud(stanzaCorrente)) + "\n"
                        + "     ovest: " + stampaAmbiente(getMappa().getAmbienteOvest(stanzaCorrente)) + "\n";
        
        return ambientiAttorno;
    }
    
    //questa funzione serve soltanto per la funzione che stampa gli ambienti adiacenti
    //in quanto se manca un ambiente adiacente avrà valore nullo
    private String stampaAmbiente(Ambiente ambiente){
        if(ambiente == null){
            return " vuoto ";
        }else{
            return  ambiente.getNome();
        }
        
    }
    
}

