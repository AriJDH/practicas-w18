package meli.bootcamp.crudclaseenvivo.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import meli.bootcamp.crudclaseenvivo.dto.req.CartDto;

@AllArgsConstructor
@Setter
@Getter
public class ResponseCartDto {
    private CartDto cartDto;
    private String message;
}
