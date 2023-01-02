package com.example.frescos.service;

import com.example.frescos.dtos.ApplicationUserRequestDTO;
import com.example.frescos.dtos.ApplicationUserResponseDTO;
import com.example.frescos.entity.ApplicationUser;
import com.example.frescos.repository.ApplicationUserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import com.example.frescos.exception.UserNotFoundException;

import static com.example.frescos.utils.CONSTANTS.SECRET_KEY_TOKEN;


@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private ApplicationUserRepository userRepository;

    @Override
    public ApplicationUserResponseDTO login (ApplicationUserRequestDTO user ) {
        //Voy a la base de datos y reviso que el usuario y contraseña existan.
        // ToDo: se podria agregar alguna libreria para encriptar la password
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        String username = user.getUserName();
        ApplicationUser usuario = this.userRepository.findByUserNameAndPassword(username, user.getPassword())
          .orElseThrow(UserNotFoundException::new);

        List<String> roles = usuario.getRoles()
          .stream()
          .map(e -> e.getCode())
          .collect(Collectors.toList());

        String token = getJWTToken(username, roles);

        return new ApplicationUserResponseDTO(usuario.getId(), username, token);
    }

    /**
     * Genera un token para un usuario específico, válido por 10'
     *
     * @param username - user to login
     * @param roles    - collection of user's roles
     * @return String
     */
    /* lista de roles */
    /* Para los test pueden hacer que esto sea public static, no es lo mejor pero es practico */
    private String getJWTToken ( String username, List<String> roles ) {

        //ToDo: reducir el tiempo de vide del token
        LocalDateTime expired = LocalDateTime.now()
          .plusMinutes(100);
        Date expiredTime = Date.from(expired.atZone(ZoneId.systemDefault())
          .toInstant());

        String token = Jwts
          .builder()
          .setId("softtekJWT")
          .setSubject(username)
          .claim("authorities", roles)
          .setIssuedAt(new Date(System.currentTimeMillis()))
          .setExpiration(expiredTime)
          .signWith(SignatureAlgorithm.HS512, SECRET_KEY_TOKEN.getBytes())
          .compact();

        return "Bearer " + token;
    }

    /**
     * Decodifica un token para poder obtener los componentes que contiene el mismo
     *
     * @param token tokenJWT
     * @return Claims
     */
    private static Claims decodeJWT ( String token ) {
        return Jwts.parser()
          .setSigningKey(SECRET_KEY_TOKEN.getBytes())
          .parseClaimsJws(token)
          .getBody();
    }

    /**
     * Permite obtener el username según el token indicado
     *
     * @param token token JWT
     * @return String User's Email
     */
    public static String getUsername ( String token ) {
        Claims claims = decodeJWT(token);
        return claims.get("sub", String.class);
    }

}
