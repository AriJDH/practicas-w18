package meli.bootcamp.crudclaseenvivo.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class CartDto {
    private Long id;
    private Set<ItemDto> items;
}
