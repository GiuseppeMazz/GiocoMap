/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parser;

import componentiBase.Oggetto;
import componentiBase.Comando;

/**
 * 
 * classe usata per dare un Output articolato dal parser
 * 
 *
 * @author Giuseppe
 */
public class ParserOutput {
    private Comando comando;
    private Oggetto primoOggetto;
    private Oggetto secondoOggetto;
    
    ParserOutput(Comando comando, Oggetto primoOggetto, Oggetto secondoOggetto){
        this.comando = comando;
        this.primoOggetto = primoOggetto;
        this.secondoOggetto = secondoOggetto;
    }
    
    ParserOutput(Comando comando){
        this.comando = comando;
        primoOggetto = null;
        secondoOggetto = null;
    }
    
    ParserOutput(Comando comando, Oggetto primoOggetto){
        this.comando = comando;
        this.primoOggetto = primoOggetto;
        secondoOggetto = null;
    }
    
    public Comando getComando(){return comando;}
    public Oggetto getPrimoOggetto(){return primoOggetto;}
    public Oggetto getSecondoOggetto(){return secondoOggetto;}
    
}
