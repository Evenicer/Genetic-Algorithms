/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tsp;

import binario.Herramientas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Rogelio Valle
 */
public class HerramientasTsp {

    public static int distancias[][];

    public int[][] generarMatriz(int tam) {
        distancias = new int[tam][tam];

        for (int x = 0; x < tam; x++) {
            for (int y = 0; y < tam; y++) {
                Random ran = new Random();
                int t = ran.nextInt(500);
                distancias[x][y] = t;
                distancias[y][x] = t;
            }
        }
        return distancias;
    }

    public void guardarMatriz(String nombre, int[][] matriz) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(nombre));
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                // Guardo en el archivo
                if(j == matriz.length-1){
                    outputWriter.write(matriz[i][j]+"\n");
                }else{
                outputWriter.write(matriz[i][j] + ",");
                }
            }
        }
        outputWriter.flush();
        outputWriter.close();
    }

    public int[][] cargarDistancias() {
        FileReader archivos = null;
        try {
            String cadena;
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();
            archivos = new FileReader(abre);
            BufferedReader lee = new BufferedReader(archivos);
            ArrayList<ArrayList<Integer>> Matriz = new ArrayList();
            if (abre != null) {
                int i = 0;

                while ((cadena = lee.readLine()) != null) {
                    String[] datos = cadena.split(",");

                    ArrayList<Integer> c = new ArrayList();
                    for (int j = 0; j < datos.length; j++) {
                        c.add(Integer.parseInt(datos[j]));

                    }
                    Matriz.add(c);

                    i++;
                }
                lee.close();

            }
            distancias = new int[Matriz.size()][Matriz.size()];
            for (int i = 0; i < Matriz.size(); i++) {
                for (int j = 0; j < Matriz.get(0).size(); j++) {
                    distancias[i][j] = Matriz.get(i).get(j);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivos.close();
            } catch (IOException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return distancias;
    }
    
    public static int[] GenerarGenotipoAleatorio(int Ciudades, int CInicial){
        //declaro el arreglo para el camino
        int ruta[] = new int[Ciudades];
        
        //Inicializo todos los campos para que no se vayan a repetir al agregar
        for(int i=0; i<Ciudades; i++){
            ruta[i] = -1;
        }
        
        Random ran = new Random();
        
        for(int i=0; i<Ciudades; i++){
            //Calculamos el indice de la ruta
            int ind = generarIndiceValido(ruta);
            ruta[ind] = i;
        }
        
        //Verifico que la ciudad inicial este al inicio
        if(ruta[0] != CInicial){
            for(int i=1; i<Ciudades; i++){
                if(ruta[i] == CInicial){
                    //Realizo un intercambio en caso de que no
                    ruta[i] = ruta[0];
                    ruta[0] = CInicial;
                    break;
                }
            }
        }
        
        return ruta;
    }
    
    public static int generarIndiceValido(int[] ruta) {
        Random r = new Random();
        int indice = r.nextInt(ruta.length);
        while(ruta[indice] != -1){
            indice = r.nextInt(ruta.length);
        }
        
        return indice;
    }
    
    public static IndividuoTsp mejorPoblacion(ArrayList<IndividuoTsp> pob){
        IndividuoTsp mejor = new IndividuoTsp(pob.get(0));
        for(IndividuoTsp aux: pob){
            if (aux.getFitness()< mejor.getFitness()){
                mejor = new IndividuoTsp(aux);
            }
        }
        return mejor;
    }
   
}
