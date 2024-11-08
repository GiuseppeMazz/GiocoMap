/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IOSalvataggioGioco;

import componentiBase.Ambiente;
import componentiBase.Giocatore;
import componentiBase.Oggetto;
import componentiBase.OggettoContenitore;
import componentiBase.Comando;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappa.GrafoOrientato;
import mappa.Mappa;
import stato.StatoGioco;

/**
 * classe dedicata all'IO con i file (conservati in salvataggiGioco)
 * @author Giuseppe
 */
public class IOFileStato {
    static private StatoGioco stato;
    
    /**
     *funzione per creare il file con lo stato iniziale del gioco (ambienti, oggetti, mappa, comandi)
     * @throws IOException
     */
    static public void istanziaStato() throws IOException {
        
        //dichiara gli oggetti
        OggettoContenitore telecomando = new OggettoContenitore("telecomando", true, "Un normale telecomando, magari è possibile trovare qualcosa per farlo funzionare");
        Oggetto pila = new Oggetto("pila", true, "Fonte di energia per il telecomando");
        Oggetto chiaveStudio = new Oggetto("chiaveS", true, "Chiave per aprire la porta dello Studio al piano superiore");
        Oggetto libreria = new Oggetto("libreria", false, "Uno strano scaffale di libri, sembra nascondere qualcosa, meglio provare -usa libreria-");
        Oggetto cassaforte = new Oggetto("cassaforte", false, "Contiene sicuramente qualcosa di importante, magari una combinazione");
        Oggetto chiaveCantina = new Oggetto("chiaveC", true, "Chiave per aprire la porta al piano terra che scende alla cantina");
        Oggetto console = new Oggetto("console", false, "Un oggetto fine a se stesso");
        Oggetto foglioCassaforte = new Oggetto("foglioCassaforte", true, "Una combinaizione di simboli strani, magari nella libreria ci saraà qualcosa a riguardo");
        Oggetto statua = new Oggetto("statua", false, "Una vecchia scultura, la bilancia sembra pendere da un lato, meglio provare -usa statua-");
        Oggetto quadroElettrico = new Oggetto("quadro", false, "Un semplice circuito elettrico sembra collegato alla porta, bisognerà risolverlo, proca -usa quadro-");
        Oggetto cartaMagnetica = new Oggetto("cartaMagnetica", true, "Una carta da scannerizzare, chissà cosa apre");
        
        
        //dichiara gli ambienti e inserisce oggetti al loro interno
        Ambiente entrataVilla = new Ambiente("Entrata villa",
                 "", "",false);
        
        Ambiente giardino = new Ambiente("Giardino",
                 "Un picolo giardino con una statua al centro", "Il giardino esterno alla casa sl lato ovest,"
                         + " presenta una statua al centro sembra importante",true);
        giardino.mettiOggettoAmbiente(statua);
        
        Ambiente ingresso = new Ambiente("Ingresso",
                 "", "",false);
        Ambiente salaPranzo = new Ambiente("Sala Pranzo",
                 "", "Una normale sala da pranzo nulla di troppo importante da notare",false);
        salaPranzo.mettiOggettoAmbiente(pila);
        
        
        Ambiente cucina = new Ambiente("Cucina",
                 "", "Una normale cucina nulla di troppo importante da notare",false);
        
        Ambiente salotto = new Ambiente("Salotto",
                 "Le poltrone sono un po' polverose ma la televisione sembra essere attaccata", 
                "Il televisore sembra poter trasmettere ualcosa, forse bisogna usare il telecomando (-usa telecomando-)",false);
        salotto.mettiOggettoAmbiente(telecomando);
        
        Ambiente corridoioSecondoPiano = new Ambiente("Corridoio secondo piano",
                 "", "Nulla di particolarmente rilevane in questo corridoio",false);
        
        Ambiente studio = new Ambiente("Studio",
                 "Sembrerebbe esserci qualcosa vicino alla scrivania",
                "La cassaforte sembra particolarente importante, magari qualcosa può trasmettere la combinazione",true);
        studio.mettiOggettoAmbiente(cassaforte);
        
        
        Ambiente biblioteca = new Ambiente("Biblioteca",
                 "Ci sono dei libri particolarmente strani", 
                "Uno degli scaffali sembra avere qualche strano meccanismo, sarebbe il caso di interagirci",false);
        biblioteca.mettiOggettoAmbiente(libreria);
        biblioteca.mettiOggettoAmbiente(chiaveStudio);
        
        Ambiente cantina = new Ambiente("Cantina",
                 "La console sembra essere collegata, inoltre qualcosa è presente sul muro",
                "La console sembra essere utilizzabile ma probabilmente non miserve a fuggire, invece usare il quadro (elettrico) sarebbe una buona idea",true);
        cantina.mettiOggettoAmbiente(console);
        cantina.mettiOggettoAmbiente(quadroElettrico);
        
        Ambiente stanzaMisteriosa = new Ambiente("Stanza misteriosa",
                 "C'è uno scanner di carte su una porta; anche se la stanza è buia si intravede anche una illustrazione, un giardino ed una figura di pietra",
                "La porta ocn lo scanner ha bisogno di una carta, l'illustrazione sul muro sembra rappresentare il giardino esterno, magari la statua li presente serve a qualcosa",true);
        
        Ambiente uscita = new Ambiente("Uscita",
                "","Nulla è la stanza per la fine",true);
        
        
        //definizione mappa
        GrafoOrientato<Ambiente> grafo = new GrafoOrientato();
        grafo.aggiungiNodo(entrataVilla, ingresso, null, null, giardino);
        grafo.aggiungiNodo(giardino, null, entrataVilla, null, null);
        grafo.aggiungiNodo(ingresso, salotto, corridoioSecondoPiano, entrataVilla, salaPranzo);
        grafo.aggiungiNodo(salaPranzo, cucina, ingresso, null, null);
        grafo.aggiungiNodo(cucina, null, null, salaPranzo, null);
        grafo.aggiungiNodo(salotto,null, cantina, ingresso, null);
        grafo.aggiungiNodo(cantina, null, stanzaMisteriosa, null, salotto);
        grafo.aggiungiNodo(stanzaMisteriosa, uscita, null, null, cantina);
        grafo.aggiungiNodo(uscita, null, null, stanzaMisteriosa, null);
        grafo.aggiungiNodo(corridoioSecondoPiano, studio, biblioteca, null, ingresso);
        grafo.aggiungiNodo(biblioteca, null, null, null, corridoioSecondoPiano);
        grafo.aggiungiNodo(studio, null, null, corridoioSecondoPiano, null);
        
        
        
        //definizione comandi
        Comando nord = new Comando("nord",new ArrayList<>(List.of("n")));
        Comando est = new Comando("est",new ArrayList<>(List.of("e")));
        Comando sud = new Comando("sud",new ArrayList<>(List.of("s")));
        Comando ovest = new Comando("ovest",new ArrayList<>(List.of("o")));
        Comando inventario = new Comando("inventario",new ArrayList<>(List.of("inv")));
        Comando aiuto = new Comando("aiuto",new ArrayList<>(List.of("help", "h")));
        Comando ispeziona = new Comando("ispeziona",new ArrayList<>(List.of("isp", "info")));
        Comando usa = new Comando("usa",new ArrayList<>(List.of("use")));
        Comando prendi = new Comando("prendi",new ArrayList<>(List.of("pick")));
        Comando lascia = new Comando("lascia",new ArrayList<>(List.of("leave")));
        Comando salva = new Comando("salva",new ArrayList<>(List.of("save")));
        Comando salvaSlot1 = new Comando("salvaSlot1", new ArrayList<>(List.of("ss1")));
        Comando salvaSlot2 = new Comando("salvaSlot2", new ArrayList<>(List.of("ss2")));
        Comando aiutoApprofondito = new Comando("aiutoApprofondito", new ArrayList<>(List.of("AA","hh")));
        Comando combina = new Comando("combina",new ArrayList<>(List.of("combine", "comb")));
        Comando caricaSalvataggioSlot1 = new Comando("caricaSlot1", new ArrayList<>(List.of("caricas1","caricasalvataggio1","caricaSalvataggio1","cs1")));
        Comando caricaSalvataggioSlot2 = new Comando("caricaSlot2", new ArrayList<>(List.of("caricas2","caricasalvataggio2", "caricaSalvataggio2","cs2")));
        Comando leggi = new Comando("leggi", new ArrayList<>(List.of("leg")));
        Comando exit = new Comando("exit", new ArrayList<>(List.of("esci")));
        
        //lista comandi
        List<Comando> comandi = new ArrayList();
        comandi.add(aiuto);
        comandi.add(nord);
        comandi.add(est);
        comandi.add(sud);
        comandi.add(ovest);
        comandi.add(inventario);
        comandi.add(ispeziona);
        comandi.add(usa);
        comandi.add(prendi);
        comandi.add(lascia);
        comandi.add(salva);
        comandi.add(combina);
        comandi.add(salvaSlot1);
        comandi.add(salvaSlot2);
        comandi.add(aiutoApprofondito);
        comandi.add(caricaSalvataggioSlot1);
        comandi.add(caricaSalvataggioSlot2);
        comandi.add(leggi);
        comandi.add(exit);
        
        //lista stopWords
        List<String> stopWords = new ArrayList();
        stopWords.add(" e ");
        stopWords.add(" di ");
        stopWords.add(" a ");
        stopWords.add(" da ");
        stopWords.add(" con ");
        stopWords.add("la");
        stopWords.add("il");
        
        //lista oggetti
        List<Oggetto> oggetti = new ArrayList();
        oggetti.add(telecomando);
        oggetti.add(pila);
        oggetti.add(chiaveStudio);
        oggetti.add(libreria);
        oggetti.add(cassaforte);
        oggetti.add(chiaveCantina);
        oggetti.add(console);
        oggetti.add(foglioCassaforte);
        oggetti.add(statua);
        oggetti.add(quadroElettrico);
        oggetti.add(cartaMagnetica);
        
        //crea giocatore
        Giocatore giocatore = new Giocatore(entrataVilla);
        
        //inserisce nel file un istanza di StatoGioco
        stato = new StatoGioco(new Mappa(grafo), giocatore, comandi, oggetti, stopWords);
        inserisciFileStatoIniziale(stato);
    }
    
    
    static public void inserisciFileStatoIniziale(StatoGioco stato) throws FileNotFoundException, IOException{
        FileOutputStream outFile = new FileOutputStream(new File("salvataggiGioco/statoIniziale.dat"));
        ObjectOutputStream outStream = new ObjectOutputStream(outFile);
        outStream.writeObject(stato);
    }
    
    
    //mostra i file nella cartella dei salvataggi, mostra anche lo stato iniziale
    static public List listaSalvataggi(){
        File directorySalvataggi = new File ("salvataggiGioco");
        return Arrays.asList(directorySalvataggi.listFiles());
    }
    
