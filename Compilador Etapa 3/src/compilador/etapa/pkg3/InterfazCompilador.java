package compilador.etapa.pkg3;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.JOptionPane;


public class InterfazCompilador extends javax.swing.JFrame {
    
    private String dirNuevo="";
    private String nomNuevo="";

    public InterfazCompilador() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Compilador");
        campotxt.setEnabled(false);
    }
    
    
    public void contarFilas(){
        int totalrows=campotxt.getLineCount();
            contadorLinea.setText("1\n");
            for(int i=2; i<=totalrows;i++){
                contadorLinea.setText(contadorLinea.getText()+i+"\n");
            }
    }
    
    public void habilitarCampo(String dirnovo, String nomnovo){
        this.setTitle("CompiladorEjemplo");
        this.nomNuevo=nomnovo;
        this.dirNuevo=dirnovo+nomNuevo+".jx";
        this.setTitle(this.getTitle()+" - "+dirNuevo);
        campotxt.enable(true);
        contarFilas();
    }
    
    public void habilitarCampo(String dirnovo){
        this.setTitle("CompiladorEjemplo");
        this.dirNuevo=dirnovo;
        try {
            FileInputStream fstream = new FileInputStream(dirNuevo);
            DataInputStream in = new DataInputStream(fstream);
            this.campotxt.setText("");
            while (in.available() != 0) {
                this.campotxt.setText(this.campotxt.getText() + in.readLine() + "\n");
            }
            in.close();
            this.setTitle(this.getTitle()+" - "+dirNuevo);
            campotxt.enable(true);
            contarFilas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"File input error");
        }
    }
    
    public boolean Guardar(){
        FileOutputStream out;
        PrintStream p;

        try {
            out = new FileOutputStream(dirNuevo);
            p = new PrintStream(out);
            p.println(this.campotxt.getText());
            p.close();
            this.setTitle(this.getTitle().replace("*", ""));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void abrir() {
        habilitarCampotxt("test.txt");
    }
    
    public void habilitarCampotxt(String dirnovo, String nomnovo){
        this.setTitle("Compilador");
        this.nomNuevo=nomnovo;
        this.dirNuevo=dirnovo+nomNuevo+".jx";
        this.setTitle(this.getTitle()+" - "+dirNuevo);
        campotxt.enable(true);
        contarFilas();
    }
    
    public void habilitarCampotxt(String dirnovo){
        this.setTitle("Compilador");
        this.dirNuevo=dirnovo;
        try {
            FileInputStream fstream = new FileInputStream(dirNuevo);
            DataInputStream in = new DataInputStream(fstream);
            this.campotxt.setText("");
            while (in.available() != 0) {
                this.campotxt.setText(this.campotxt.getText() + in.readLine() + "\n");
            }
            in.close();
            this.setTitle(this.getTitle()+" - "+dirNuevo);
            campotxt.enable(true);
            contarFilas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"File input error");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contadorLinea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        campotxt = new javax.swing.JTextArea();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contadorLinea.setBackground(new java.awt.Color(204, 204, 255));
        contadorLinea.setColumns(20);
        contadorLinea.setEditable(false);
        contadorLinea.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        contadorLinea.setLineWrap(true);
        contadorLinea.setRows(5);
        jScrollPane1.setViewportView(contadorLinea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 40, 220));

        campotxt.setBackground(new java.awt.Color(255, 255, 204));
        campotxt.setColumns(20);
        campotxt.setRows(5);
        campotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campotxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campotxtKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(campotxt);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 340, 220));

        btnAbrir.setText("ABRIR");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));

        btnCompilar.setText("COMPILAR");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCompilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    if(Guardar())
            JOptionPane.showMessageDialog(this,"Archivo guardado con exito");
        else
            JOptionPane.showMessageDialog(this,"No se puede guardar el archivo");
}//GEN-LAST:event_btnGuardarActionPerformed

private void campotxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campotxtKeyReleased
    if(evt.isControlDown() || evt.getKeyCode()==10 || evt.getKeyCode()==8 || evt.getKeyCode()==127){
            contarFilas();
    }
}//GEN-LAST:event_campotxtKeyReleased

private void campotxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campotxtKeyPressed
    if(!this.getTitle().contains("*")){
            this.setTitle(this.getTitle()+"*");
    }
}//GEN-LAST:event_campotxtKeyPressed

private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
   
            Guardar();
            String[] archivoPrueba = {"test.txt"};
            AnalizadorSintactico.main(archivoPrueba);
            JOptionPane.showMessageDialog(this,"Archivo Compilado con Exito!!!");
           
}//GEN-LAST:event_btnCompilarActionPerformed

private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
    abrir();
}//GEN-LAST:event_btnAbrirActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new InterfazCompilador().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextArea campotxt;
    private javax.swing.JTextArea contadorLinea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
