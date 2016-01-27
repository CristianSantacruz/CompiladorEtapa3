package compilador.etapa.pkg2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristian
 */
public class VerTokens extends javax.swing.JFrame {

    public VerTokens() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("TABLA DE TOKENS");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TOKENS", "LEXEMAS"
            }
        ));
        jScrollPane1.setViewportView(tabla1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VerTokens().setVisible(true);
            }
        });
    }
    
    public void probarLexer() throws IOException {
        DefaultTableModel modelo = (DefaultTableModel) tabla1.getModel();
	BufferedReader leer = new BufferedReader(new FileReader("C:/Users/Cristian/Desktop/Compiladores y Lenguajes/archivo.txt"));
	Lexer lexer = new Lexer (leer);
        String resultado = "";
            while(true) {
                Token token = lexer.yylex();
                    if(token == null) {
                        resultado = resultado + "EOF";
                        System.out.println(resultado);
                        return;
                    }
                    switch(token) {
                        
                        case SUMA: case RESTA: case MULTIPLICACION: case DIVISION: case AUMENTAR: case DISMINUIR:
                        case ASIGNADOR: case MAYOR: case MENOR: case IGUAL: case MAYORIGUAL: case MENORIGUAL:
                        case SI: case SINO: case NO: case PARA: case MIENTRAS: case VOID: case MAIN:
                        case T_ENTERO: case T_DECIMAL: case T_BOLEANO:
                        case IDENTIFICADOR: case KEYWORD: case CARACTER: case ENTERO: case FLOTANTE: case BOOL: case CHAR:
                        case ALLAVE: case CLLAVE: case PYCOMA: case COMA: case CPAREN: case APAREN: case ACORCH: case CCORCH:
                            modelo.addRow(new Object[]{token, lexer.lexeme});
                            break;
                        default:
                            modelo.addRow(new Object[]{token, lexer.lexeme});
                    }
                }
	}

    public void guardar() {
        DefaultTableModel modelo = (DefaultTableModel) tabla1.getModel();
        BufferedWriter salida = null;
        File fichero = new File("C:/Users/Cristian/Desktop/Compiladores y Lenguajes/archivo2.csv");
        try {
            FileWriter archivoOut = new FileWriter(fichero);
            for(int i = 0; i < modelo.getColumnCount(); i++) {
                archivoOut.write(modelo.getColumnName(i) + ";");
            }
            
            archivoOut.write("\r\n");
            for(int i = 0; i < modelo.getRowCount(); i++) {
                for(int j = 0; j < modelo.getColumnCount(); j++) {
                    archivoOut.write(modelo.getValueAt(i, j).toString()+";");
                }
                archivoOut.write("\r\n");
            }
            archivoOut.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
