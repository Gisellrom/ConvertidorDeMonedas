package com.aluracursos.desafio.api;

import com.aluracursos.desafio.conversion.Moneda;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public JsonObject convierteMoneda(String base) throws IOException{
        String APIKey = "afab9c212ae0791260492268";
        String direccion = "https://v6.exchangerate-api.com/v6/"+APIKey+"/latest/" + base;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200){
                //regresamos un JSON con la información de la solicitud

                //JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);

                //Ir a File > Proyect Structure > Modules > Dependeces > + .jar
                return new Gson().fromJson(response.body(), JsonObject.class);

            }else{
                throw new IOException("Error al realizar la solicitud del Servidor: " + response.statusCode());
            }

        } catch (Exception e) {
            throw new RuntimeException("No se encontró la moneda");
        }
    }//fin del metodo buscaPelicula
}//fin de consultaAPI
