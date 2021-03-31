/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos2021.pkg2;

import binario.Genetico1;
import binario.Herramientas;
import binario.Individuo;
import java.util.Arrays;
import nReinas.GeneticoReinas;

/**
 *
 * @author working
 */
public class Geneticos20212 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int arreglo[] = new int[]{1,0,0,0,0};
//        Individuo i = new Individuo(arreglo);
//        System.out.println(i.getFenotipo()+" "+i.getFitness());

//          Genetico1 genetico = new Genetico1(1000,0.3,100,20);   
//          genetico.evolucionar();
        GeneticoReinas genetico = new GeneticoReinas(200, 0.25, 50000, 500);
        genetico.Evolucionar();
        System.out.println();
        System.out.println("Fitness: " + Herramientas.mejorPoblacion(genetico.getPoblacionActual()).getFitness());
        System.out.println("Genotipo: " + Arrays.toString(Herramientas.mejorPoblacion(genetico.getPoblacionActual()).getGenotipo()));

    }

}
