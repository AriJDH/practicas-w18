package com.example.numerosromanos.model;

public abstract class ConversorDecimalARomano {

    private static EquivalenciaDecimalRomano[] equivalencias = new EquivalenciaDecimalRomano[]{
            new EquivalenciaDecimalRomano(1000, "M"),
            new EquivalenciaDecimalRomano(900, "CM"),
            new EquivalenciaDecimalRomano(500, "D"),
            new EquivalenciaDecimalRomano(400, "CD"),
            new EquivalenciaDecimalRomano(100, "C"),
            new EquivalenciaDecimalRomano(90, "XC"),
            new EquivalenciaDecimalRomano(50, "L"),
            new EquivalenciaDecimalRomano(40, "XL"),
            new EquivalenciaDecimalRomano(10, "X"),
            new EquivalenciaDecimalRomano(9, "IX"),
            new EquivalenciaDecimalRomano(5, "V"),
            new EquivalenciaDecimalRomano(4, "IV"),
            new EquivalenciaDecimalRomano(1, "I")
    };

    public static String convertirDecimalARomano(int numDecimal){
        String resultado = "";
        int resto = numDecimal;
        int indice = 0;

        while(resto >0 && resto <= 3999 && indice < equivalencias.length ){
            while(resto >= equivalencias[indice].getDecimal()){
                resto -= equivalencias[indice].getDecimal();
                resultado += equivalencias[indice].getRomano();
            }
            indice++;
        }
        return resultado.equals("")? "El número a convertir debe estar entre 1 a 3999" : resultado;
    }
}
