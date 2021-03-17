/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

/**
 *
 * @author Rogelio Valle
 */
public class Cruza {
    
    public static Individuo cruza1punto(int mask[] , Individuo madre, Individuo padre){
        int genotipo1[] = new int[mask.length];
        int genotipo2[] = new int[mask.length];
        
        //Con un for recorro la mascara y comparo con los genotipos
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == 1) {
                genotipo1[i] = madre.getGenotipo()[i];
                genotipo2[i] = padre.getGenotipo()[i];
            } else {
                genotipo1[i] = padre.getGenotipo()[i];
                genotipo2[i] = madre.getGenotipo()[i];
            }
        }
        Individuo hijo1 = new Individuo(genotipo1);
        Individuo hijo2 = new Individuo(genotipo2);

        //comparamos el fenotipo de los dos para retornar al mejor adaptado
        if (hijo1.getFitness() > hijo2.getFitness()) {
            return hijo1;
        } else {
            return hijo2;
        }
    }

}
