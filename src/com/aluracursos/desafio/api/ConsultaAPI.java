package com.aluracursos.desafio.api;

import com.aluracursos.desafio.conversion.Moneda;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public Moneda convierteMoneda(int monedaPK) {
        String APIKey = "afab9c212ae0791260492268";
        String direccion = "https://v6.exchangerate-api.com/v6/"+APIKey+"/latest/" + monedaPK;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();


        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("No encontré la moneda");
        }

        //Ir a File > Proyect Structure > Modules > Dependeces > + .jar
        //return new Gson.fromJson(response.body(), Moneda.class);
        return new Gson().fromJson(response.body(), Moneda.class);
    }//fin del metodo buscaPelicula
}