    //carica nella cartella un istanza dello StatoGioco collegandola con il nome ad uno slot
    static public void inserisciFileStatoAttuale(StatoGioco stato, int slot) throws FileNotFoundException, IOException{
        Date dataCorrente = new Date();

        // questa sezione trova ed elimina il file precedentemente slavato nello slot corrispondente
        File percorso = new File("salvataggiGioco");
        File[] files = percorso.listFiles();
        for (File f : files)
        {
            if (f.getName().startsWith("Slot "+slot))
            {
              f.delete();
            }
        }
        
        
        String data = dataCorrente.toString();
        data = data.replace(":", "-");
        data = data.replace(" CET", "");
        data = data.replaceAll("Sun|Mon|Tue|Wed|Thu|Fri|Sat", "");
        FileOutputStream outFile = new FileOutputStream(new File("salvataggiGioco/Slot "+slot+" salvataggio"+data+".dat"));
        ObjectOutputStream outStream = new ObjectOutputStream(outFile);
        outStream.writeObject(stato);
    }
    
    
    //Caricare stato da file nel programma in base allo slot
    //prima cerco il nome completo (formato da slot_ mese giorno eccc..)
    //poi lo utilizzo per prelecare tale file e restituirlo come output assicurandomi che sia uno StatoGioco
    static public StatoGioco caricaStato(int slot){
        File percorso = new File("salvataggiGioco");
        File[] files = percorso.listFiles();
        String nomeFile ="";
        for (File f : files)
        {
            if (f.getName().startsWith("Slot "+slot))
            {
              nomeFile = f.getName();
            }
        }
        try {
            ObjectInputStream statoInput = new ObjectInputStream(new FileInputStream(new File("salvataggiGioco/"+nomeFile)));
            if(statoInput.readObject() instanceof StatoGioco statoGioco){
                return statoGioco;
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(IOFileStato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
