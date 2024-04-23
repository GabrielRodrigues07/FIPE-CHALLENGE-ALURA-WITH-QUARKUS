package br.com.alura.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldNameConstants
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleFipe {

    @JsonProperty(value = "TipoVeiculo")
    private Integer typeVehicle;
    @JsonProperty(value = "Valor")
    private String value;
    @JsonProperty(value = "Marca")
    private String mark;
    @JsonProperty(value = "Modelo")
    private String model;
    @JsonProperty(value = "AnoModelo")
    private Integer modelYear;
    @JsonProperty(value = "Combustivel")
    private String fuel;
    @JsonProperty(value = "CodigoFipe")
    private String fipeCode;
    @JsonProperty(value = "MesReferencia")
    private String referenceMonth;
    @JsonProperty(value = "SiglaCombustivel")
    private String fuelAcronym;
}
