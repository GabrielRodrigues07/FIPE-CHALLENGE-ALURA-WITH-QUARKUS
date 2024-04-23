package br.com.alura.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldNameConstants
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelsVehicle {

    @JsonProperty(value = "modelos")
    List<ModelsResponse> models;
    @JsonProperty(value = "anos")
    List<VehicleResponse> years;
}
