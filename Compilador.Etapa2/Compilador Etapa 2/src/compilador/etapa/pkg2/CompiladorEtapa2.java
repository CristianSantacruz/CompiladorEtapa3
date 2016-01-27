package compilador.etapa.pkg2;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Cristian
 */
public class CompiladorEtapa2 {

    public static void main(String[] args) throws IOException {
        String path = "C:/Users/Cristian/Desktop/Compilador.Etapa2/Compilador Etapa 2/src/compilador/etapa/pkg2/Lexico.flex";
	generarLexico(path);
        
        VerTokens tokens = new VerTokens();
        tokens.probarLexer();       
        tokens.guardar();
        tokens.setVisible(true);
    }
    
    public static void generarLexico(String path) {
		File archivo = new File(path);
                jflex.Main.generate(archivo);
	}
}
