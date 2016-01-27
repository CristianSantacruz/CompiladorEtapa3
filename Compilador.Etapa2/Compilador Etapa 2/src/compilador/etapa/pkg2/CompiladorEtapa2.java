package compilador.etapa.pkg2;

import java.io.File;

/**
 *
 * @author Cristian
 */
public class CompiladorEtapa2 {

    public static void main(String[] args) {
        String path = "C:/Users/Cristian/Desktop/Compilador.Etapa2/Compilador Etapa 2/src/compilador/etapa/pkg2/Lexico.flex";
	generarLexico(path);
    }
    
    public static void generarLexico(String path) {
		File archivo = new File(path);
                jflex.Main.generate(archivo);
	}
}
