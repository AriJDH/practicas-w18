import clases.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

        Auto auto1 = new Auto(280.0,3.0,6.0,"AB111PQ");
        Auto auto2 = new Auto(275.0,4.5,5.0,"AC222AL");
        Auto auto3 = new Auto(290.0,4.3,5.5,"AC391NV");
        Moto moto1= new Moto(240.0,7.5,9.5,"NT111");
        Moto moto2= new Moto(245.0,7.0,9.9,"NT222");
        Moto moto3= new Moto(237.0,8.5,10.5,"NT333");
        Set<Vehiculo> vehiculos = new HashSet<>();
        vehiculos.add(auto1);
        vehiculos.add(auto2);
        vehiculos.add(auto3);
        vehiculos.add(moto1);
        vehiculos.add(moto2);
        vehiculos.add(moto3);
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorriendoMoto socorriendoMoto = new SocorriendoMoto();

        Carrera carrera = new Carrera(130.0,10000.0,"Dakar",10,vehiculos,socorristaAuto,socorriendoMoto);

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("ALTA DE AUTO");
        carrera.darDeAltaAuto(275.0,4.5,5.0,"AC222AL");
        carrera.darDeAltaAuto(275.0,4.5,5.0,"AC223AL");
        carrera.darDeAltaAuto(275.0,4.5,5.0,"AC223TT");

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("ALTA DE MOTO");
        carrera.darDeAltaMoto(180.0,7.8,10.0,"NT579");
        carrera.darDeAltaMoto(245.0,7.0,9.9,"NT222");
        carrera.darDeAltaMoto(245.0,7.0,9.9,"NT22002");

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("SOCORRER AUTO");
        carrera.socorrerAuto("AB111PQ");
        carrera.socorrerAuto("AB1111PQ");
        System.out.println("SOCORRER MOTO");
        carrera.socorrerMoto("NT111");
        carrera.socorrerMoto("NT1111");

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("ELIMINAR VEHICULO");
        carrera.eliminarAuto(275.0,4.5,5.0,"AC222AL");
        carrera.eliminarAuto(275.0,4.5,5.0,"AC000AL");

        carrera.eliminarAuto("AC222AL");
        carrera.eliminarAuto("AC391NV");
        System.out.println("--------------------------------------------------------------------------------");
        carrera.eliminarMoto("NT579");
        carrera.eliminarMoto("NT");
        carrera.eliminarMoto(150.0,15.0,9.0,"AD999");
        carrera.eliminarMoto(237.0,8.5,10.5,"NT333");
        System.out.println("--------------------------------------------------------------------------------");

        carrera.determinarGanador();

    }
}