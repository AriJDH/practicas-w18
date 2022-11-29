package com.meli.be_java_hisp_w18_g01.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowedInfoDTO {
    @NotNull(message = "El id del usuario no puede ser nulo.")
    @Min(value=1, message = "El id del usuario debe ser mayor a 0.")
    private Long user_id;
    private String user_name;
    private List<@Valid UserDTO> followed;
}
