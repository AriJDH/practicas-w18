package meli.bootcamp.joyerialasperlas.dto.req;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JewelryDtoReq {
    @JsonAlias("nombre")
    private String name;
    private String material;
    @JsonAlias("peso")
    private Double weight;
    @JsonAlias("particularidad")
    private String notes;
    @JsonAlias("posee_piedra")
    private Boolean hasRocks;
    @JsonAlias("ventaONo")
    private Boolean onSale;
}
