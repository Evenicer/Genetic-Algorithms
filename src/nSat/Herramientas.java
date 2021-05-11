/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nSat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Rogelio Valle
 */
public class Herramientas {

    public static ArrayList<Clausula> clausulas;

    public static void leerDatos() {
        clausulas = new ArrayList<>();
        String texto, aux;
        LinkedList<String> lista = new LinkedList();

        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();

                ArrayList<String> lista2 = new ArrayList<>();

                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), " ");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    int[] clausula = new int[lista2.size()];

                    for (int x = 0; x < lista2.size(); x++) {
                        clausula[x] = Integer.parseInt(lista2.get(x));
                    }

                    // a la coleccion de patrones se agrega un nuevo patron
                    clausulas.add(new Clausula(clausula[0], clausula[1], clausula[2]));
                    // patrones.add();
                    lista2.clear();

                }

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);

        }

    }
    
    public static IndividuonSat mejorPoblacion(ArrayList<IndividuonSat> pob){
        IndividuonSat mejor = new IndividuonSat(pob.get(0));
        for(IndividuonSat aux: pob){
            if (aux.getFitness() > mejor.getFitness()){
                mejor = new IndividuonSat(aux);
            }
        }
        return mejor;
    }

}
