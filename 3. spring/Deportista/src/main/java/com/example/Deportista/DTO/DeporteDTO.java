package com.example.Deportista.DTO;

import com.example.Deportista.entity.Deporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeporteDTO {

    ArrayList<Deporte> deportes = new ArrayList();



}
