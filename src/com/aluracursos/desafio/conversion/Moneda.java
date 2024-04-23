package com.aluracursos.desafio.conversion;

public record Moneda(
        String monedaPK,
        double monedaValorPK,
        String cambioMoneda,
        double cambioValor) {
}
