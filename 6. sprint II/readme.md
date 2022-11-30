<h1>Programación Java</h1>

<h2>Bootcamp Backend Java  - Sprint Nº 2 - Testing</h2>

<h3>Objetivo</h3>
El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requerimientos y documentación técnica.


*********************************************************************************************************

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


*********************************************************************************************************

<h2> INDIVIDUAL </h2>

- Refactor en la clase ExceptionValidResponseDTO > Se agrega @JsonFormat(pattern = "dd-MM-yyyy") para el atributo timeStamp;



<h3>Controller: UserController</h3>

<h4>SUT: @PostMapping("/{userId}/follow/{userIdToFollow}") > followUser</h4>

- Test integración "Verify status 204 - Follow an user OK": 
Se realiza una corrección en el status devuelto, se cambia status 200 por 204. 

- Test integración "Verify status 400 -> Message: 'You can't follow yourself'"
No requiere modificación de código fuente. 

- Test integración "Verify status 400 -> Message: 'This user doesn't exists'"
Requiere modificación del código fuente. Sin modificar el código se obtiene la excepción NoSuchElementException debido a que la inicialización de objetos User se encuentra antes de la validación correspondiente en el método del servicio followUser(int, int).


Código original de validación
        //busca en el repo si están presentes los usuarios
        if (!userIsPresent(usFollowed.get().getUser_id())) {
            throw new BadRequestException("This user doesn't exit");
        }

Código refactorizado
Aunque se supone que el usuario con userId está presente ya que de otra manera no podría seguir a otro, se agrega la validación correspondiente para que el caso quede contemplado. 
        //busca en el repo si están presentes los usuarios
        if ( !userIsPresent(userId) || !userIsPresent(userIdToFollow)) {
            throw new BadRequestException("This user doesn't exist");
        }

Corrección de tipeo en el mensaje
{"message":"This user doesn't exit"} -> {"message":"This user doesn't exist"}

- Test integración "Verify status 400 - Message: 'Can't follow this user because he doesn't have any post'"
No requiere modificación de código fuente. 


<h4>SUT: @PostMapping("/{userId}/unfollow/{userIdToUnfollow}") > unfollowUser</h4>
- Test integración "Verify status 204 - Unfollow user OK": 
Se realiza una corrección en el status devuelto, se cambia status 200 por 204. 

- Test integración "Verify status 400 -> Message: 'This user doesn't exists'"
Requiere modificación del código fuente. Sin modificar el código se obtiene la excepción NoSuchElementException 
[ No logré corregirlo a tiempo ]

Código original 

        Optional<User> usFollower = userRepository.findUserById(userId);
        Optional<User> usUnfollowed = userRepository.findUserById(userIdToUnfollow);
        boolean isInListToUnfollowed = userRepository.findUserInList(usFollower.get().getFollowed(), userIdToUnfollow).isPresent();
        boolean userIdIsInListToFollowers = userRepository.findUserInList(usUnfollowed.get().getFollowers(), userId).isPresent();

        List<User> listFollowed = usFollower.get().getFollowed();
        List<User> listFollowers = usUnfollowed.get().getFollowers();

        if (!userIsPresent(userIdToUnfollow) || !userIsPresent(userId)) {
            throw new BadRequestException("User doesn't exist");
        }


Código propuestao para refactorizar -> No funcionó porque rompía el test unitario T0002
        User usFollower = userRepository.findUserById(userId)
                .orElseThrow(()-> new BadRequestException("User doesn't exist"));
        User usUnfollowed = userRepository.findUserById(userIdToUnfollow)
                .orElseThrow(() -> new BadRequestException("User doesn't exist"));

        boolean isInListToUnfollowed = userRepository.findUserInList(usFollower.getFollowed(), userIdToUnfollow).isPresent();
        boolean userIdIsInListToFollowers = userRepository.findUserInList(usUnfollowed.getFollowers(), userId).isPresent();

        List<User> listFollowed = usFollower.getFollowed();
        List<User> listFollowers = usUnfollowed.getFollowers();

Se comentaba la validación con if, ya que se contemplaba en la búsqueda de los usuarios con el código refactorizado: 
        if (!userIsPresent(userIdToUnfollow) || !userIsPresent(userId)) {
            throw new BadRequestException("User doesn't exist");
        }


Finalmente la refactorización consiste en realizar las validaciones de usuarios inmediatamente después de la firma del método y posteriormente realizar las búsquedas

En algunas ocasiones realizando un clean a través de maven, pasaban todos los test menos, el de integración : Verify status 400 -> Message: 'This user doesn't exists o el unitario T0002: verifyUserToUnfollowExistsOkTest

