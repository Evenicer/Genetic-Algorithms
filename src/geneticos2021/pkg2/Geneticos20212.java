/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos2021.pkg2;

import HerramientasGeneral.GeneradorArchivos;
import HerramientasGeneral.Grafica;
import Tsp.GeneticoTsp;
import Tsp.HerramientasTsp;
import binario.Genetico1;
import binario.Herramientas;
import binario.Individuo;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import nReinas.GeneticoReinas;
import nSat.Clausula;
import nSat.Genetico3Sat;

/**
 *
 * @author working
 */
public class Geneticos20212 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        int arreglo[] = new int[]{1,0,0,0,0};
//        Individuo i = new Individuo(arreglo);
//        System.out.println(i.getFenotipo()+" "+i.getFitness());

//          Genetico1 genetico = new Genetico1(1000,0.3,100,20);   
//          genetico.evolucionar();
////        //NReinas
//        GeneticoReinas genetico = new GeneticoReinas(100, 0.3, 100, 8);
//        System.out.println();
//        genetico.Evolucionar();
//        System.out.println();
//        System.out.println("Fitness: " + Herramientas.mejorPoblacion(genetico.getPoblacionActual()).getFitness());
//        System.out.println("Genotipo: " + Arrays.toString(Herramientas.mejorPoblacion(genetico.getPoblacionActual()).getGenotipo()));
////        //NReinas
//          //Prueba Archivos
//          ArrayList<nReinas.Individuo> individuos;
//          individuos = GeneradorArchivos.tokenizarDataSet();
//          for(int i=0; i<individuos.size(); i++){
//              System.out.println(Arrays.toString(individuos.get(i).getGenotipo()));
//              GeneradorArchivos.guardarIndividuos(individuos.get(i).getGenotipo(), "Individuos");
//          }
//          //Prueba Archivos
//       //TSP Generador
//       HerramientasTsp t = new HerramientasTsp();
//       int[][] cam = t.generarMatriz(1000);
//       t.guardarMatriz("caminos.txt", cam);
//              
        //int[][] cam = t.cargarDistancias();
        //System.out.println(cam.length);
//      
//        for (int x = 0; x < cam.length; x++) {
//            System.out.print("|");
//            for (int y = 0; y < cam[x].length; y++) {
//                System.out.print(cam[x][y]);
//                if (y != cam[x].length - 1) {
//                    System.out.print("\t");
//                }
//            }
//            System.out.println("|");
//        }
        //TSP Generador
        
        
////        //TSP GENETICO
//        HerramientasTsp t = new HerramientasTsp();
//        int[][] matriz = t.cargarDistancias();
//
//        GeneticoTsp tsp = new GeneticoTsp(100, 0.9, 100000, matriz.length, 110, matriz);
//        System.out.println("matriz: "+matriz.length);
//        tsp.Evolucionar();
//        System.out.println("Genotipo: " + Arrays.toString(HerramientasTsp.mejorPoblacion(tsp.getPoblacionActual()).getGenotipo()));
//        
//        System.out.println();
////       //TSP GENETICO


//     //3Sat Genetico
       nSat.Herramientas.leerDatos();
       
       Genetico3Sat nsat = new Genetico3Sat(5000,3000,0.7,100);
       nsat.Evolucionar();
       System.out.println();
       //System.out.println("Genotipo: " + Arrays.toString(nSat.Herramientas.mejorPoblacion(nsat.getPoblacionActual()).getGenotipo()));

//     //3Sat Genetico

    }

}
