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
public class VehicleResponse {

    @JsonProperty(value = "codigo")
    private String code;
    @JsonProperty(value = "nome")
    private String name;
}
