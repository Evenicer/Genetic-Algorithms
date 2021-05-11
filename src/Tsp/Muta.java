/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tsp;

import java.util.Random;

/**
 *
 * @author Rogelio Valle
 */
public class Muta {
    public static IndividuoTsp mutaAleatoria(IndividuoTsp ind){
        Random ran = new Random();
        int posGen = ran.nextInt(ind.getGenotipo().length);
        int nuevo = ran.nextInt(ind.getGenotipo().length);
        
        ind.getGenotipo()[posGen]=nuevo;
        return ind;
    }
    
    public static IndividuoTsp mutaIntercambio(IndividuoTsp ind){
        Random ran = new Random();
        
        int posIntercambio = ran.nextInt(ind.getGenotipo().length);
        int posIntercambio2 = ran.nextInt(ind.getGenotipo().length);
        
        ind.getGenotipo()[posIntercambio] = ind.getGenotipo()[posIntercambio2];
        //ind.getGenotipo()[posIntercambio2] = ind.getGenotipo()[posIntercambio];
        return ind;
    }
    
    public static IndividuoTsp mutaIntercambio2(IndividuoTsp ind){
        // Intercambiamos aleatoriamente una posición entre las ciudades
            Random ran = new Random();
            int gen1 = -1;
            int gen2 = -1;
            int pos1 = ran.nextInt(ind.getGenotipo().length);
            int pos2 = ran.nextInt(ind.getGenotipo().length);
            // Calculamos posiciones hasta que ninguna sea la posición inicial
            while((pos1==0 || pos2==0) || (pos1==0 && pos2==0) || (pos1==pos2))
            {
                pos1 = ran.nextInt(ind.getGenotipo().length);
                pos2 = ran.nextInt(ind.getGenotipo().length);
            }
            // Intercambiamos los genes de las posiciones resultantes
            gen1 = ind.getGenotipo()[pos1];
            gen2 = ind.getGenotipo()[pos2];
            ind.getGenotipo()[pos1] = gen2;
            ind.getGenotipo()[pos2] = gen1;
        return ind;
    }
}
