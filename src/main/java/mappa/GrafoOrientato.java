/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package mappa;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * 
 * l'idea alla base è quella di usare una hash map "Ambiente, listaAmbienti adiacenti[N,E,S,O]" in cui assegnamo ad ogni ambiente una lista 
 * che indicherà in che direzione sono gli ambienti adiacenti.
 * è importante usare delle costanti che serviranno a facilitare il capire Nord, Est, Sud, Ovest che saranno 0,1,2,3
 * 
 * @param <T> serve per rendere il grafo orientato applicabile a qualsiasi tipo di dato, in modo da poter creare
 *      un grafo di qualsiasi gruppo di elementi
 * 
 * @author Giuseppe
 * 
 */
public class GrafoOrientato<T> implements Serializable{
    //prendendo una ambiente come nodo, i suoi "vicini" saranno esplorati da sopra (nord) in senso orario
    private static final int NORD = 0;
    private static final int EST = 1;
    private static final int SUD = 2;
    private static final int OVEST = 3;
    
   
    private final HashMap<T,ArrayList> grafo;
    public GrafoOrientato(){
        grafo = new HashMap<>();
    }
    
    public void aggiungiNodo (T nodo, T nodoNord, T nodoEst, T nodoSud, T nodoOvest){
        ArrayList<T> listaNodiAdiacenti = new ArrayList<>();
        
        listaNodiAdiacenti.add(nodoNord);
        listaNodiAdiacenti.add(nodoEst);
        listaNodiAdiacenti.add(nodoSud);
        listaNodiAdiacenti.add(nodoOvest);
        grafo.put(nodo,listaNodiAdiacenti);
    }
    
    public ArrayList restituisciListaAdiacenti (T nodo) {return grafo.get(nodo);}

    //se non viene fatto il cast in (T) da errore
    public T restituisciAdiacenteNord (T nodo) {return (T) grafo.get(nodo).get(NORD);}
    public T restituisciAdiacenteEst (T nodo) {return (T) grafo.get(nodo).get(EST);}
    public T restituisciAdiacenteSud (T nodo) {return (T) grafo.get(nodo).get(SUD);}
    public T restituisciAdiacenteOvest (T nodo) {return (T) grafo.get(nodo).get(OVEST);}
    
    //controllo se non è nullo il nodo in una specifica direzione
    public boolean verificaAdiacenteNord (T nodo) {return grafo.get(nodo).get(NORD) != null;}
    public boolean verificaAdiacenteEst (T nodo) {return grafo.get(nodo).get(EST) != null;}
    public boolean verificaAdiacenteSud (T nodo) {return grafo.get(nodo).get(SUD) != null;}
    public boolean verificaAdiacenteOvest (T nodo) {return grafo.get(nodo).get(OVEST) != null;}
    
    
    public void cambiaNodo (T nodoOriginale, T nodoModificato) {
        ArrayList<T> listaAdiacenzeAppoggio = grafo.get(nodoOriginale);
        grafo.remove(nodoOriginale);
        grafo.put(nodoModificato, listaAdiacenzeAppoggio);
        
    }
    
    
}
