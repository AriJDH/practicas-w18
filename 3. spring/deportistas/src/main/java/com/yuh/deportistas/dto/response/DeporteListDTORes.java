package com.yuh.deportistas.dto.response;

import com.yuh.deportistas.entity.Deporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeporteListDTORes {
    private List<String> deporteNameList;
}
