package com.example.romano.service;

import org.springframework.stereotype.Service;

@Service
public class NumeroService {

    String numeroRomano="";
    public String numeroARomano(int numeroDecimal){

        int dec=0, uni=0, cen=0, mil=0;
        uni=numeroDecimal % 10;
        mil=(numeroDecimal-uni)/1000;
        cen=(numeroDecimal-uni-(mil*1000))/100;
        dec=(numeroDecimal-uni-(mil*1000)-(cen*100))/10;
        unidades(uni);
        decenas(dec);
        centenas(cen);
        unidadDeMilla(mil);
        return numeroRomano;

    }
    private void unidades(int unidad){
        String unidadesRomanos[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        numeroRomano=unidadesRomanos[unidad];
    }
    private void decenas(int unidad){
        String decenasRomanos[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        numeroRomano=decenasRomanos[unidad]+numeroRomano;
    }
    private void centenas(int unidad){
        String centenasRomanos[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        numeroRomano=centenasRomanos[unidad]+numeroRomano;
    }
    private void unidadDeMilla(int unidad){
        String umRomanos[]={"","M","MM","MMM","","","","","",""};
        numeroRomano=umRomanos[unidad]+numeroRomano;
    }
}
