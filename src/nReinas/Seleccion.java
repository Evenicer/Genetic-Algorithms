/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nReinas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Rogelio Valle
 */
public class Seleccion {
    public static Individuo seleccionAleatoria(ArrayList<Individuo> pob){
        Random ran = new Random();
        int pos = ran.nextInt(pob.size());
        return new Individuo(pob.get(pos));
    }
}
