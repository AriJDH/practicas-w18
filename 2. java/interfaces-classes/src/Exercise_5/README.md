## Ejercicio 5
Un juego llamado Asteroid, consiste en acumular puntos cuando destruye un asteroide.

Los participantes pueden poseer una nave simple o una flota de naves simples.

Las naves poseen un nombre, una ubicación en coordenadas (x, y) y una puntuación inicial de cero. 

Las flota de naves simples solo poseen una lista de naves simples.

Cuando se indica unas coordenadas, la nave que gana el punto será aquella que esté más cerca, donde la distancia será la(x1-x2)2+(y1-y2)2 , pero en el caso de una flota de naves, la distancia será el promedio de distancias de las naves de la flota. 

Para poder iniciar el juego, se deben inscribir los participantes en una lista y se inicia el juego cuando se pasa en forma de arreglo las coordenadas donde los blancos aparecerán. 

Al finalizar se mostrará la nave o flota de naves ganadora que acumuló más puntos, también se deberá mostrar los resultados obtenidos para cada coordenada ingresada.

Para desarrollar este ejercicio, se recomienda el uso de interfaces, con el uso del patrón de diseño Composite.

