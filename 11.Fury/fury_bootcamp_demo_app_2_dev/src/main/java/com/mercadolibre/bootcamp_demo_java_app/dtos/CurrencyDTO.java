package com.mercadolibre.bootcamp_demo_java_app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDTO {
	@JsonProperty("currency_base")
    private CurrencyEnum currencyBase;

    @JsonProperty("currency_quote")
    private CurrencyEnum currencyQuote;

	@JsonProperty("ratio")
    private Double ratio;
	
	@JsonProperty("rate")
    private Double rate;
	
	@JsonProperty("inv_rate")
    private Double invRate;

    @JsonProperty("creation_date")
    private Date creationDate;

    @JsonProperty("valid_until")
    private Date validUntil;

}