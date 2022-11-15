package meli.bootcamp.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkDto {
    private Integer id;
    private String link;
    private String password;
    private Integer countRedirect;

    public void sumarContador()
    {
        countRedirect++;
    }
}
