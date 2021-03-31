/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nReinas;

import java.util.Random;

/**
 *
 * @author Rogelio Valle
 */
public class Muta {
    
    public static Individuo mutaAleatoria(Individuo ind){
        Random ran = new Random();
        int posGen = ran.nextInt(ind.getGenotipo().length);
        int nuevo = ran.nextInt(ind.getGenotipo().length);
        
        ind.getGenotipo()[posGen]=nuevo;
        return ind;
    }
}
