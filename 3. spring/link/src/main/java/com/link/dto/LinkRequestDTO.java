package com.link.dto;
import com.link.entity.Link;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkRequestDTO {
    private Long id;

    private String url;

    private String password;

}
