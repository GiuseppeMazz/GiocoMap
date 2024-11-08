/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package console.giocoSchivaBlocchi;

import javax.swing.JPanel;

/**
 *
 * Questa interfaccia serve per far comunicare lo GiocoSchivaBlocchi con i thread delle istanze Barriera
 *  @author Giuseppe
 * 
 */
interface UpdateDalThread{
    boolean controllaCollisione( int Y);
    void distruggiBarriera(JPanel barriera);
    
}