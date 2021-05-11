/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tsp;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Rogelio Valle
 */
public class Seleccion {
    public static IndividuoTsp seleccionAleatoria(ArrayList<IndividuoTsp> pob){
        Random ran = new Random();
        int pos = ran.nextInt(pob.size());
        return new IndividuoTsp(pob.get(pos));
    }
    
    public static IndividuoTsp seleccionRuleta(ArrayList<IndividuoTsp> pob){
        double suma = 0;
        double sumaPob = 0;
        
        //Calculo la suma de los fitness
        for (int i = 0; i < pob.size(); i++) {
            suma += pob.get(i).getFitness();
        }
        
        //ruleta
        double pos = suma*Math.random();
        
        for(int x=0; x<pob.size(); x++){
            sumaPob += pob.get(x).getFitness();
            if(sumaPob >= pos){
                return new IndividuoTsp(pob.get(x));
            }
        }
        return new IndividuoTsp(pob.get(0));
    }
}
