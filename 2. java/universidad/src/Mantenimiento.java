public class Mantenimiento implements MiembroPersonal{
    @Override
    public void getTareas() {
        System.out.println("Mis tareas como personal de mantenimientos son:" +
                " mantener la limpieza, reparaciones en general e instalar dispositivos");
    }
}
