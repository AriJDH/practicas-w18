package com.manejoExcepcionesVivo.youtuber.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.LocalDate;
import java.util.Date;

@Data
public class EntradaBlogDTO {
	
	private Long id;
	private String titulo;
	private String autor;
	@JsonFormat(pattern =  "yyyy-MM-dd")
	private Date fechaPublicacion;

}

