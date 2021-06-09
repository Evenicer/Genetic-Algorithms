/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nSat;

/**
 *
 * @author Rogelio Valle
 */
public class Cruza {
    
    public static IndividuonSat cruza1punto(int mask[] , IndividuonSat madre, IndividuonSat padre){
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
        IndividuonSat hijo1 = new IndividuonSat(genotipo1);
        IndividuonSat hijo2 = new IndividuonSat(genotipo2);

        //comparamos el fenotipo de los dos para retornar al mejor adaptado
        if ( (hijo1.getFitness() > hijo2.getFitness() && hijo1.getFitness() > padre.getFitness() && hijo1.getFitness() > madre.getFitness()) )  {
            return hijo1;
        } else if( (hijo2.getFitness() > hijo1.getFitness() && hijo2.getFitness() > padre.getFitness() && hijo2.getFitness() > madre.getFitness())  ) {
            return hijo2;
        } else if ( (padre.getFitness() > hijo1.getFitness() && padre.getFitness() > hijo2.getFitness() && padre.getFitness() > madre.getFitness()) ){
            return padre;
        } else{
            return madre;
        }
    }
    
    public static IndividuonSat cruza1punto2(int mask[] , IndividuonSat madre, IndividuonSat padre){
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
        IndividuonSat hijo1 = new IndividuonSat(genotipo1);
        IndividuonSat hijo2 = new IndividuonSat(genotipo2);

        //comparamos el fenotipo de los dos para retornar al mejor adaptado
        if (hijo1.getFitness() > hijo2.getFitness()) {
            return hijo1;
        } else {
            return hijo2;
        }
    }
}
