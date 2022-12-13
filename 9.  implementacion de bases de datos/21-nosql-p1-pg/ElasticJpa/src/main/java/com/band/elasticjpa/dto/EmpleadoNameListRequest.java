package com.band.elasticjpa.dto;

import lombok.Data;

import java.util.List;

@Data
public class EmpleadoNameListRequest {
    List<String> nombreList;
}
