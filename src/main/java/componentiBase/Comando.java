/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentiBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe adibita alla definizione del tipo Comando
 * @author Giuseppe
 */
public class Comando implements Serializable{
    private final String nome;
    private final List<String> sinonimi; 
    

    public Comando(String nome, ArrayList<String> sinonimi) {
        this.nome = nome;
        this.sinonimi = sinonimi;     
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public boolean controllaComando(String comando){
        boolean flagUguaglianza = false;
        if(comando.equals(nome)){
            flagUguaglianza = true;
        } else if(sinonimi != null){
            if(sinonimi.contains(comando)) {
                flagUguaglianza = true;
            }
        }
        return flagUguaglianza;
    }
}


