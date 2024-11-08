/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parser;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * 
 * OBBIETTIVO: poter passare da GestioneComandigioco un feedbakck più complesso di una semplice stringa
 * esattamente si vogliono passare 2 tipi di input: "Lista(testo, tipo)" e "Lista(testo, tipo), jPanel".
 * per Lista(testo,tipo) si intende una lista di stringhe con il rispettivo tipo che indicherà come
 * dovranno essere formattate a testo, così possiamo dare un output all'utente decente e articolato.
 * per jPanel si intende ad esempio i rompicapi in modo che possiamo sovrascrivere l'interfaccia principale
 * 
 * @author Giuseppe
 *
 */
public class FeedbackOutput {
    private  ArrayList<TestoTipo> listaFeedback;
    private JPanel pannelloInterattivo;
    
    public class TestoTipo {
        private String testo;
        private Integer tipo;
        
        TestoTipo(String testo, Integer tipo){
            this.testo = testo;
            this.tipo = tipo;
        } 
        
        public String getTesto(){return testo;}
        public Integer getTipo(){return tipo;}
    }
    
    public JPanel getJPanel(){return pannelloInterattivo;}
    public List getListaTesti(){return listaFeedback;}
    
    public FeedbackOutput(){
        listaFeedback = new ArrayList<>();
        pannelloInterattivo = null;
    }
    
    
    public FeedbackOutput(String testo, Integer tipo){
        listaFeedback = new ArrayList<>();
        aggiungiTesto(testo,tipo);
        pannelloInterattivo = null;
    }
    
    
    public FeedbackOutput(String testo, Integer tipo, JPanel pannello){
        listaFeedback = new ArrayList<>();
        aggiungiTesto(testo,tipo);
        pannelloInterattivo = pannello;
    }
    
    
    public final void aggiungiPannello(JPanel pannello){
        pannelloInterattivo = pannello;
    }
    
    public final void aggiungiTesto(String testo, Integer tipo){
        listaFeedback.add(new TestoTipo(testo, tipo));
    }
    
    
}
