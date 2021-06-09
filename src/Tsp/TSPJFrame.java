/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tsp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.MAX_PRIORITY;
import java.util.ArrayList;

/**
 *
 * @author Rogelio Valle
 */
public class TSPJFrame extends javax.swing.JFrame {

    /**
     * Creates new form TSPJFrame
     */
    
    int[][] matrizDistancias;
    int[][] matrizInclinaciones;
    Control control , control2;
    GeneticoTspHilos genetico , gen , gen2;
    
    public TSPJFrame() {
        initComponents();
        
        this.jButtonDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HerramientasTsp t = new HerramientasTsp();
                matrizDistancias = t.cargarDistancias();
                matrizInclinaciones = new int[matrizDistancias.length][matrizDistancias.length];

                for (int i = 0; i < matrizDistancias.length; i++) {
                    for (int j = 0; j < matrizDistancias.length; j++) {
                        matrizInclinaciones[i][j] = matrizDistancias[i][j];
                        matrizInclinaciones[j][i] = (matrizDistancias[j][i]) * -1;
                    }
                }
                
            }
        });
        
        this.jButtonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int TamPob = Integer.parseInt(jTextFieldTamPob.getText());
                int Generaciones = Integer.parseInt(jTextFieldGeneraciones.getText());
                double probMuta = Double.parseDouble(jTextFieldMuta.getText());
                int CI = Integer.parseInt(jTextFieldCI.getText());
                int idSel = jComboBoxSeleccion.getSelectedIndex();
                
                ArrayList<Control> configuraciones = new ArrayList<>();
                ArrayList<GeneticoTspHilos> geneticos = new ArrayList<>();
                
                control = new Control(idSel,
                                      Generaciones,
                                      TamPob,
                                      probMuta,
                                      new Seleccion.TipoSeleccion[]{Seleccion.TipoSeleccion.RANDOM, Seleccion.TipoSeleccion.RANDOM},
                                      matrizDistancias.length,
                                      CI,
                                      matrizDistancias,
                                      matrizInclinaciones);
                
                control2 = new Control(idSel,
                                      Generaciones,
                                      TamPob,
                                      1,
                                      new Seleccion.TipoSeleccion[]{Seleccion.TipoSeleccion.RANDOM, Seleccion.TipoSeleccion.RANDOM},
                                      matrizDistancias.length,
                                      CI,
                                      matrizDistancias,
                                      matrizInclinaciones);
             
                //System.out.println("matriz: "+matrizDistancias.length);
                
                genetico = new GeneticoTspHilos(control);
                gen2 = new GeneticoTspHilos(control2);
                
                Thread hilo = new Thread(genetico);
                Thread hilo2 = new Thread(gen2);
                
                hilo.start();
                hilo2.start();
                
            }
        });
        
        this.jButtonCambiarPob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pob = Integer.parseInt(jTextFieldTamPob.getText());
                control.setTamPoblacion(pob);
                jTextFieldTamPob.setText(String.valueOf(pob));
            }
        });
        
        this.jButtonCambiarMuta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double pob = Double.parseDouble(jTextFieldMuta.getText());
                control.setProbMuta(pob);
                jTextFieldMuta.setText(String.valueOf(pob));
            }
        });
        
        this.jButtonMandarMuestra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<IndividuoTsp> muestra = new ArrayList<>();
                
                IndividuoTsp ind = HerramientasTsp.mejorPoblacion(gen2.getPoblacionActual());
                
                genetico.setIndividuo(ind);
                
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonDatos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTamPob = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldGeneraciones = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMuta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonIniciar = new javax.swing.JButton();
        jComboBoxSeleccion = new javax.swing.JComboBox<>();
        jButtonCambiarPob = new javax.swing.JButton();
        jButtonCambiarMuta = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCI = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonMandarMuestra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonDatos.setText("Cargar Datos");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Tamaño Poblacion:");

        jTextFieldTamPob.setText("0");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Num Generaciones:");

        jTextFieldGeneraciones.setText("0");
        jTextFieldGeneraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGeneracionesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Probabilidad Muta:");

        jTextFieldMuta.setText("0");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Seleccion:");

        jButtonIniciar.setText("Iniciar Genetico");

        jComboBoxSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Random", "Ruleta" }));
        jComboBoxSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSeleccionActionPerformed(evt);
            }
        });

        jButtonCambiarPob.setText("Cambiar Poblacion");

        jButtonCambiarMuta.setText("Cambiar P. Muta");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Ciudad Inicial:");

        jTextFieldCI.setText("0");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButtonMandarMuestra.setText("Muestra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonDatos)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldTamPob, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldMuta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCI, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonCambiarPob)
                                    .addComponent(jButtonCambiarMuta)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldGeneraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonMandarMuestra)
                                .addGap(10, 10, 10))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButtonIniciar)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButtonDatos)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTamPob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCambiarPob))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldMuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCambiarMuta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldGeneraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBoxSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonMandarMuestra)
                        .addGap(5, 5, 5)))
                .addComponent(jButtonIniciar)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSeleccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSeleccionActionPerformed

    private void jTextFieldGeneracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGeneracionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGeneracionesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TSPJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TSPJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TSPJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TSPJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TSPJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCambiarMuta;
    private javax.swing.JButton jButtonCambiarPob;
    private javax.swing.JButton jButtonDatos;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonMandarMuestra;
    private javax.swing.JComboBox<String> jComboBoxSeleccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldCI;
    private javax.swing.JTextField jTextFieldGeneraciones;
    private javax.swing.JTextField jTextFieldMuta;
    private javax.swing.JTextField jTextFieldTamPob;
    // End of variables declaration//GEN-END:variables
}
