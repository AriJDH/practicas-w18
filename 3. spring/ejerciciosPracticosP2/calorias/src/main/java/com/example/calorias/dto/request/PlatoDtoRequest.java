package com.example.calorias.dto.request;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlatoDtoRequest {

    private List<StructPlatoRequest> requestsPlatos;

    public void setRequestsPlatos(List<StructPlatoRequest> requestsPlatos) {

    }
}
