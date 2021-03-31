/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nReinas;

import java.util.ArrayList;

/**
 *
 * @author Rogelio Valle
 */
public class Poblacion {
    private ArrayList<Individuo> individuos;
    private Individuo mejor;
    
    public Poblacion(){
        this.individuos = new ArrayList<>();
        this.mejor = null;
    }
    
    //Crear poblacion aleatoria
    public Poblacion(int tam , int tamGenotipo){
        this.individuos = new ArrayList<>();
        for(int i=0; i<tam; i++){
            Individuo ind = new Individuo(tamGenotipo); 
            //ind.getFitness();
            this.individuos.add(ind);
        }
    }
    
    //Crear poblacion en base a otra
    public Poblacion(Poblacion pob){
        this.individuos = new ArrayList<>();
        for(Individuo ind: pob.getPoblacion()){
            Individuo n = new Individuo(ind.getGenotipo());
            this.individuos.add(n);
        }
    }
    
    public Individuo getMejor(){
        int mejor = 0;
        for(int i=1; i<this.individuos.size(); i++){
            if( this.individuos.get(i).getFitness() < this.individuos.get(mejor).getFitness()){
                mejor = i;
            }
        }
        Individuo mejor2 = new Individuo(this.individuos.get(mejor).getGenotipo());
        return mejor2;
    }
    
    public ArrayList<Individuo> getPoblacion(){
        return individuos;
    }
}
