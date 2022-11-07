SaveTheRopa S.A es una empresa que desea implementar un sistema informático de guardarropas a nivel mundial. El 
sistema permite a una persona guardar sus pertenencias en el guardarropas y luego retirarlas de manera sencilla con solo presentar el número identificador que recibe al guardarlas.

Las pertenencias se representan en el sistema mediante algo abstracto llamado prenda, que tiene marca y modelo, de modo que si la persona pierde el número también podría en algún momento poder llegar a reclamarlo con dicha información. Sin embargo, el reclamo será modelado en otro momento. Para la primera implementación del guardarropas necesitamos realizar lo siguiente:

1. Crear la clase Prenda que contenga los atributos marca y modelo.

2. Crear la clase GuardaRopa que contenga como atributos un diccionario (o MAP) y un contador que se utilizará como 
identificador. Las claves del diccionario serán de tipo entero y como valor una lista de prendas.

3. Crear el método public Integer guardarPrendas(List<Prenda> listaDePrenda), en la Clase GuardaRopa, que recibe una 
lista de prendas y devuelve el número identificador en donde quedaron asignadas las prendas, es decir la clave del diccionario en donde guardamos las mismas.

4. Crear el método public void mostrarPrendas() en la Clase GuardaRopa que imprime por pantalla todas las prendas que 
quedan en el guardarropas junto con el número que les corresponde.

5. Crear el método public List<Prenda> devolverPrendas(Integer numero), en la Clase GuardaRopa que devuelve la lista 
de prendas que están guardadas bajo ese número.

6. Crear en la clase Main un escenario en el cual alguien guarde dos prendas, reciba el código y luego consulta por 
sus prendas guardadas.
