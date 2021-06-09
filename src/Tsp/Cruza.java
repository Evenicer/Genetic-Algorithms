/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Rogelio Valle
 */
public class Cruza {
    
    public static IndividuoTsp cruzaXMascara(IndividuoTsp madre, IndividuoTsp padre ,int[] mask) {
        int genotipo1[] = new int[padre.getGenotipo().length];
        int genotipo2[] = new int[padre.getGenotipo().length];
        
        //Declaro arraylist para controlas las posiciones mejor
         ArrayList aux1 = new ArrayList();
         ArrayList aux2 = new ArrayList();
         ArrayList aux3 = new ArrayList();
         ArrayList hijo1 = new ArrayList();
         ArrayList hijo2 = new ArrayList();
        
        int aux[] = new int[padre.getGenotipo().length];
        
        //Hago una mascara de puros 1 para copiar toda la madre en un arraylist
        for(int i=0; i<mask.length; i++){
             aux[i] = 1;
         }
        
        //copio a la madre en un arraylist
        for(int i=0; i<mask.length; i++){
             if(aux[i] == 1){
                 aux3.add(madre.getGenotipo()[i]);
             }
         }
        
        //La primera posision siempre sera la primer ciudad
        aux1.add(padre.getCInicial());
        
        //Ahora en donde tenga 1 de mi mascara lo copio en un arraylist
        for(int i=1; i<mask.length; i++){
             if(mask[i] == 1){
                 //aux[i] = padre.getGenotipo()[i];
                 aux1.add(padre.getGenotipo()[i]);
             }
         }
        
        //Elimino del segundo arraylist los elementos que tengo del primero
        for(int i=0; i<aux1.size(); i++){
             for(int j=0; j<aux3.size(); j++){
                 if(aux1.get(i).equals(aux3.get(j))){
                     aux3.remove(j);
                 }
             }
         }
        
        //Creo un nuevo array list con los primeros elementos que saque
        //Y le agrego los del segundo arraylist
         hijo1.addAll(aux1);
         hijo1.addAll(aux3);
         
         //Cambio las posiciones del segundo arraylist para tener un segundo genotipo
         Collections.reverse(aux3);
         
         //Agrego el segundo genotipo
         hijo2.addAll(aux1);
         hijo2.addAll(aux3);
          
         if(hijo1.size() > madre.getGenotipo().length){
             hijo1.subList(5, hijo1.size()).clear();
         }
         
         if(hijo2.size() > madre.getGenotipo().length){
             hijo2.subList(5, hijo2.size()).clear();
         }
         
         //Aqui los convierto a un arreglo de enteros
         for(int i=0; i<hijo1.size(); i++){
             genotipo1[i] = (int)hijo1.get(i);
             genotipo2[i] = (int)hijo2.get(i);
         }
          
        
        IndividuoTsp hijo1_ = new IndividuoTsp(genotipo1);
        IndividuoTsp hijo2_ = new IndividuoTsp(genotipo2);

        //comparamos el fenotipo de los dos para retornar al mejor adaptado
        if ((hijo1_.getFitness() < hijo2_.getFitness()) && (hijo1_.getFitness() < padre.getFitness()) && (hijo1_.getFitness() < madre.getFitness())  ) {
            return hijo1_;
        } else if( (hijo2_.getFitness() < hijo1_.getFitness()) && (hijo2_.getFitness() < padre.getFitness()) && (hijo2_.getFitness() < madre.getFitness()) ) {
            return hijo2_;
        } else if( (padre.getFitness() < hijo2_.getFitness()) && (padre.getFitness() < hijo1_.getFitness()) && (padre.getFitness() < madre.getFitness()) ){
            return padre;
        }else{
            return madre;
        }
    }
    
    public static IndividuoTsp cruzaXMascara2(IndividuoTsp madre, IndividuoTsp padre ,int[] mask) {
        int genotipo1[] = new int[padre.getGenotipo().length];
        int genotipo2[] = new int[padre.getGenotipo().length];
        
        //Declaro arraylist para controlas las posiciones mejor
         ArrayList aux1 = new ArrayList();
         ArrayList aux2 = new ArrayList();
         ArrayList aux3 = new ArrayList();
         ArrayList hijo1 = new ArrayList();
         ArrayList hijo2 = new ArrayList();
        
        int aux[] = new int[padre.getGenotipo().length];
        
        //Hago una mascara de puros 1 para copiar toda la madre en un arraylist
        for(int i=0; i<mask.length; i++){
             aux[i] = 1;
         }
        
        //copio a la madre en un arraylist
        for(int i=0; i<mask.length; i++){
             if(aux[i] == 1){
                 aux3.add(madre.getGenotipo()[i]);
             }
         }
        
        //La primera posision siempre sera la primer ciudad
        aux1.add(padre.getCInicial());
        
        //Ahora en donde tenga 1 de mi mascara lo copio en un arraylist
        for(int i=1; i<mask.length; i++){
             if(mask[i] == 1){
                 //aux[i] = padre.getGenotipo()[i];
                 aux1.add(padre.getGenotipo()[i]);
             }
         }
        
        //Elimino del segundo arraylist los elementos que tengo del primero
        for(int i=0; i<aux1.size(); i++){
             for(int j=0; j<aux3.size(); j++){
                 if(aux1.get(i).equals(aux3.get(j))){
                     aux3.remove(j);
                 }
             }
         }
        
        //Creo un nuevo array list con los primeros elementos que saque
        //Y le agrego los del segundo arraylist
         hijo1.addAll(aux1);
         hijo1.addAll(aux3);
         
         //Cambio las posiciones del segundo arraylist para tener un segundo genotipo
         Collections.reverse(aux3);
         
         //Agrego el segundo genotipo
         hijo2.addAll(aux1);
         hijo2.addAll(aux3);
          
         if(hijo1.size() > madre.getGenotipo().length){
             hijo1.subList(5, hijo1.size()).clear();
         }
         
         if(hijo2.size() > madre.getGenotipo().length){
             hijo2.subList(5, hijo2.size()).clear();
         }
         
         //Aqui los convierto a un arreglo de enteros
         for(int i=0; i<hijo1.size(); i++){
             genotipo1[i] = (int)hijo1.get(i);
             genotipo2[i] = (int)hijo2.get(i);
         }
          
        
        IndividuoTsp hijo1_ = new IndividuoTsp(genotipo1);
        IndividuoTsp hijo2_ = new IndividuoTsp(genotipo2);

        //comparamos el fenotipo de los dos para retornar al mejor adaptado
        if ((hijo1_.getFitnessGeneral()< hijo2_.getFitnessGeneral()) && (hijo1_.getFitnessGeneral() < padre.getFitnessGeneral()) && (hijo1_.getFitnessGeneral() < madre.getFitnessGeneral())  ) {
            return hijo1_;
        } else if( (hijo2_.getFitnessGeneral() < hijo1_.getFitnessGeneral()) && (hijo2_.getFitnessGeneral() < padre.getFitnessGeneral()) && (hijo2_.getFitnessGeneral() < madre.getFitnessGeneral()) ) {
            return hijo2_;
        } else if( (padre.getFitnessGeneral() < hijo2_.getFitnessGeneral()) && (padre.getFitnessGeneral() < hijo1_.getFitnessGeneral()) && (padre.getFitnessGeneral() < madre.getFitnessGeneral()) ){
            return padre;
        }else{
            return madre;
        }
    }
    
}
