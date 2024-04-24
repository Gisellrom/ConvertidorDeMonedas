package com.aluracursos.desafio.conversion;

import com.aluracursos.desafio.api.ConsultaAPI;
import com.google.gson.JsonObject;

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
        JsonObject valorJson = json.convierteMoneda(baseCode);

        JsonObject conversionRates = valorJson.getAsJsonObject("conversion_rates");
        double conversionRate = conversionRates.get(changeCode).getAsDouble();
        return amount * conversionRate;
    }

}//fin de Conversion
