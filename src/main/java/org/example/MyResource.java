package org.example;

import Gramatica.GeneradorSql;
import CrearBD.CrearBD;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
    public GeneradorSql generadorSql = new GeneradorSql();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Ya funciona";
    }
    @POST
    @Path("parser")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String parser(String gramatica){
        String salida="";
        try {
             salida = generadorSql.generarCodigo(gramatica);
        }catch (Exception e){
            throw e;
        }
        return  salida;
    }
    @POST
    @Path("createBD")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String createBD(String gramatica){
        try {
            generadorSql.generarCodigo(gramatica);
            if (generadorSql.parser == null) {
                return "❌ Error: No se pudo inicializar el parser.";
            }
            String nombreBD = generadorSql.parser.nombreBD;
            java.util.List<String> sqlTablas = generadorSql.parser.sqlTablas;

            if (nombreBD == null || nombreBD.isEmpty()) {
                return "Error: No se encontró el nombre de la base de datos en la gramática.";
            }

            CrearBD creadorBD = new CrearBD();
            // 1. Crear la base de datos
            creadorBD.createBD(nombreBD);

            // 2. Crear las tablas
            creadorBD.createTables(nombreBD, sqlTablas);

            return "✅ Base de datos '" + nombreBD + "' y sus " + sqlTablas.size() + " tablas han sido creadas exitosamente.";
        } catch (Exception e) {
            return "❌ Error al procesar la solicitud: " + e.getMessage();
        }
    }
}
