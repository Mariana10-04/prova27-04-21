package com.marianaa.prova2704.controller;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.marianaa.prova2704.dao.CategoriaDAO;
import com.marianaa.prova2704.model.Categoria;

public class categoriaController {
    
    public Response listCategoria (){
        try {
            CategoriaDAO CategoriaDAO = new CategoriaDAO();
            List<Categoria> src = CategoriaDAO.listCategoria();
            return Response.status((Status.OK)).entity(new Gson().toJson(src)).build();

        } catch (Exception exception) {
            return Response.status(Status.NOT_FOUND).entity(new Gson().toJson("Erro ao listar Categoria:"+ exception)).build();

        }

    }

    public Response addCategoria (Categoria categoria){
        try {
            CategoriaDAO categoriaDao = new CategoriaDAO();
            categoriaDao.addCategoria(categoria);
            return Response.status(Status.CREATED).entity(new Gson().toJson("criado com sucesso")).build();

        } catch (Exception exception) {
            return Response.status(Status.BAD_REQUEST).entity(new Gson().toJson("Erro ao Cadastra:" + exception)).build();
        }
    }


}
