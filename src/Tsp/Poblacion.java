/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tsp;

import java.util.ArrayList;

/**
 *
 * @author Rogelio Valle
 */
public class Poblacion {
    private ArrayList<IndividuoTsp> individuos;
    private IndividuoTsp mejor;
    
    public Poblacion(){
        this.individuos = new ArrayList<>();
        this.mejor = null;
    }
    
    //Crear poblacion aleatoria
    public Poblacion(int tam , int tamGenotipo , int CI){
        this.individuos = new ArrayList<>();
        for(int i=0; i<tam; i++){
            IndividuoTsp ind = new IndividuoTsp(tamGenotipo); 
            //ind.getFitness();
            this.individuos.add(ind);
        }
    }
    
    //Crear poblacion en base a otra
    public Poblacion(Poblacion pob){
        this.individuos = new ArrayList<>();
        for(IndividuoTsp ind: pob.getPoblacion()){
            IndividuoTsp n = new IndividuoTsp(ind.getGenotipo());
            this.individuos.add(n);
        }
    }
    
    public IndividuoTsp getMejor(){
        int mejor = 0;
        for(int i=1; i<this.individuos.size(); i++){
            if( this.individuos.get(i).getFitnessGeneral() < this.individuos.get(mejor).getFitnessGeneral()){
                mejor = i;
            }
        }
        IndividuoTsp mejor2 = new IndividuoTsp(this.individuos.get(mejor).getGenotipo());
        return mejor2;
    }
    
    public ArrayList<IndividuoTsp> getPoblacion(){
        return individuos;
    }
}
