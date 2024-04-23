package br.com.alura.core;

import br.com.alura.core.service.ConsumerApi;
import br.com.alura.core.service.ConvertApi;
import br.com.alura.core.utils.VerifyString;
import br.com.alura.model.domain.ModelsResponse;
import br.com.alura.model.domain.ModelsVehicle;
import br.com.alura.model.domain.VehicleFipe;
import br.com.alura.model.domain.VehicleResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static final Scanner SCANNER = new Scanner(System.in);

    static final ConsumerApi CONSUMER_API = new ConsumerApi();

    static final ConvertApi CONVERT_API = new ConvertApi();

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        System.out.println("Dígite o veículo que deseja buscar(carros, caminhoes ou motos): ");

        String veiculo = SCANNER.nextLine();

        while (!VerifyString.vehicles().contains(VerifyString.removeAcentos(veiculo.toLowerCase()))) {
            System.out.println("Dígite um desses veículos: carros, caminhoes ou motos");
            veiculo = SCANNER.nextLine();
        }

        String vehicleMarksUrl = "https://parallelum.com.br/fipe/api/v1/" + veiculo + "/marcas";

        String jsonMarks = CONSUMER_API.obterDados(vehicleMarksUrl);

        List<VehicleResponse> vehicleResponse = CONVERT_API.convertDataToList(jsonMarks, VehicleResponse.class);

        vehicleResponse.forEach(System.out::println);

        System.out.println("Escolha uma marca usando o código apresentado");

        int codeMark = SCANNER.nextInt();

        String vehicleModelsUrl = vehicleMarksUrl + "/" + codeMark + "/modelos";

        String jsonModels = CONSUMER_API.obterDados(vehicleModelsUrl);

        ModelsVehicle modelsVehicle = CONVERT_API.convertData(jsonModels, ModelsVehicle.class);
        System.out.println(objectMapper.writeValueAsString(modelsVehicle));

        System.out.println("Digite um trecho do modelo que você deseja visualizar");

        SCANNER.nextLine();
        String s = SCANNER.nextLine();

        List<ModelsResponse> modelsFilters = modelsVehicle.getModels().stream()
                .filter(modelsResponse -> modelsResponse.getName().toLowerCase().contains(s.toLowerCase()))
                .collect(Collectors.toList());

        modelsFilters.forEach(System.out::println);

        System.out.println("Dígite o código do modelo que deseja visualizar: ");

        int modelCode = SCANNER.nextInt();

        String modelUrl = vehicleModelsUrl + "/"+ modelCode + "/anos";

        String jsonModel = CONSUMER_API.obterDados(modelUrl);

        List<VehicleResponse> vehicleResponses = CONVERT_API.convertDataToList(jsonModel, VehicleResponse.class);

        vehicleResponses.forEach(System.out::println);

        vehicleResponses.forEach(e -> {
            String yearUrl = modelUrl + "/" + e.getCode();
            String jsonVehicle = CONSUMER_API.obterDados(yearUrl);
            VehicleFipe vehicleFipe = CONVERT_API.convertData(jsonVehicle, VehicleFipe.class);
            try {
                System.out.println(objectMapper.writeValueAsString(vehicleFipe));
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }

        });



        SCANNER.close();
    }
}