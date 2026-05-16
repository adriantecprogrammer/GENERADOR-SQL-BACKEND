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
    public gramaticaParser parser;
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
            parser = new gramaticaParser(tokens);
            parser.inicio();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.setOut(originalOut);
        }

        return baos.toString(StandardCharsets.UTF_8);
    }

    public String generarCodigoJSON(String codigo) {
        generarCodigo(codigo);

        if (parser == null || parser.nombreBD == null || parser.nombreBD.isEmpty()) {
            return "{\"error\":\"No se pudo procesar la gramática correctamente\"}";
        }

        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"database\":").append(jsonStr(parser.nombreBD)).append(",");
        json.append("\"sqlCreateDatabase\":").append(jsonStr("CREATE DATABASE " + parser.nombreBD)).append(",");
        json.append("\"sqlUseDatabase\":").append(jsonStr("USE DATABASE " + parser.nombreBD)).append(",");
        json.append("\"tablas\":[");

        for (int i = 0; i < parser.tablas.size(); i++) {
            if (i > 0) json.append(",");
            Tabla t = parser.tablas.get(i);
            json.append("{");
            json.append("\"nombre\":").append(jsonStr(t.nombre)).append(",");
            json.append("\"sql\":").append(jsonStr(parser.sqlTablas.get(i))).append(",");
            json.append("\"atributos\":[");
            for (int j = 0; j < t.atributos.size(); j++) {
                if (j > 0) json.append(",");
                Atributo a = t.atributos.get(j);
                json.append("{");
                json.append("\"nombre\":").append(jsonStr(a.nombreAtributo)).append(",");
                json.append("\"tipo\":").append(jsonStr(mapTipoSQL(a.tipoAtributo))).append(",");
                json.append("\"tipoOriginal\":").append(jsonStr(a.tipoAtributo));
                json.append("}");
            }
            json.append("]}");
        }

        json.append("]}");
        return json.toString();
    }

    private String mapTipoSQL(String tipoOriginal) {
        if (tipoOriginal == null) return "";
        switch (tipoOriginal) {
            case "texto": return "VARCHAR(300)";
            case "número": return "INTEGER";
            case "fecha": return "DATE";
            case "FK (llave foranea)": return "INTEGER";
            default: return tipoOriginal;
        }
    }

    private String jsonStr(String s) {
        if (s == null) return "\"\"";
        return "\"" + s
            .replace("\\", "\\\\")
            .replace("\"", "\\\"")
            .replace("\n", "\\n")
            .replace("\r", "\\r")
            .replace("\t", "\\t")
            + "\"";
    }

}
