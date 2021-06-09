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
public class Manager {
    
    private int numeroGeneticos;
    private ArrayList<GeneticoTspHilos> geneticos;
    private ArrayList<Control> configuraciones;

    public Manager() {
        this.numeroGeneticos = 0;
        this.geneticos = new ArrayList<>();
        this.configuraciones = new ArrayList<>();
    }

    public void generarGeneticos(ArrayList<Control> geneticos) {
        //Se crean los geneticos en base a las configuraciones que mande
        this.numeroGeneticos = geneticos.size();
        for (int x = 0; x < numeroGeneticos; x++) {
            this.configuraciones.add(geneticos.get(x));
            GeneticoTspHilos gen = new GeneticoTspHilos(geneticos.get(x));
            this.geneticos.add(gen);
        }
    }

    public void ejecutarGeneticos() {
        // ejecutar los geneticos en un hilo diferente
        for (GeneticoTspHilos aux : this.geneticos) {
            Thread hilo = new Thread(aux);
            hilo.start();
        }
    }

}
