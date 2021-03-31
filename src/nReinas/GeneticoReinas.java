/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nReinas;

import HerramientasGeneral.Grafica;
import nReinas.Cruza;
import binario.Herramientas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Rogelio Valle
 */
public class GeneticoReinas {
    //Elementos que necesitamos
    private int tamPob;
    private double probMuta;
    private int numGeneraciones;
    private int tamGenotipo;
    private ArrayList<Individuo> poblacionActual;
    private int[] fitness;
    
    
    public GeneticoReinas(int tamPob, double probMuta, int numGeneraciones , int tamGenotipo){
        this.tamPob = tamPob;
        this.probMuta = probMuta;
        this.numGeneraciones = numGeneraciones;
        this.tamGenotipo = tamGenotipo;
        this.poblacionActual = new ArrayList<>();
        this.fitness = new int[this.numGeneraciones];
    }
    
    public void Evolucionar(){
        //Se genera una poblacion inicial
        generarPoblacionInicial();
        
        int[] mask;
        //ciclo para las generaciones
        for(int i=1; i<this.numGeneraciones; i++){
            //proceso iterativo para creacion de la nueva poblacion
            ArrayList<Individuo> nuevaPob = new ArrayList<>();
            for(int j=0; j<tamPob; j++){
                //Seleccionamos una madre y un padre
                Individuo padre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                Individuo madre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                //Se crea una mascara
                mask = Herramientas.generarArregloBinarios(this.tamGenotipo);
                //cruza
                Individuo hijo = Cruza.cruza1punto(mask, madre, padre);
                //evaluar la probabilidad de muta
                if (generarProbabilidadMuta()){
                    Muta.mutaAleatoria(hijo);
                }
                //agregamos el individuo a la nueva poblacion
                nuevaPob.add(hijo);
            }
            //Actualuzamos la poblacion actual
            sustituirPoblacion(nuevaPob);
            System.out.println("Generacion: "+i+" Fitness: "+Herramientas.mejorPoblacion(nuevaPob).getFitness());
            fitness[i] = Herramientas.mejorPoblacion(nuevaPob).getFitness();
        }
        graficar();
    }
    
     public void graficar (){
       
        Grafica g1 = new Grafica("Generaciones","Fitness","N-Reinas");
        g1.agregarSerie("RED:", this.fitness);
        g1.crearGrafica();
        g1.muestraGrafica();
    
    }
    
     private void generarPoblacionInicial() {
        // generar un población aleatoria de individuos
        for (int i = 0; i < this.tamPob; i++) {
            this.getPoblacionActual().add(new Individuo(this.tamGenotipo));
        }

    }

    private boolean generarProbabilidadMuta() {
        if (this.probMuta > Math.random()) {
            return true;
        } else {
            return false;
        }

    }

    private void sustituirPoblacion(ArrayList<Individuo> nuevaPob) {
        this.getPoblacionActual().clear();
        for (Individuo aux : nuevaPob) {
            this.getPoblacionActual().add(new Individuo(aux));
        }
    }

    /**
     * @return the poblacionActual
     */
    public ArrayList<Individuo> getPoblacionActual() {
        return poblacionActual;
    }
}
