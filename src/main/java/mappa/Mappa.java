/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappa;

import componentiBase.Ambiente;
import java.io.Serializable;

/**
 *Utilizza grafoOrientato su Ambiente in modo da creare una mappa meno generica rispetto al grafo
 * 
 * @author Giuseppe
 */
public class Mappa implements Serializable{
    private GrafoOrientato<Ambiente> mappa;
    
    public Mappa(){
        mappa = new GrafoOrientato();
        
    }
    
    public Mappa(GrafoOrientato mappa){
        this.mappa = mappa;
    }
    
    public Ambiente getAmbienteNord(Ambiente stanza){return (Ambiente) mappa.restituisciAdiacenteNord(stanza);}
    public Ambiente getAmbienteEst(Ambiente stanza){return (Ambiente) mappa.restituisciAdiacenteEst(stanza);}
    public Ambiente getAmbienteSud(Ambiente stanza){return (Ambiente) mappa.restituisciAdiacenteSud(stanza);}
    public Ambiente getAmbienteOvest(Ambiente stanza){return (Ambiente) mappa.restituisciAdiacenteOvest(stanza);}
    
    //essenziale per poter mettere e togliere oggetti dalle stanze
    public void aggiornaStanza(Ambiente stanzaOriginale, Ambiente stanzaAggiornata){
        mappa.cambiaNodo(stanzaOriginale, stanzaAggiornata);
    }
    
    public boolean verificaAmbienteNord(Ambiente stanza){return mappa.verificaAdiacenteNord(stanza);}
    public boolean verificaAmbienteEst(Ambiente stanza){return mappa.verificaAdiacenteEst(stanza);}
    public boolean verificaAmbienteSud(Ambiente stanza){return mappa.verificaAdiacenteSud(stanza);}
    public boolean verificaAmbienteOvest(Ambiente stanza){return mappa.verificaAdiacenteOvest(stanza);}
    
    
}
