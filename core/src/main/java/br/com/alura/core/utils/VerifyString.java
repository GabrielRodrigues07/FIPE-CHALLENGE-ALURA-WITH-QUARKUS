package br.com.alura.core.utils;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;

import static br.com.alura.model.domain.enums.VehicleEnum.*;

public class VerifyString {


    public static String removeAcentos(String str) {
        // Normaliza para decompor os caracteres acentuados em caracteres base + diacríticos
        String normalizedStr = Normalizer.normalize(str, Normalizer.Form.NFD);
        // Remove os caracteres diacríticos (acentos)
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizedStr).replaceAll("");
    }

    public static List<String> vehicles() {
        return List.of(CAR.getVehicle(), TRUCK.getVehicle(), MOTORCYCLE.getVehicle());
    }
}
