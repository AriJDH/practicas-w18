package com.manejoExcepcionesVivo.youtuber.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlog {

	private Long id;
	private String titulo;
	private String autor;
	private Date fechaPublicacion;
	

}
