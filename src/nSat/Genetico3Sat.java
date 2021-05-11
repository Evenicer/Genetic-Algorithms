/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nSat;

import HerramientasGeneral.Grafica;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Rogelio Valle
 */
public class Genetico3Sat {
    //parametros
    //private Poblacion poblacionActual;
    private int numGeneraciones,tamPob,tamGenotipo;
    private double probMuta;
    private ArrayList<IndividuonSat> poblacionActual;
    private int[] fitness;

    public Genetico3Sat(int numGeneraciones, int tamPob, double probMuta , int tamGenotipo) {
        this.numGeneraciones = numGeneraciones;
        this.tamPob = tamPob;
        this.probMuta = probMuta;
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
            ArrayList<IndividuonSat> nuevaPob = new ArrayList<>();
            for(int j=0; j<tamPob; j++){
                //Seleccionamos una madre y un padre
                IndividuonSat padre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                IndividuonSat madre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                //Se crea una mascara
                mask = binario.Herramientas.generarArregloBinarios(this.tamGenotipo);
                //cruza
                IndividuonSat hijo = Cruza.cruza1punto(mask, madre, padre);
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
            System.out.println("Genotipo: " + Arrays.toString(nSat.Herramientas.mejorPoblacion(nuevaPob).getGenotipo()));
            fitness[i] = Herramientas.mejorPoblacion(nuevaPob).getFitness();
        }
        graficar();
    }
    
    public void Evolucionar2(){
        //Se genera una poblacion inicial
        generarPoblacionInicialC();
        
        int[] mask;
        //ciclo para las generaciones
        for(int i=1; i<this.numGeneraciones; i++){
            //proceso iterativo para creacion de la nueva poblacion
            ArrayList<IndividuonSat> nuevaPob = new ArrayList<>();
            for(int j=0; j<tamPob; j++){
                //Seleccionamos una madre y un padre
                IndividuonSat padre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                IndividuonSat madre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                //Se crea una mascara
                mask = binario.Herramientas.generarArregloBinarios(this.tamGenotipo);
                //cruza
                IndividuonSat hijo = Cruza.cruza1punto(mask, madre, padre);
                //evaluar la probabilidad de muta
                if (generarProbabilidadMuta()){
                    Muta.mutaAleatoria(hijo);
                }
                //agregamos el individuo a la nueva poblacion
                nuevaPob.add(hijo);
            }
            //Actualuzamos la poblacion actual
            sustituirPoblacion(nuevaPob);
            System.out.println("Generacion: "+i+" Fitness: "+nSat.Herramientas.mejorPoblacion(nuevaPob).getFitness());
            System.out.println("Genotipo: " + Arrays.toString(nSat.Herramientas.mejorPoblacion(nuevaPob).getGenotipo()));
            fitness[i] = Herramientas.mejorPoblacion(nuevaPob).getFitness();
        }
        graficar();
    }
    
    public void graficar (){
       
        Grafica g1 = new Grafica("Generaciones","Fitness","3Sat");
        g1.agregarSerie("RED:", this.fitness);
        g1.crearGrafica();
        g1.muestraGrafica();
    
    }
    
     private void generarPoblacionInicial() {
        // generar un población aleatoria de individuos
        for (int i = 0; i < this.tamPob; i++) {
            this.getPoblacionActual().add(new IndividuonSat(this.tamGenotipo));
        }
    }
     
    private boolean generarProbabilidadMuta() {
        if (this.probMuta > Math.random()) {
            return true;
        } else {
            return false;
        }

    }

    private void sustituirPoblacion(ArrayList<IndividuonSat> nuevaPob) {
        this.getPoblacionActual().clear();
        for (IndividuonSat aux : nuevaPob) {
            aux.ActualizarInd();
            this.getPoblacionActual().add(new IndividuonSat(aux));
        }
    }

    /**
     * @return the poblacionActual
     */
    public ArrayList<IndividuonSat> getPoblacionActual() {
        return poblacionActual;
    }

    private void generarPoblacionInicialC() {
        // generar un población aleatoria de individuos
        for (int i = 0; i < this.tamPob; i++) {
            this.getPoblacionActual().add(new IndividuonSat(this.tamGenotipo,3));
        }
    }
    
}
