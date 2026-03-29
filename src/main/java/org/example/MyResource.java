package org.example;

import Gramatica.GeneradorSql;

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
        return generadorSql.generarCodigo(gramatica);
    }
}
