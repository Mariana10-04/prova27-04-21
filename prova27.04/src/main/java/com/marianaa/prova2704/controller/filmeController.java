package com.marianaa.prova2704.controller;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.marianaa.prova2704.dao.FilmeDao;
import com.marianaa.prova2704.model.Filme;

public class filmeController {
    
    public Response listFilme (){
        try {
            FilmeDao filmeDAO = new FilmeDao();
            List<Filme> src = filmeDAO.listFilme();
            return Response.status((Status.OK)).entity(new Gson().toJson(src)).build();

        } catch (Exception exception) {
            return Response.status(Status.NOT_FOUND).entity(new Gson().toJson("Erro ao listar filme:"+ exception)).build();

        }

    }

    public Response addFilme (Filme filme){
        try {
            FilmeDao filmeDao = new FilmeDao();
            filmeDao.addFilme(filme);
            return Response.status(Status.CREATED).entity(new Gson().toJson("criado com sucesso")).build();

        } catch (Exception exception) {
            return Response.status(Status.BAD_REQUEST).entity(new Gson().toJson("Erro ao Cadastra:" + exception)).build();
        }
    }


}
