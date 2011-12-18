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
import simulaciones.SimulacionRuleta;
import simulaciones.SimulacionSevenEleven;

/**
 *
 * @author warlock
 */
public class JPanelRuleta extends javax.swing.JPanel {
    ArrayList<Float> numeros1;
    
    SimulacionRuleta r;
    /** Creates new form JPanelSevenEleven */
    public JPanelRuleta() {
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCorridas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldApuestaInicial = new javax.swing.JTextField();
        jTextFieldMeta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonSimular = new javax.swing.JButton();
        jCheckBoxRapido = new javax.swing.JCheckBox();
        jLabelResultado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelEstrategia = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPaneEstrategia1 = new javax.swing.JScrollPane();
        jTextAreaEstrategia1 = new javax.swing.JTextArea();
        jScrollPaneEstrategia2 = new javax.swing.JScrollPane();
        jTextAreaEstrategia2 = new javax.swing.JTextArea();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(774, 500));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/iconos/1317343951_project-open.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Estrategia 1");

        jScrollPane1.setViewportView(jList1);

        jLabel3.setText("Numero de Corridas");

        jTextFieldCorridas.setDocument(new LimitadorSoloNumerosNumMaxCaracteres(jTextFieldCorridas, 6));

        jLabel1.setText("Apuesta Inicial");

        jTextFieldApuestaInicial.setDocument(new LimitadorSoloNumerosNumMaxCaracteres(jTextFieldApuestaInicial, 9));

        jTextFieldMeta.setDocument(new LimitadorSoloNumerosNumMaxCaracteres(jTextFieldMeta, 9));

        jLabel4.setText("Meta");

        jButtonSimular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/iconos/1317344174_play.png"))); // NOI18N
        jButtonSimular.setToolTipText("Simular");
        jButtonSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimularActionPerformed(evt);
            }
        });

        jCheckBoxRapido.setSelected(true);
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
                    .addComponent(jCheckBoxRapido, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jTextFieldCorridas, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jTextFieldApuestaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jTextFieldMeta, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jButtonSimular, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButtonSimular))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldApuestaInicial, jTextFieldCorridas, jTextFieldMeta});

        jLabelResultado.setFont(new java.awt.Font("Ubuntu", 2, 48)); // NOI18N
        jLabelResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelResultado.setText("Resultado");

        jLabel5.setText("Estrategia 2");

        jLabelEstrategia.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabelEstrategia.setText("Estrategia");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 3, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ruleta");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/iconos/ruleta online.jpg"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jProgressBar1.setString("Simular");
        jProgressBar1.setStringPainted(true);

        jTextAreaEstrategia1.setColumns(20);
        jTextAreaEstrategia1.setRows(5);
        jScrollPaneEstrategia1.setViewportView(jTextAreaEstrategia1);

        jTextAreaEstrategia2.setColumns(20);
        jTextAreaEstrategia2.setRows(5);
        jScrollPaneEstrategia2.setViewportView(jTextAreaEstrategia2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                        .addGap(409, 409, 409))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                        .addGap(15, 15, 15))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabelEstrategia, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jScrollPaneEstrategia2)))
                                .addGap(332, 332, 332))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPaneEstrategia1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jScrollPane1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabelEstrategia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneEstrategia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneEstrategia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jButtonSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimularActionPerformed
    if(numeros1!=null&&!jTextFieldApuestaInicial.getText().equalsIgnoreCase("")
            &&!jTextFieldCorridas.getText().equalsIgnoreCase("")&&!jTextFieldMeta.getText().equalsIgnoreCase("")){
            r = new SimulacionRuleta(numeros1, Auxiliares.convertirStringAEntero(jTextFieldApuestaInicial), 1,
                    Auxiliares.convertirStringAEntero(jTextFieldCorridas), Auxiliares.convertirStringAEntero(jTextFieldMeta));
            r.setjListEstrategia1(jTextAreaEstrategia1);
            r.setjListEstrategia2(jTextAreaEstrategia2);
            r.setJp(jProgressBar1);
            r.setjScrollPaneEstrategia1(jScrollPaneEstrategia1);
            r.setjScrollPaneEstrategia2(jScrollPaneEstrategia2);
//            r.setjLabelColor(jLabelColor);
            r.setjLabelResultado(jLabelResultado);
            r.setjLabelEstrategia(jLabelEstrategia);
            r.setBoton(jButtonSimular);
            r.start();
        }else{
            JOptionPane.showMessageDialog(this, "Hay campos vacios");
        }

    }//GEN-LAST:event_jButtonSimularActionPerformed

    private void jCheckBoxRapidoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxRapidoStateChanged
        if(r!=null){
            if(jCheckBoxRapido.isSelected()){
                r.setVelocidad(0);
            }else{
                r.setVelocidad(100);
            }
        }
    }//GEN-LAST:event_jCheckBoxRapidoStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSimular;
    private javax.swing.JCheckBox jCheckBoxRapido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelEstrategia;
    private javax.swing.JLabel jLabelResultado;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneEstrategia1;
    private javax.swing.JScrollPane jScrollPaneEstrategia2;
    private javax.swing.JTextArea jTextAreaEstrategia1;
    private javax.swing.JTextArea jTextAreaEstrategia2;
    private javax.swing.JTextField jTextFieldApuestaInicial;
    private javax.swing.JTextField jTextFieldCorridas;
    private javax.swing.JTextField jTextFieldMeta;
    // End of variables declaration//GEN-END:variables


  


}
