package Paquete;

public class Main {
    String ciudades[] = {"Londres", "Madrid", "Nueva york", "Buenos Aires", "Asuncion","Sao Paulo", "Lima", "Santiago de chile", "Lisboa", "Tokio"};
    int temperaturas[][]= {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
    int mayorTodos;
    int menorTodos;
    String ciudadMayor;
    String ciudadMenor;

    public void determinarExtremos(){
        /*Recorrer las temperaturas y ver cual es la menor/mayor, diciendo que la primera es la menor/mayor y comparando todas con esa*/
        menorTodos=temperaturas[0][0];
        mayorTodos=temperaturas[0][1];

        for(int i=0; i<10;i++){
            for (int j=0; j<1; j++){
                if (temperaturas[i][j]< menorTodos){
                    menorTodos=temperaturas[i][j];
                    ciudadMenor=ciudades[i];
                }
                if (temperaturas[i][j+1]> mayorTodos){
                    mayorTodos=temperaturas[i][j+1];
                    ciudadMayor=ciudades[i];
                }
            }
        }

        System.out.println("La menor temperatura la tuvo "+ ciudadMenor +", con "+ menorTodos+ "° C.");
        System.out.println("La mayor temperatura la tuvo "+ ciudadMayor +", con "+ mayorTodos+ "° C.");

    }

    public static void main(String[] args) {
        new Main().determinarExtremos();
    }
}
