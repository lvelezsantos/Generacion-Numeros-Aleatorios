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
import simulaciones.SimulacionSevenEleven;

/**
 *
 * @author warlock
 */
public class JPanelSevenEleven extends javax.swing.JPanel {
    ArrayList<Float> numeros1;
    ArrayList<Float> numeros2;
    SimulacionSevenEleven sm;
    /** Creates new form JPanelSevenEleven */
    public JPanelSevenEleven() {
        initComponents();
        jList1.setAutoscrolls(true);
       
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListCorridas = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListResultado = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCorridas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldApuestaInicial = new javax.swing.JTextField();
        jTextFieldMeta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonSimular = new javax.swing.JButton();
        jCheckBoxRapido = new javax.swing.JCheckBox();
        jLabelDado1 = new javax.swing.JLabel();
        jLabelDado2 = new javax.swing.JLabel();
        jLabelResultado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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

        jLabel2.setText("Corridas");

        jScrollPane4.setViewportView(jListCorridas);

        jScrollPane3.setViewportView(jListResultado);

        jScrollPane1.setViewportView(jList1);

        jScrollPane2.setViewportView(jList2);

        jLabel3.setText("Numero de Corridas");

        jTextFieldCorridas.setDocument(new LimitadorSoloNumerosNumMaxCaracteres(jTextFieldCorridas, 6));

        jLabel1.setText("Apuesta Inicial");

        jTextFieldApuestaInicial.setDocument(new LimitadorSoloNumerosNumMaxCaracteres(jTextFieldApuestaInicial, 9));

        jTextFieldMeta.setDocument(new LimitadorSoloNumerosNumMaxCaracteres(jTextFieldMeta, 9));

        jLabel4.setText("Meta");

        jButtonSimular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/iconos/1317344174_play.png"))); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSimular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jCheckBoxRapido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jTextFieldCorridas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jTextFieldApuestaInicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jTextFieldMeta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCorridas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldApuestaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jCheckBoxRapido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSimular))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldApuestaInicial, jTextFieldCorridas, jTextFieldMeta});

        jLabelDado1.setForeground(new java.awt.Color(1, 1, 1));
        jLabelDado1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelDado2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelResultado.setFont(new java.awt.Font("Ubuntu", 2, 24)); // NOI18N
        jLabelResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelResultado.setText("Resultado");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 3, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SevenEleven");

        jProgressBar1.setToolTipText("");
        jProgressBar1.setName(""); // NOI18N
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(87, 87, 87))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabelDado1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDado2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jScrollPane1, jScrollPane2});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelDado1, jLabelDado2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDado2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jLabelDado1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelDado1, jLabelDado2});

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
    if(numeros1!=null&&numeros2!=null&&!jTextFieldApuestaInicial.getText().equalsIgnoreCase("")
            &&!jTextFieldCorridas.getText().equalsIgnoreCase("")&&!jTextFieldMeta.getText().equalsIgnoreCase("")){
        sm = new SimulacionSevenEleven(numeros1, numeros2, Auxiliares.convertirStringAEntero(jTextFieldApuestaInicial), 1,Auxiliares.convertirStringAEntero( jTextFieldMeta));
        DefaultListModel lm = new DefaultListModel();
        jListResultado.setModel(lm);
        jListCorridas.setModel(lm);
        sm.setCorridas(Auxiliares.convertirStringAEntero(jTextFieldCorridas));
        sm.setListaCorrdias(jListCorridas);
        sm.setTextArea(jListResultado);
        sm.setBoton(jButtonSimular);
        sm.setCheckBox(jCheckBoxRapido);
        sm.setjLabelDado1(jLabelDado1);
        sm.setjLabelDado2(jLabelDado2);
        sm.setResultado(jLabelResultado);
        sm.setJp(jProgressBar1);

        sm.start();
        }else{
            JOptionPane.showMessageDialog(this, "Hay campos vacios");
        }

    }//GEN-LAST:event_jButtonSimularActionPerformed

    private void jCheckBoxRapidoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxRapidoStateChanged
        if(sm!=null){
            if(jCheckBoxRapido.isSelected()){
                sm.setVelocidad(0);
            }else{
                sm.setVelocidad(100);
            }
        }
    }//GEN-LAST:event_jCheckBoxRapidoStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonSimular;
    private javax.swing.JCheckBox jCheckBoxRapido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDado1;
    private javax.swing.JLabel jLabelDado2;
    private javax.swing.JLabel jLabelResultado;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jListCorridas;
    private javax.swing.JList jListResultado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextFieldApuestaInicial;
    private javax.swing.JTextField jTextFieldCorridas;
    private javax.swing.JTextField jTextFieldMeta;
    // End of variables declaration//GEN-END:variables


  


}
