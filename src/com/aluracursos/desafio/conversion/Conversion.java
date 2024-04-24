package com.aluracursos.desafio.conversion;

import com.aluracursos.desafio.api.ConsultaAPI;
import com.google.gson.JsonObject;

import java.io.IOException;

public class Conversion {
    private String baseCode;
    private String changeCode;
    private double amount;

    public Conversion(String baseCode, String changeCode, double amount) {
        this.baseCode = baseCode;
        this.changeCode = changeCode;
        this.amount = amount;
    }

    public double convertidorDeMonedas(){
        ConsultaAPI json = new ConsultaAPI();
        JsonObject valorJson = null;
        try {
            valorJson = json.convierteMoneda(baseCode);
        } catch (IOException e) {
            throw new RuntimeException("Hubo un error al recuperar el JSON "+e.getMessage());
        }

        JsonObject conversionRates = valorJson.getAsJsonObject("conversion_rates");
        double conversionRate = conversionRates.get(changeCode).getAsDouble();
        return amount * conversionRate;
    }

}//fin de Conversion
