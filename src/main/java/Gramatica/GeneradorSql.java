package Gramatica;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import Gramatica.gramaticaLexer;
import Gramatica.gramaticaParser;



public class GeneradorSql {
    public GeneradorSql(){};

    public String generarCodigo(String codigo) {

        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos, true, StandardCharsets.UTF_8));

        try {
            ByteArrayInputStream str = new ByteArrayInputStream(codigo.getBytes(StandardCharsets.UTF_8));
            ANTLRInputStream input = new ANTLRInputStream(str);
            gramaticaLexer lexer = new gramaticaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            gramaticaParser parser = new gramaticaParser(tokens);
            parser.inicio();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.setOut(originalOut);
        }

        return baos.toString(StandardCharsets.UTF_8);
    }

}
