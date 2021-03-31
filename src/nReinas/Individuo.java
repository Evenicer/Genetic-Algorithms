/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nReinas;

import binario.Herramientas;
import java.util.Random;

/**
 *
 * @author Rogelio Valle
 */
public class Individuo {
    //Atributos de un individuo para el problema de NReinas
    private int[] genotipo;
    private int fitness;
    private int n;
    
    public Individuo(int n){
        this.n = n;
        this.genotipo = Herramientas.generarArregloReinas(n);
        calcularfitness();
    }
    
    public Individuo(int[] gen) {
        // valorar su inicio aleatorio
        this.n = gen.length;
        this.genotipo = gen.clone();
        calcularfitness();
    }
    
    public Individuo(Individuo i) {
        this.genotipo = i.getGenotipo().clone();
        this.fitness = i.getFitness();
    }
    
    public int getFitness() {
        return fitness;
    }

    private void calcularfitness() {
        this.fitness = 0;

        //Recorro el genotipo
        for (int i = 0; i < this.n; i++) {
            for (int j = i + 1; j < this.n; j++) {
                //Evaluo los ataques posibles
                int a = this.genotipo[i];
                int b = this.genotipo[j];
                int a2 = this.genotipo[i] - i;
                int b2 = this.genotipo[j] - j;
                int a3 = this.genotipo[i] + i;
                int b3 = this.genotipo[j] + j;
                if (a == b || a2 == b2 || a3 == b3) {
                    this.fitness += 2;
                }
            }
        }
    }

    public int[] getGenotipo() {
        return genotipo;
    }    
}
