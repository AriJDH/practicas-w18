<h1>Programación Java</h1>

<h2>Bootcamp Backend Java  - Sprint Nº 2 - Testing</h2>

<h3>Objetivo</h3>
El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requerimientos y documentación técnica.

<h3>Pautas para la actividad<h3>
El desafío que se propone a continuación consta de 2 partes:
Implementar validaciones y diferentes tests a un escenario determinado (grupal): A partir de un primer incremento de un escenario conocido (Sprint Nº 1), se deberán establecer distintos procesos de validación de datos y de test unitarios necesarios.


Apartado Individual: Luego de lograr implementar tests unitarios con todos los miembros del equipo, deberás implementar al menos un test de integración de manera individual.


Bonus: En caso de que hayas logrado resolver tanto el apartado A de manera grupal como todo el apartado B de forma individual y aún cuentes con tiempo, te invitamos a que propongas otros tests de integración (diferentes al que hayas implementado en el punto B).  No te olvides que este apartado es 100% OPCIONAL y NO OBLIGATORIO.


<h3>Dinámica de trabajo</h3>
Como se mencionó anteriormente, la actividad estará dividida en dos partes, una grupal y otra individual. La primera parte de la actividad será la conformación de equipos; los mismos serán aquellos que se hayan formado en el Sprint Nº 1, con la finalidad de seguir compartiendo y desarrollando con los mismos compañeros de team. 
Dado que se utilizará la metodología ágil de Scrum, cada facilitador será el “Scrum Master” de cada grupo con la finalidad de ayudarlos a dividir las correspondientes tareas y administrar los tiempos.
Luego de reencontrarte y organizarte con tus compañeros de equipo, les pedimos que respondan (de manera individual) el siguiente Quiz Inicial. La idea del mismo es que cada integrante del grupo pueda dar sus estimaciones aproximadas de tiempo para cada uno de los requerimientos, entre otros detalles, por lo que es importante que antes de realizarlo, se hayan leído en detalle cada una de las User Stories (US).
Con la finalidad de evaluar el trabajo de otros compañeros y aprender la práctica de “feedback de a pares”, a partir del día 2 del sprint se te va a asignar un compañero para que puedan hacer intercambio de código y evaluarse mutuamente. Para ello, los facilitadores les indicarán el momento a cada uno y a su vez, contarán con un formulario, para consignar el feedback.
Durante el desafío los facilitadores estarán presentes a través de Meet o Slack para cualquier consulta.  Recordá indicar en la planilla en qué situación te encontrás con tu grupo o si necesitan ayuda. No te olvides de completar el status de finalización al final de cada día.
Tené en cuenta que:
La fecha de entrega y cierre es: 30/11/2022 hasta las 18:00 hs (Arg-Uy)/ 17:00 hs (Chi) / 16:00 hs (Mex-Col). La entrega debe realizarse mediante GitHUB.
Todo el desafío debe ser desarrollado en un solo proyecto con el nombre “SocialMeli2” (tomando como base la resolución GRUPAL lograda en el Sprint Nº 1). 
La entrega de la actividad consta de dos partes: El proyecto grupal: Deberá ser subido al repositorio en la carpeta “Sprint II” dentro del Repositorio de la Wave. Cada grupo designará a un miembro para trabajar en su rama, el proyecto deberá tener el siguiente nombre : be_java_hisp_w17_gXX donde XX es el nº de grupo. Al finalizar el Sprint, todos los integrantes deben tener su carpeta de Proyecto grupal en su carpeta de Sprint II.
El proyecto individual deberá ser subido al repositorio en la carpeta “Sprint II” dentro del branch personal de cada integrante identificado con el nombre be_java_hisp_w17_gXX_apellido, donde XX es el número de grupo. Acá cada miembro deberá ingresar su versión completa del proyecto incluyendo la parte que fue desarrollada de manera grupal (Punto A) y la parte individual (punto B y opcional C).

Es fundamental que el proyecto sea subido COMPLETO en ambos casos, es decir, con todos los archivos necesarios para poder ejecutarlo (de forma tal que los facilitadores puedan levantarlo en su IDE).

También, se solicita entregar la colección de Postman que se usó para las pruebas, con la finalidad de que los facilitadores puedan contar con las mismas para replicar pruebas.


<h3>Escenario (Desarrollo GRUPAL)</h3>
SocialMeli, la nueva implementación de MercadoLibre que fue realizada por el equipo de desarrollo “Bootcamp” se ha convertido en ¡Todo un éxito!. Dado esto y a que MeLi tiene unos estándares de calidad muy altos con respecto a los productos de software que utiliza, estableció una serie de validaciones que considera que sean necesarias tener en cuenta a la hora de incorporar datos como así también diferentes test unitarios que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.
Para llevar a cabo estas implementaciones, se deberá tomar como base el proyecto desarrollado de forma grupal en el Sprint Nº 1. A partir de él, se llevarán a cabo cada una de las validaciones y tests unitarios correspondientes.
Como documentación de respaldo, un analista funcional adjunta el siguiente documento de requerimientos técnicos y funcionales: Documentación

<h3>Requerimientos incrementales (Desarrollo INDIVIDUAL)</h3>
Siguiendo con el principio de que MeLi posee unos estándares de calidad muy altos, un especialista sugirió la posibilidad de contar con la implementación de al menos un test de integración para lograr una cobertura de código mayor que la lograda con los tests unitarios.

Tener en cuenta que, se debe respetar el desarrollo base logrado en equipo para poder realizar este nuevo incremento de manera individual.

<h3>Bonus  (Desarrollo Individual EXTRA)</h3>
El mismo especialista en calidad que sugirió implementar al menos un test de integración anteriormente, sugiere que sería ideal lograr contar con la implementación de otros tests de integración extra para intentar lograr un coverage mayor o igual al 75%.
El especialista conoce que los tiempos de desarrollo en bootcamp son acotados, por lo que sugiere llevar a cabo esta implementación solo en caso de que alcancen los tiempos y se pueda cumplir con la fecha de entrega estimada.



***************
<h2>Programación Java - Sprint Nº 2 - Testing</h2>

<h3>Requerimientos técnicos funcionales (Punto A)</h3>
User Stories
SocialMeli contaba anteriormente con las siguientes User Stories y requerimientos técnicos:
US-0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
US-0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
US-0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
US-0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
US-0005: Dar de alta una nueva publicación.
US-0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
US-0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
US-0008: Ordenamiento alfabético ascendente y descendente.
US-0009: Ordenamiento por fecha ascendente y descendente.

<h3>Especificaciones técnicas de Desafío Anterior: Esp. de Req. técnicos funcionales - Sprint Nº 1 - Spring</h3>
https://docs.google.com/document/d/1187Qpl9lfHk-pckNTWJgQwr8fq6lTJWt/edit?usp=sharing&ouid=109885099434747742763&rtpof=true&sd=true

<h3>Especificaciones técnicas de Desafío SPRINT II</h3>
https://docs.google.com/document/d/1LNrf6vXUSteJSNlSWjTtrS66CnLAaVvc/preview?rtpof=true
