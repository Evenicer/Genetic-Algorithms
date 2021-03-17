/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.Random;

/**
 *
 * @author Rogelio Valle
 */
public class Seleccion {
    
    public static Individuo seleccionAleatoria(Poblacion pob){
        Random ran = new Random();
        
        return pob.getPoblacion().get(ran.nextInt(pob.getPoblacion().size()));
    }
    
}
