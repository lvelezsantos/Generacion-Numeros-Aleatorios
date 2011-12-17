/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelSevenEleven.java
 *
 * Created on 26/09/2011, 10:27:21 AM
 */

/*
 * Autores:
 * Luis Alfonso Velez Santos
 * Carlos Yesid Hernandez Herrera
 * Jose Esteban Betin Diaz
 */

package Vista;

import auxiliares.Auxiliares;
import auxiliares.LimitadorSoloNumerosNumMaxCaracteres;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import simulaciones.Ejercicio4;
import simulaciones.SimulacionSevenEleven;

/**
 *
 * @author warlock
 */
public class JPanelEjercicio4 extends javax.swing.JPanel {
    ArrayList<Float> numeros1;
    ArrayList<Float> numeros2;
    SimulacionSevenEleven sm;
    Ejercicio4 e ;
    private int velocidad;
    /** Creates new form JPanelSevenEleven */
    public JPanelEjercicio4() {
        velocidad=0;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCorridas = new javax.swing.JTextField();
        jButtonSimular = new javax.swing.JButton();
        jCheckBoxRapido = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPaneResultado = new javax.swing.JScrollPane();
        jTextAreaResultado = new javax.swing.JTextArea();
        jProgressBar1 = new javax.swing.JProgressBar();

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/iconos/1317343951_project-open.png"))); // NOI18N
        jButton1.setToolTipText("Importar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/iconos/1317343951_project-open.png"))); // NOI18N
        jButton2.setToolTipText("Importar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jScrollPane2.setViewportView(jList2);

        jLabel3.setText("Numero de Corridas");

        jTextFieldCorridas.setDocument(new LimitadorSoloNumerosNumMaxCaracteres(jTextFieldCorridas, 6));

        jButtonSimular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/iconos/1317344174_play.png"))); // NOI18N
        jButtonSimular.setToolTipText("Simular");
        jButtonSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimularActionPerformed(evt);
            }
        });

        jCheckBoxRapido.setText("Rapido");
        jCheckBoxRapido.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxRapidoStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxRapido, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jTextFieldCorridas, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jButtonSimular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCorridas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxRapido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(jButtonSimular))
        );

        jLabel1.setFont(new java.awt.Font("Ubuntu", 3, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ejercicio 4");

        jTextAreaResultado.setColumns(20);
        jTextAreaResultado.setRows(5);
        jScrollPaneResultado.setViewportView(jTextAreaResultado);

        jProgressBar1.setString("Simular");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addGap(259, 259, 259))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPaneResultado, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jScrollPane1, jScrollPane2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        int r =jf.showOpenDialog(jf);
        if(r == JFileChooser.APPROVE_OPTION){
            ObjectInputStream entrada;
            try {
                entrada = new ObjectInputStream(new FileInputStream(jf.getSelectedFile()));
                numeros1 = (ArrayList<Float>) entrada.readObject();
                System.out.println(numeros1.size());
                if(!numeros1.isEmpty()){
//                    JOptionPane.showMessageDialog(null, "Lista de números importado con éxito");
                    DefaultListModel lm = new DefaultListModel();

                    for(int i=0;i<numeros1.size();i++){
                        lm.addElement((i+1)+": "+numeros1.get(i));

                    }
                    jList1.setModel(lm);
                    

                    
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al importar el archivo");
            }


        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        int r =jf.showOpenDialog(jf);
        if(r == JFileChooser.APPROVE_OPTION){
            ObjectInputStream entrada;
            try {
                entrada = new ObjectInputStream(new FileInputStream(jf.getSelectedFile()));
                numeros2 = (ArrayList<Float>) entrada.readObject();
                System.out.println(numeros2.size());
                if(!numeros2.isEmpty()){
//                    JOptionPane.showMessageDialog(null, "Lista de números importado con éxito");
                    DefaultListModel lm = new DefaultListModel();
                    jList2.setModel(lm);
                    for(int i=0;i<numeros2.size();i++){
                        lm.addElement((i+1)+": "+numeros2.get(i));
                    }
                    jList2.setModel(lm);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al importar el archivo");
            }


        }
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimularActionPerformed
    if(numeros1!=null&&numeros2!=null &&!jTextFieldCorridas.getText().equalsIgnoreCase("")){
       jTextAreaResultado.setText("");
       e = new Ejercicio4();
       e.setNumeros1(numeros1);
       e.setNumeros2(numeros2);
       e.setCorridas(Auxiliares.convertirStringAEntero(jTextFieldCorridas));
       e.setListaResultados(jTextAreaResultado);
       e.setBoton(jButtonSimular);
       e.setJScrollPaneResultado(jScrollPaneResultado);
       e.setJp(jProgressBar1);
       e.setVelocidad(velocidad);
       e.start();

        }else{
            JOptionPane.showMessageDialog(this, "Hay campos vacios");
        }

    }//GEN-LAST:event_jButtonSimularActionPerformed

    private void jCheckBoxRapidoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxRapidoStateChanged
        cambiarVelocidad();
}//GEN-LAST:event_jCheckBoxRapidoStateChanged

 private void cambiarVelocidad(){
        if(jCheckBoxRapido.isSelected()){
                velocidad=0;
            }else{
                velocidad=100;
            }
         if(e!=null){
            if(jCheckBoxRapido.isSelected()){
                e.setVelocidad(0);
            }else{
                e.setVelocidad(100);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonSimular;
    private javax.swing.JCheckBox jCheckBoxRapido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneResultado;
    private javax.swing.JTextArea jTextAreaResultado;
    private javax.swing.JTextField jTextFieldCorridas;
    // End of variables declaration//GEN-END:variables


  


}