package Class;

import Abstract.Persona;

public class Personal extends Persona {

    public Personal(String nombreApellido, String areaTrabajo, String cargo) {
        super(nombreApellido, areaTrabajo, cargo);
    }

    public String ejercerCargo(){
        return super.getCargo();

    }
}
