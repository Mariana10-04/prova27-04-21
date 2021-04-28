package com.marianaa.prova2704;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.marianaa.prova2704.controller.categoriaController;
import com.marianaa.prova2704.controller.filmeController;
import com.marianaa.prova2704.model.Categoria;

@Path("/")
public class Resources {

    filmeController filmeController = new filmeController();
    categoriaController categoriaController = new categoriaController();

    @GET
    @Path("/filmes")
    @Produces("application/json")
    public Response listFilmes(){
        return filmeController.listFilme();
    }

    @GET
    @Path("/filmes")
    @Produces("application/json")
    @Consumes("application/json")
    public Response listCategoria(){
        return categoriaController.listCategoria();
    }
    
    @GET
    @Path("/filmes")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addCategoria (Categoria categoria){
        return categoriaController.addCategoria(categoria);
    }
}
