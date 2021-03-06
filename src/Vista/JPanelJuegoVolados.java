/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelJuegoVolados.java
 *
 * Created on 1/09/2011, 12:20:11 AM
 */

 /*
 * Autores:
 * Luis Alfonso Velez Santos
 * Carlos Yesid Hernandez Herrera
 * Jose Esteban Betin Diaz
 */

package Vista;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import simulaciones.SimulacionJuegoVolados;
import auxiliares.Auxiliares;
import auxiliares.LimitadorSoloNumerosNumMaxCaracteres;
import javax.swing.JOptionPane;

public class JPanelJuegoVolados extends javax.swing.JPanel {
    ArrayList<Float> numeros;
    SimulacionJuegoVolados jv;
    ArrayList<String> corridas;
    int velocidad=0;
    /** Creates new form JPanelJuegoVolados */
    public JPanelJuegoVolados() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCorridas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCantidadInicial = new javax.swing.JTextField();
        jTextFieldApuestaInicial = new javax.swing.JTextField();
        jTextFieldMeta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jCheckBoxRapido = new javax.swing.JCheckBox();
        jLabelResultado = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPaneResultados = new javax.swing.JScrollPane();
        jTextAreaResultados = new javax.swing.JTextArea();

        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Numeros Aleatorios");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 3, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Juego de los Volados");

        jLabel6.setText("Meta");

        jLabel5.setText("Apuesta Inicial");

        jLabel4.setText("Cantidad Inicial");

        jTextFieldCorridas.setDocument(new LimitadorSoloNumerosNumMaxCaracteres(jTextFieldCorridas, 4));

        jLabel3.setText("Corridas");

        jTextFieldCantidadInicial.setDocument(new LimitadorSoloNumerosNumMaxCaracteres(jTextFieldCantidadInicial, 9));

        jTextFieldApuestaInicial.setDocument(new LimitadorSoloNumerosNumMaxCaracteres(jTextFieldApuestaInicial, 9));

        jTextFieldMeta.setDocument(new LimitadorSoloNumerosNumMaxCaracteres(jTextFieldMeta, 9));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/iconos/1317344174_play.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                    .addComponent(jTextFieldCantidadInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldApuestaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldMeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jCheckBoxRapido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldCorridas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jLabel3, jLabel4, jLabel5, jLabel6, jTextFieldApuestaInicial, jTextFieldCantidadInicial, jTextFieldCorridas, jTextFieldMeta});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jTextFieldCantidadInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldApuestaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxRapido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextFieldCorridas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel4)
                    .addContainerGap(215, Short.MAX_VALUE)))
        );

        jLabelResultado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jProgressBar1.setStringPainted(true);

        jTextAreaResultados.setColumns(20);
        jTextAreaResultados.setRows(5);
        jScrollPaneResultados.setViewportView(jTextAreaResultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!jTextFieldApuestaInicial.getText().equalsIgnoreCase("")&&!jTextFieldCantidadInicial.getText().equalsIgnoreCase("")&&
                !jTextFieldCorridas.getText().equalsIgnoreCase("")&&!jTextFieldMeta.getText().equalsIgnoreCase("")){
        if(!numeros.isEmpty()){
            jv =  new SimulacionJuegoVolados();
            jv.setApuesta(Auxiliares.convertirStringAEntero(jTextFieldApuestaInicial));
            jv.setCantidadInicial(Auxiliares.convertirStringAEntero(jTextFieldCantidadInicial));
            jv.setMeta(Auxiliares.convertirStringAEntero(jTextFieldMeta));
            jv.setCorridas(Auxiliares.convertirStringAEntero(jTextFieldCorridas));
            jv.setNumeros(numeros);
            jv.setBoton(jButton1);
            jv.setJp(jProgressBar1);
            jv.setjListCorridas(jTextAreaResultados);
            jv.setJScrollPaneResultados(jScrollPaneResultados);
            jv.setjLabelMoneda(jLabelResultado);
            jv.setVelocidad(velocidad);
            jv.start();
//            llenarListaCorridas();
        }
        }else{
            JOptionPane.showMessageDialog(null, "Hay campos vacios");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBoxRapidoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxRapidoStateChanged
           cambiarVelocidad();
    }//GEN-LAST:event_jCheckBoxRapidoStateChanged

    private void cambiarVelocidad(){
        if(jCheckBoxRapido.isSelected()){
                velocidad=0;
            }else{
                velocidad=100;
            }
         if(jv!=null){
            if(jCheckBoxRapido.isSelected()){
                jv.setVelocidad(0);
            }else{
                jv.setVelocidad(100);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxRapido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelResultado;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneResultados;
    private javax.swing.JTextArea jTextAreaResultados;
    private javax.swing.JTextField jTextFieldApuestaInicial;
    private javax.swing.JTextField jTextFieldCantidadInicial;
    private javax.swing.JTextField jTextFieldCorridas;
    private javax.swing.JTextField jTextFieldMeta;
    // End of variables declaration//GEN-END:variables

    void setNumeros(ArrayList<Float> numeros) {
        this.numeros=numeros;
    }

    public void llenarLista(){
        if(!numeros.isEmpty()){
            DefaultListModel lm = new DefaultListModel();
            jList1.setModel(lm);
            for(int i=0;i<numeros.size();i++){
                lm.addElement((i+1)+": "+numeros.get(i));
            }
            jList1.setModel(lm);
        }else{
            System.out.println("Error");
        }
    }

//    public void llenarListaCorridas(){
//        if(!corridas.isEmpty()){
//            DefaultListModel lm = new DefaultListModel();
//            jList2.setModel(lm);
//            for(int i=0;i<corridas.size();i++){
//                lm.addElement((i+1)+": "+corridas.get(i));
//            }
//            jList2.setModel(lm);
//        }else{
//            System.out.println("Error");
//        }
//    }
}
