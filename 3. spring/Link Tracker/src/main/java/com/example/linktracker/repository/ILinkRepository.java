package com.example.linktracker.repository;


import com.example.linktracker.entity.Link;

public interface ILinkRepository {

    // Crear un link: Endpoint POST para crear link a partir de una URL válida y tiene que devolver
    // un JSON con el linkId para utilizar en la redirección.

    Integer createLink(Link link);



    //Redirección:  Dado un link (ej: http://localhost:8080/link/{linkId} ) tiene que realizar un redirect
    // a la URL enmascarada. Siempre y cuando el link sea válido. En el caso de que el link sea invalido
    // devolver 404(INVESTIGAR REDIRECT).

    Link getLinkById(Integer id);


    //Estadísticas por link: Endpoint GET que dado un link (ej: http://localhost:8080/metrics/{linkID} )
    // tiene que devolver la estadística de cantidad de veces que se redireccionó.



    //Invalidate link: Endpoint POST para invalidar un link (ej: http://localhost:8080/invalidate/{linkID} ).

    void invalidateLink(Integer id);

    //Al crear los links se tiene que poder agregar un password que va a ser un query param al llamar a la redirección.

    void countAccessLink(Integer id);
}
