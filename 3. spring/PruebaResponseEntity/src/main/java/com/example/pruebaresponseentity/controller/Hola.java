package com.example.pruebaresponseentity.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class Hola {

    // Response Entity maneja toda respuesta HTTP incluyendo el cuerpo, cabeceras y codigos de estado
    // normalmente usado en servicios REST dentro de los metodos de los controladores

    // gracias a que el tipo de parametro es generico, se puede realizar lo siguiente:
    @GetMapping("/hola")
    ResponseEntity<String> holaMundo(){
        return new ResponseEntity<>("Hola desde una respuesta HTTP", HttpStatus.OK);
        // se retorna en el cuerpo un string junto con un codigo 200 OK
    }


    // ahora se puede programar nuestro endpoint para q retorne un codigo 400 de peticion mala en caso de ingresar un
    // correo no valido

    @GetMapping("/verificar/{correo}")
    ResponseEntity<String> verificarCorreo(@PathVariable String correo){

        if (!EmailValidator.getInstance().isValid(correo)){
            return new ResponseEntity<>("Frormato debeb ser ejemplo@correo.cominio", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("su correo es: "+correo, HttpStatus.OK);
    }

    //podemos establecer la cabecera de lal sig manera:

    @GetMapping("cabecera/{cliente}")
    ResponseEntity<String> cabeceraPersonalizada(@PathVariable String cliente){

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add("Estado Cliente", "Cliente " + cliente + " Habilitado");

        return new ResponseEntity<>("Bienvenido " + cliente, cabecera, HttpStatus.OK);
    }

    //Response Entity provee 2 clases anidades de tipo intereface:
    // - BodyBuilder
    // - HeadersBuilder
    // ResponseEntity provee un metodo estatico para cada una de ellas

    // para el ej de hola mundo:

    @GetMapping("/holaMundo")
    ResponseEntity<String> holaMundo2(){
        return ResponseEntity.ok("Hola mundo!");
    }

    // ej para la verificacion de correo:
    @GetMapping("/verificarCorreo/{correo}")
    ResponseEntity<String> verificarCorreo2(@PathVariable String correo){

        if (!EmailValidator.getInstance().isValid(correo)){
            return ResponseEntity.badRequest().body("Formato debeb ser ejemplo@correo.cominio");
        }
        return  ResponseEntity.status(200).body("su correo es: "+ correo);
    }

    // por ultimo, realizar una cabecera personalizada:

    @GetMapping("cabeceraCustomizada/{cliente}")
    ResponseEntity<String> cabeceraPersonalizada2(@PathVariable String cliente){

        cabecera.add("Estado Cliente", "Cliente " + cliente + " Habilitado");

        return  ResponseEntity.ok()
                              .header("Estado Cliente", "Cliente " + cliente + " Habilitado")
                              .body("Bienvenido " + cliente);
    }
}
